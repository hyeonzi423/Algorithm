class Solution {
    public int[] solution(int[] numbers, int num1, int num2) {
        int[] answer = new int[num2-num1+1];
        int i;
        int k = 0;
        for (i = num1; i < num2+1; i++){
            answer[k++] = numbers[i];
        }
        return answer;
    }
}