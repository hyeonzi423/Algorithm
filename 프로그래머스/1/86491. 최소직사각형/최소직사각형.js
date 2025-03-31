function solution(sizes) {
    let maxX = 0;
    let maxY = 0;
    for(let [a, b] of sizes){
        if(a > b){
            let tmp = a;
            a = b;
            b = tmp;
        }
        maxX = Math.max(maxX, a);
        maxY = Math.max(maxY, b);
    }
    return maxX * maxY;
}