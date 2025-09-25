import java.util.*;

class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length]; // 항상 5
        for (int i = 0; i < places.length; i++) {
            answer[i] = isSafePlace(places[i]) ? 1 : 0;
        }
        return answer;
    }

    private boolean isSafePlace(String[] place) {
        // 5x5 고정
        for (int r = 0; r < 5; r++) {
            for (int c = 0; c < 5; c++) {
                if (place[r].charAt(c) != 'P') continue;

                // 1) 맨해튼 거리 1 (상하좌우)
                int[] dr4 = {-1, 1, 0, 0};
                int[] dc4 = {0, 0, -1, 1};
                for (int k = 0; k < 4; k++) {
                    int nr = r + dr4[k], nc = c + dc4[k];
                    if (in(nr, nc) && place[nr].charAt(nc) == 'P') return false;
                }

                // 2) 맨해튼 거리 2 - 직선(상하좌우로 2칸)
                for (int k = 0; k < 4; k++) {
                    int nr = r + 2 * dr4[k], nc = c + 2 * dc4[k];
                    int mr = r + dr4[k],     mc = c + dc4[k]; // 중간칸
                    if (in(nr, nc) && place[nr].charAt(nc) == 'P') {
                        // 중간칸이 칸막이 X가 아니면 위반
                        if (place[mr].charAt(mc) != 'X') return false;
                    }
                }

                // 3) 맨해튼 거리 2 - 대각선
                int[] drD = {-1, -1, 1, 1};
                int[] dcD = {-1,  1,-1, 1};
                for (int k = 0; k < 4; k++) {
                    int nr = r + drD[k], nc = c + dcD[k];
                    if (!in(nr, nc) || place[nr].charAt(nc) != 'P') continue;

                    // 대각선은 인접한 두 칸(가로/세로)이 모두 칸막이여야 안전
                    int ar1 = r,         ac1 = c + dcD[k]; // 가로 인접
                    int ar2 = r + drD[k], ac2 = c;         // 세로 인접
                    if (place[ar1].charAt(ac1) != 'X' || place[ar2].charAt(ac2) != 'X') {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean in(int r, int c) {
        return 0 <= r && r < 5 && 0 <= c && c < 5;
    }
}
