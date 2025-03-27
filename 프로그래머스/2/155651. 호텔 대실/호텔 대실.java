import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        Arrays.sort(book_time, (a, b) -> {
            if (a[0].equals(b[0])) return a[1].compareTo(b[1]);
            return a[0].compareTo(b[0]);
        });

        PriorityQueue<Integer> rooms = new PriorityQueue<>();

        for (String[] time : book_time) {
            int start = toMinute(time[0]);
            int end = toMinute(time[1]) + 10;

            if (!rooms.isEmpty() && rooms.peek() <= start) {
                rooms.poll();
            }

            rooms.offer(end);
        }

        return rooms.size();
    }

    private int toMinute(String time) {
        String[] t = time.split(":");
        return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
    }
}
