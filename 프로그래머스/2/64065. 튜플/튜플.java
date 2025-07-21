import java.util.*;

class Solution {
    public int[] solution(String s) {
        // 양쪽 {{, }} 제거
        s = s.substring(2, s.length() - 2);
        
        // 집합 단위로 자르기
        String[] sets = s.split("},\\{");

        // 정렬 (길이 기준)
        Arrays.sort(sets, Comparator.comparingInt(String::length));

        List<Integer> answer = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();

        for (String set : sets) {
            String[] nums = set.split(",");
            for (String num : nums) {
                int n = Integer.parseInt(num);
                if (!seen.contains(n)) {
                    seen.add(n);
                    answer.add(n);
                }
            }
        }

        // List -> int[]
        return answer.stream().mapToInt(i -> i).toArray();
    }
}
