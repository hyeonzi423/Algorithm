function solution(clothes) {
    const map = new Map();
    
    for(const [item, kind] of clothes){
        map.set(kind, (map.get(kind) || 0) + 1);
    }
    
    var answer = 1;
    for(const [key, value] of map){
        answer *= (1 + value);
    }
    return answer - 1;
}