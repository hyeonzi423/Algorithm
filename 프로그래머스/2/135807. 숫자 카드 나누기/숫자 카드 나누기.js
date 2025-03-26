function solution(arrayA, arrayB) {
    function gcd(a, b) {
        while (b !== 0) {
            let temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    function getGCD(arr) {
        return arr.reduce((acc, cur) => gcd(acc, cur), arr[0]);
    }

    function isNotDivisible(arr, num) {
        return arr.every(value => value % num !== 0);
    }

    let gcdA = getGCD(arrayA);
    let gcdB = getGCD(arrayB);

    let result = 0;
    
    if (isNotDivisible(arrayB, gcdA)) {
        result = Math.max(result, gcdA);
    }
    if (isNotDivisible(arrayA, gcdB)) {
        result = Math.max(result, gcdB);
    }

    return result;
}
