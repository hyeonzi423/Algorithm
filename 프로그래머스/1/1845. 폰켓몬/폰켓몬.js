function solution(nums) {
    const map = new Map();
    
    for(const n of nums){
        map.set(n, (map.get(n) || 0) + 1);
    }
    
    return map.size > nums.length/2 ? nums.length/2 : map.size;
}