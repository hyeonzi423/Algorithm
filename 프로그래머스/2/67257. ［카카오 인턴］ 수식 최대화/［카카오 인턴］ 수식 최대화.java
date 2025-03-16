import java.util.*;

class Solution {
    static char[][] operatorOrders = {
        {'+', '-', '*'}, {'+', '*', '-'},
        {'-', '+', '*'}, {'-', '*', '+'},
        {'*', '+', '-'}, {'*', '-', '+'}
    };
    
    public long solution(String expression) {
        List<Long> numbers = new ArrayList<>();
        List<Character> operators = new ArrayList<>();
        
        parseExpression(expression, numbers, operators);
        
        long maxResult = 0;
        for (char[] order : operatorOrders) {
            List<Long> numCopy = new ArrayList<>(numbers);
            List<Character> opCopy = new ArrayList<>(operators);
            long result = calculate(numCopy, opCopy, order);
            maxResult = Math.max(maxResult, Math.abs(result));
        }
        
        return maxResult;
    }
    
    private void parseExpression(String expression, List<Long> numbers, List<Character> operators) {
        StringBuilder num = new StringBuilder();
        
        for (char ch : expression.toCharArray()) {
            if (Character.isDigit(ch)) {
                num.append(ch);
            } else {
                numbers.add(Long.parseLong(num.toString()));
                num.setLength(0);
                operators.add(ch);
            }
        }
        numbers.add(Long.parseLong(num.toString()));
    }
    
    private long calculate(List<Long> numbers, List<Character> operators, char[] order) {
        for (char op : order) {
            for (int i = 0; i < operators.size(); i++) {
                if (operators.get(i) == op) {
                    long result = operate(numbers.get(i), numbers.get(i + 1), op);
                    
                    numbers.set(i, result);
                    numbers.remove(i + 1);
                    operators.remove(i);
                    
                    i--;
                }
            }
        }
        return numbers.get(0);
    }
    
    private long operate(long a, long b, char op) {
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            default: throw new IllegalArgumentException("Invalid operator");
        }
    }
}
