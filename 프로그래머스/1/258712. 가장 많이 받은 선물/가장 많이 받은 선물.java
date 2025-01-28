import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int n = friends.length;
        HashMap<String, Integer> nameToIndex = new HashMap<>();
        for (int i = 0; i < n; i++) {
            nameToIndex.put(friends[i], i);
        }

        int[][] giftMatrix = new int[n][n];
        int[] givenGifts = new int[n];
        int[] receivedGifts = new int[n];

        for (String g : gifts) {
            StringTokenizer st = new StringTokenizer(g);
            String giver = st.nextToken();
            String receiver = st.nextToken();

            int giverIndex = nameToIndex.get(giver);
            int receiverIndex = nameToIndex.get(receiver);

            giftMatrix[giverIndex][receiverIndex]++;
            givenGifts[giverIndex]++;
            receivedGifts[receiverIndex]++;
        }

        int[] giftScores = new int[n];
        for (int i = 0; i < n; i++) {
            giftScores[i] = givenGifts[i] - receivedGifts[i];
        }

        int[] nextMonthGifts = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (giftMatrix[i][j] > giftMatrix[j][i]) {
                    nextMonthGifts[i]++;
                } else if (giftMatrix[i][j] < giftMatrix[j][i]) {
                    nextMonthGifts[j]++;
                } else {
                    if (giftScores[i] > giftScores[j]) {
                        nextMonthGifts[i]++;
                    } else if (giftScores[i] < giftScores[j]) {
                        nextMonthGifts[j]++;
                    }
                }
            }
        }

        int maxGifts = 0;
        for (int giftsCount : nextMonthGifts) {
            maxGifts = Math.max(maxGifts, giftsCount);
        }

        return maxGifts;
    }
}
