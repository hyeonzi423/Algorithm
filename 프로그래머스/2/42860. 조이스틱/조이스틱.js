function solution(name) {
    let answer = 0;
    const n = name.length;
    let move = n - 1;

    for (let i = 0; i < n; i++) {
        // 위아래 조작 최소값 계산 (A에서 해당 문자까지 or Z에서 해당 문자까지 + 1)
        answer += Math.min(
            name.charCodeAt(i) - 'A'.charCodeAt(0),
            'Z'.charCodeAt(0) - name.charCodeAt(i) + 1
        );

        let next = i + 1;
        // 연속된 A의 끝까지 탐색
        while (next < n && name.charAt(next) === 'A') {
            next++;
        }

        // 좌우 이동 최소값 계산
        move = Math.min(move, i + n - next + Math.min(i, n - next));
    }

    return answer + move;
}
