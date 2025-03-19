function solution(s){
    let left = 0;
    for(let i = 0; i < s.length; i++){
        if(s[i] === '('){
            left++;
        }else{
            if(left === 0){
                return false;
            }
            left--;
        }
    }
    return left === 0;
}