import java.util.*;

class Solution {
    List<Set<Integer>> candidateKeys = new ArrayList<>();
    int colSize;

    public int solution(String[][] relation) {
        colSize = relation[0].length;

        for (int i = 1; i <= colSize; i++) {
            getCombinations(0, 0, i, new HashSet<>(), relation);
        }

        return candidateKeys.size();
    }

    private void getCombinations(int depth, int start, int r, Set<Integer> comb, String[][] relation) {
        if (depth == r) {
            if (isUnique(comb, relation) && isMinimal(comb)) {
                candidateKeys.add(new HashSet<>(comb));
            }
            return;
        }

        for (int i = start; i < colSize; i++) {
            comb.add(i);
            getCombinations(depth + 1, i + 1, r, comb, relation);
            comb.remove(i);
        }
    }

    private boolean isUnique(Set<Integer> comb, String[][] relation) {
        Set<String> tuples = new HashSet<>();

        for (String[] row : relation) {
            StringBuilder sb = new StringBuilder();
            for (int idx : comb) {
                sb.append(row[idx]).append(",");
            }
            tuples.add(sb.toString());
        }

        return tuples.size() == relation.length;
    }

    private boolean isMinimal(Set<Integer> comb) {
        for (Set<Integer> key : candidateKeys) {
            if (comb.containsAll(key)) return false;
        }
        return true;
    }
}
