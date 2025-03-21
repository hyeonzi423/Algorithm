function solution(clothes) {
    var cloth = new Map();
    clothes.forEach(c => {
        if(!cloth.has(c[1])){
            cloth.set(c[1], []);
        }
        cloth.get(c[1]).push(c[0]);
    })
    
    var answer = 1;
    for(const [kind, list] of cloth){
        answer *= (1 + list.length);
    }
    
    return answer - 1;
}