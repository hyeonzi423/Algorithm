function solution(number, k) {
    const stack = [];
    
    for(let i = 0; i < number.length; i++){
        while(stack.length > 0 && k > 0 && stack[stack.length-1] < number[i]){
            stack.pop();
            k--;
        }
        stack.push(number[i]);
    }
    
    while(k > 0){
        stack.pop();
        k--; 
    }
    
    var answer = stack.join("");
    return answer;
}