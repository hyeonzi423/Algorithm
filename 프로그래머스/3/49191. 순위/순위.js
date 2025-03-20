function solution(n, results) {
    let score = Array.from({ length : n+1 }, () => Array(n+1).fill(0));
    for(const r of results){
        score[r[0]][r[1]] = 1;
        score[r[1]][r[0]] = -1;
    }
    
    for(let k = 1; k <= n; k++){
        for(let i = 1; i <= n; i++){
            for(let j = 1; j <= n; j++){
                if(score[i][k] === 1 && score[k][j] === 1){
                    score[i][j] = 1;
                }else if(score[i][k] === -1 && score[k][j] === -1){
                    score[i][j] = -1;
                }
            }
        }
    }
    
    let answer = 0;
    for(let i = 1; i <= n; i++){
        let cnt = 0;
        for(let j = 1; j <= n; j++){
            if(score[i][j] != 0){
                cnt++;
            }
        }
        if(cnt === n-1){
            answer++;
        }
    }
    return answer;
}