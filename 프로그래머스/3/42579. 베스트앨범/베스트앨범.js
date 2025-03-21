function solution(genres, plays) {
    const map = new Map();

    for (let i = 0; i < genres.length; i++) {
        if (!map.has(genres[i])) {
            map.set(genres[i], []);
        }
        map.get(genres[i]).push([plays[i], i]);
    }

    const sorted = [...map.entries()]
    .sort((a, b) => {
        const totalA = a[1].reduce((sum, [play]) => sum + play, 0);
        const totalB = b[1].reduce((sum, [play]) => sum + play, 0);
        return totalB - totalA;
    });
    
    const answer = [];
    
    for(const [genres, songs] of sorted){
        const sortedSongs = songs.sort((a, b) => {
            if(b[0] != a[0]) return b[0] - a[0];
            return a[1] - b[1];
        });
        
        answer.push(sortedSongs[0][1]);
        if (sortedSongs.length > 1) {
            answer.push(sortedSongs[1][1]);
        }
    }
    return answer;
}
