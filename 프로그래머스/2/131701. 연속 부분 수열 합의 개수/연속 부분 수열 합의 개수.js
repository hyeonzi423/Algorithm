function solution(elements) {
    var answer = new Set();
    for(let size = 1; size <= elements.length; size++){
        for(let start = 0; start < elements.length; start++){
            let tmp = 0;
            for(let idx = start; idx < start + size; idx++){
                tmp += elements[idx % elements.length];
            }
            answer.add(tmp);
        }
    }
    return answer.size;
}