function solution(book_time) {
    book_time.sort((a, b) => {
        if (a[0] === b[0]) return a[1].localeCompare(b[1]);
        return a[0].localeCompare(b[0]);
    });
    
    function toMinute(time){
        const [h, m] = time.split(":").map(Number);
        return h * 60 + m;
    }
    
    var rooms = [];
    for (const [startStr, endStr] of book_time) {
        const start = toMinute(startStr);
        const end = toMinute(endStr) + 10;
        
        let flag = false;
        for(let i = 0; i < rooms.length; i++){
            if(rooms[i] <= start){
                flag = true;
                rooms[i] = end;
                break;
            }
        }
        if(!flag){
            rooms.push(end);
        }
    }
    
    return rooms.length;
}