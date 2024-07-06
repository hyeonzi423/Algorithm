import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int s: scoville){
            heap.add(s);
        }
        if(heap.peek() >= K){
            return 0;
        }
        while(true){
            if(heap.size() < 2){
                if(heap.peek() < K){
                    return -1;
                }
                break;
            }
            if(heap.peek() >= K){
                break;
            }
            int first = heap.poll();
            int second = heap.poll();
            heap.add(first + second*2);
            answer++;
        }
        return answer;
    }
}