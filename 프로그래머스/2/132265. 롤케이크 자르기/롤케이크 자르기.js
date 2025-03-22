function solution(topping) {
    var old = new Map();
    var young = new Map();
    
    for(let i = 0; i < topping.length; i++){
        if(!young.has(topping[i])){
            young.set(topping[i], 0);
        }
        young.set(topping[i], young.get(topping[i]) + 1);
    }
    
    var answer = 0;
    for(let i = 0; i < topping.length; i++){
        if(young.get(topping[i]) === 1){
            young.delete(topping[i]);
        }else{
            young.set(topping[i], young.get(topping[i]) - 1);
        }
        
        if(!old.has(topping[i])){
            old.set(topping[i], 0);
        }
        old.set(topping[i], young.get(topping[i]) + 1);
        
        if(old.size === young.size){
            answer++;
        }
    }
    
    return answer;
}