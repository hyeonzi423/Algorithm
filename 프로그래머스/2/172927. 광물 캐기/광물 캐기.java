import java.util.*;

class Solution {
    public int solution(int[] pickCounts, String[] minerals) {
        int fatigue = 0;

        int dPick = pickCounts[0];
        int iPick = pickCounts[1];
        int sPick = pickCounts[2];

        int totalPicks = dPick + iPick + sPick;
        int m = minerals.length;

        int groupCount = Math.min(totalPicks, (m + 4) / 5);
        int[][] groups = new int[groupCount][6];

        for (int i = 0, g = 0; i < Math.min(totalPicks * 5, m); i += 5, g++) {
            int groupScore = 0;

            for (int j = i; j < Math.min(i + 5, m); j++) {
                int weight = 0;
                switch (minerals[j]) {
                    case "diamond": weight = 25; break;
                    case "iron":    weight = 5;  break;
                    case "stone":   weight = 1;  break;
                }
                groupScore += weight;
                groups[g][(j - i) + 1] = weight;
            }
            groups[g][0] = groupScore;
        }

        Arrays.sort(groups, (a, b) -> Integer.compare(b[0], a[0]));

        for (int i = 0; i < groupCount; i++) {
            String pickType;
            if (dPick-- > 0)       pickType = "diamond";
            else if (iPick-- > 0)  pickType = "iron";
            else { sPick--;         pickType = "stone"; }

            int[] g = groups[i];
            for (int k = 1; k <= 5; k++) {
                switch (pickType) {
                    case "diamond": fatigue += (int) Math.ceil(g[k] / 25.0); break;
                    case "iron":    fatigue += (int) Math.ceil(g[k] / 5.0);  break;
                    case "stone":   fatigue += g[k];                          break;
                }
            }
        }

        return fatigue;
    }
}