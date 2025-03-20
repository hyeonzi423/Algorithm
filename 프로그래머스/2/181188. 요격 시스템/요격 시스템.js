function solution(targets) {
    targets.sort((a, b) => (a[1] - b[1]));
    
    let last = targets[0][1];
    let answer = 1;
    
    for(let i = 1; i < targets.length; i++){
        if(last <= targets[i][0]){
            answer++;
            last = targets[i][1];
        }
    }
    return answer;
}