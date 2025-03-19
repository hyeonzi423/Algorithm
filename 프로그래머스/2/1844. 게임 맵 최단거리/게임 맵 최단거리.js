function solution(maps) {
    
    const dx = [-1, 0, 1, 0];
    const dy = [0, 1, 0, -1];
    const N = maps.length;
    const M = maps[0].length;
    const visited = Array.from({length : N}, () => Array(M).fill(false));
    
    const queue = [];
    queue.push([0, 0, 1]);
    visited[0][0] = true;
    
    while(queue.length > 0){
        const [x, y, dis] = queue.shift();
        
        if(x === N-1 && y === M-1) return dis;
        
        for(let i = 0; i < 4; i++){
            const nx = x + dx[i];
            const ny = y + dy[i];
            
            if(nx < 0 || nx >= N || ny < 0 || ny >= M){
                continue;
            }if(maps[nx][ny] == 0 || visited[nx][ny] === true){
                continue;
            }
            queue.push([nx, ny, dis + 1]);
            visited[nx][ny] = true;
        }
    }
    
    return -1;
}