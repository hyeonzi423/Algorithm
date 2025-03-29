function solution(data, col, row_begin, row_end) {
    data.sort((a, b) => {
        if(a[col-1] === b[col-1]){
            return b[0] - a[0];
        }
        return a[col-1] - b[col-1];
    })
    
    var answer = 0;
    for(let i = row_begin - 1; i < row_end; i++){
        let sum = 0;
        for(const num of data[i]){
            sum += num % (i + 1);
        }
        answer ^= sum;
    }
    return answer;
}