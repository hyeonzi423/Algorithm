function solution(n, computers) {
    let graph = Array.from({ length : n}, () => new Set());
    for(let i = 0; i < n; i++){
        for(let j = 0; j < n; j++){
            if(i != j && computers[i][j] === 1){
                graph[i].add(j);
                graph[j].add(i);
            }
        }
    }
    
    let ans = 0;
    let q = [];
    let visited = Array(n).fill(false);
    for(let i = 0; i < n; i++){
        if(!visited[i]){
            q.push(i);
            ans++;
            while(q.length > 0){
                let now = q.shift();
                for(const num of graph[now]){
                    if(!visited[num]){
                        q.push(num);
                        visited[num] = true;
                    }
                }
            }
        }
    }
    return ans;
}