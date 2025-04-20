import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<String> column = List.of("code", "date", "maximum", "remain");

        int extIndex = column.indexOf(ext);
        int sortIndex = column.indexOf(sort_by);

        return Arrays.stream(data)
            .filter(f -> f[extIndex] < val_ext)
            .sorted(Comparator.comparingInt(s -> s[sortIndex]))
            .toArray(int[][]::new);
    }
}