function solution(numbers) {
    const digit = numbers.split('');
    const visited = new Array(digit.length).fill(false);
    const numSet = new Set();
    
    function dfs(path){
        if(path.length > 0){
            const num = parseInt(path.join(''), 10);
            numSet.add(num);
        }
        
        for(let i = 0; i < digit.length; i++){
            if(visited[i]) continue;
            
            visited[i] = true;
            path.push(digit[i]);
            
            dfs(path);
            
            visited[i] = false;
            path.pop();
        }
    }
    
    dfs([]);
    
    function isPrime(num){
        if(num < 2) return false;
        for(let i = 2; i <= Math.sqrt(num); i++){
            if(num % i === 0){
                return false;
            }
        }
        return true;
    }
    
    let answer = 0;
    numSet.forEach(num => {
        if(isPrime(num)) answer++;
    });
    
    return answer;
}