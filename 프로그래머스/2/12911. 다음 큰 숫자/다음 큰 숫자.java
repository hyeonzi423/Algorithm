class Solution {
    public int solution(int n) {
        int one = Integer.bitCount(n);

        int answer = n + 1;
        while (true) {
            if (Integer.bitCount(answer) == one) {
                return answer;
            }
            answer++;
        }
    }
}
