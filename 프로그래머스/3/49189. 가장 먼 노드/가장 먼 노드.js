function solution(n, edge) {
    let graph = [];
    for(let i = 0; i <= n; i++){
        graph.push([]);
    }
    
    for(let i = 0; i < edge.length; i++){
        let a = edge[i][0];
        let b = edge[i][1];
        graph[a].push(b);
        graph[b].push(a);
    }
    
    let visited = Array(n+1).fill(0);
    visited[1] = 1;
    
    let q = [];
    q.push([1, 1]);
    
    let max = 0;
    
    while(q.length > 0){
        let now = q.shift();
        
        for(const num of graph[now[0]]){
            if(visited[num] === 0){
                q.push([num, now[1]+1]);
                max = Math.max(now[1]+1, max);
                visited[num] = now[1]+1;
            }
        }
    }
    
    let answer = 0;
    for(const v of visited){
        if(max === v){
            answer++;
        }
    }
    return answer;
}