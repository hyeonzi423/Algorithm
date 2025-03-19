function solution(want, number, discount) {
    const map = new Map();
    const days = 10;
    const wantSize = want.length;
    let answer = 0;

    for (let i = 0; i < days; i++) {
        map.set(discount[i], (map.get(discount[i]) ?? 0) + 1);
    }

    function isValid() {
        for (let i = 0; i < wantSize; i++) {
            if ((map.get(want[i]) ?? 0) < number[i]) return false;
        }
        return true;
    }

    if (isValid()) answer++;

    for (let i = days; i < discount.length; i++) {
        let removeItem = discount[i - days];
        let cnt = map.get(discount[i-days]) - 1;
        if(cnt == 0){
            map.delete(discount[i-days]);
        }else{
            map.set(discount[i-days], cnt);
        }

        let newItem = discount[i];
        map.set(newItem, (map.get(newItem) ?? 0) + 1);

        if (isValid()) answer++;
    }

    return answer;
}
