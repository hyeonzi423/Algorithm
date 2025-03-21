function solution(n, times) {
    var max = 0;
    times.forEach(t => {
        max = Math.max(max, t);
    })
    
    var left = 1;
    var right = max * n;
    while(left < right){
        var mid = parseInt((left + right) / 2);
        
        let cnt = 0;
        times.forEach(t => {
            cnt += parseInt(mid / t);
        })
        
        if(cnt < n){
            left = mid + 1;
        }else{
            right = mid;
        }
    }
    
    return right;
}