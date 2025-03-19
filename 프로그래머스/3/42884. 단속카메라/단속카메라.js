function solution(routes) {
    routes.sort((a, b) => (a[1] - b[1]));
    
    let ans = 1;
    let camera = routes[0][1];
    
    for(let i = 1; i < routes.length; i++){
        if(camera < routes[i][0]){
            camera = routes[i][1];
            ans++;
        }
    }
    return ans;
}