import java.util.ArrayList;

class Solution {
    public int solution(int[] numbers, int target) {
        ArrayList<Integer> list_n = new ArrayList<>();
        list_n.add(0);
        
        for (int i = 0; i < numbers.length; i++) {
            ArrayList<Integer> tmp = new ArrayList<>();
            for (int j : list_n) {
                tmp.add(j + numbers[i]);
                tmp.add(j - numbers[i]);
            }
            list_n.clear();
            list_n.addAll(tmp);
        }
        
        int answer = 0;
        for (int num : list_n) {
            if (num == target) {
                answer++;
            }
        }
        return answer;
    }
}
