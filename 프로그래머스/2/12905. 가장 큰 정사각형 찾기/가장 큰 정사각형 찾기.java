class Solution{
    public int solution(int [][]board){
        int answer = 1;
        if(zeroCheck(board)) return 0;
        
        for(int i = 1; i < board.length; i++){
            for(int j = 1; j < board[0].length; j++){
                if(board[i][j] == 0) continue;
                board[i][j] = Math.min(Math.min(board[i-1][j], board[i][j-1]), board[i-1][j-1]) + 1;
                answer = Math.max(answer, board[i][j]);
            }
        }
        
        return answer*answer;
    }
    
    public boolean zeroCheck(int [][]board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == 1){
                    return false;
                }
            }
        }
        return true;
    }
}