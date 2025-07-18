class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        String[] sp = s.toLowerCase().split("");
        boolean flag = true;

        for (String ss : sp) {
            if (flag) {
                answer.append(ss.toUpperCase());
            } else {
                answer.append(ss);
            }

            flag = ss.equals(" ");
        }

        return answer.toString();
    }
}
