import java.util.*;

class Solution {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    
    public int solution(int[][] game_board, int[][] table) {
        int n = game_board.length;
        List<List<int[]>> emptySpaces = new ArrayList<>();
        List<List<int[]>> puzzlePieces = new ArrayList<>();
        
        boolean[][] visited = new boolean[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (game_board[i][j] == 0 && !visited[i][j]) {
                    emptySpaces.add(bfs(i, j, game_board, visited, 0));
                }
            }
        }
        
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (table[i][j] == 1 && !visited[i][j]) {
                    puzzlePieces.add(bfs(i, j, table, visited, 1));
                }
            }
        }
        
        boolean[] used = new boolean[puzzlePieces.size()];
        int score = 0;
        
        for (List<int[]> space : emptySpaces) {
            for (int i = 0; i < puzzlePieces.size(); i++) {
                if (!used[i]) {
                    List<int[]> piece = puzzlePieces.get(i);
                    if (canFit(space, piece)) {
                        score += piece.size();
                        used[i] = true;
                        break;
                    }
                }
            }
        }
        
        return score;
    }
    
    private List<int[]> bfs(int x, int y, int[][] board, boolean[][] visited, int target) {
        Queue<int[]> queue = new LinkedList<>();
        List<int[]> result = new ArrayList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            result.add(cur);
            
            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];
                
                if (nx >= 0 && ny >= 0 && nx < board.length && ny < board.length) {
                    if (!visited[nx][ny] && board[nx][ny] == target) {
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }
        
        return normalize(result);
    }
    
    private List<int[]> normalize(List<int[]> block) {
        int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;
        for (int[] p : block) {
            minX = Math.min(minX, p[0]);
            minY = Math.min(minY, p[1]);
        }
        
        List<int[]> normalized = new ArrayList<>();
        for (int[] p : block) {
            normalized.add(new int[]{p[0] - minX, p[1] - minY});
        }
        
        normalized.sort((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        return normalized;
    }
    
    private boolean canFit(List<int[]> space, List<int[]> piece) {
        if (space.size() != piece.size()) return false;
        
        for (int r = 0; r < 4; r++) {
            piece = rotate(piece);
            if (match(space, piece)) return true;
        }
        
        return false;
    }
    
    private List<int[]> rotate(List<int[]> piece) {
        int maxX = 0, maxY = 0;
        for (int[] p : piece) {
            maxX = Math.max(maxX, p[0]);
            maxY = Math.max(maxY, p[1]);
        }
        
        List<int[]> rotated = new ArrayList<>();
        for (int[] p : piece) {
            rotated.add(new int[]{p[1], maxX - p[0]});
        }
        
        return normalize(rotated);
    }
    
    private boolean match(List<int[]> space, List<int[]> piece) {
        for (int i = 0; i < space.size(); i++) {
            if (space.get(i)[0] != piece.get(i)[0] || space.get(i)[1] != piece.get(i)[1]) {
                return false;
            }
        }
        return true;
    }
}
