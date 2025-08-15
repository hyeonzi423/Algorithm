class Solution {
    public int solution(String s) {
        int n = s.length();
        if (n == 1) return 1;

        int answer = n;
        for (int unit = 1; unit <= n / 2; unit++) {
            StringBuilder sb = new StringBuilder();
            String prev = s.substring(0, unit);
            int count = 1;
            int i;

            for (i = unit; i + unit <= n; i += unit) {
                String cur = s.substring(i, i + unit);
                if (cur.equals(prev)) {
                    count++;
                } else {
                    if (count > 1) sb.append(count);
                    sb.append(prev);
                    prev = cur;
                    count = 1;
                }
            }

            if (count > 1) sb.append(count);
            sb.append(prev);

            if (i < n) sb.append(s.substring(i));

            answer = Math.min(answer, sb.length());
        }
        return answer;
    }
}
