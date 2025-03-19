function solution(numbers) {
    const sorted = numbers.map(num => num.toString())
        .sort((a, b) => (b + a) - (a + b));

    const answer = sorted.join('');
    
    return answer[0] === '0' ? '0' : answer;
}