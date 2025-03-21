function solution(n, wires) {
    var graph = Array.from({ length : n+1 }, () => []);
    wires.forEach( wire => {
        graph[wire[0]].push(wire[1]);
        graph[wire[1]].push(wire[0]);
    })
    
    function bfs(start){
        var q = [];
        q.push(start);
        
        var visited = Array(n+1).fill(false);
        visited[start] = true;
        
        var count = 1;
        while(q.length > 0){
            var now = q.shift();
            graph[now].forEach(next => {
                if(!visited[next]){
                    q.push(next);
                    visited[next] = true;
                    count++;
                }
            })
        }
        return count;
    }
    
    var answer = n;
    wires.forEach( wire => {
        let a = wire[0];
        let b = wire[1];
        
        graph[a] = graph[a].filter(node => node !== b);
        graph[b] = graph[b].filter(node => node !== a);
        
        answer = Math.min(answer, Math.abs(bfs(a) - bfs(b)));
        
        graph[a].push(b);
        graph[b].push(a);
    })
    
    return answer;
}