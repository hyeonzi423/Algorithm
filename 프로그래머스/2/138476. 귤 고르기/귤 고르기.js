function solution(k, tangerine) {
    const countMap = new Map();

    for (let t of tangerine) {
        countMap.set(t, (countMap.get(t) || 0) + 1);
    }

    const sortedCounts = Array.from(countMap.values()).sort((a, b) => b - a);

    let total = 0;
    let kind = 0;

    for (let count of sortedCounts) {
        total += count;
        kind++;
        if (total >= k) break;
    }

    return kind;
}
