function solution(n) {
    let f0 = 0;
    let f1 = 1;
    let fn;
    
    for(let i = 2; i <= n; i++){
        fn = (f0 + f1) % 1234567;
        f0 = f1;
        f1 = fn;
    }
    return fn;
}