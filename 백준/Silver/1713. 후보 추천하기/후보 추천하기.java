import java.util.*;
import java.io.*;

public class Main {

    public static class Student implements Comparable<Student> {
        int id;
        int count;
        int time;

        public Student(int id, int count, int time) {
            this.id = id;
            this.count = count;
            this.time = time;
        }

        @Override
        public int compareTo(Student o) {
            if (this.count == o.count) {
                return this.time - o.time;
            }
            return this.count - o.count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));    
        int N = Integer.parseInt(br.readLine()); // 사진틀 개수
        int R = Integer.parseInt(br.readLine()); // 총 추천 수

        int[] students = new int[R];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < R; i++) {
            students[i] = Integer.parseInt(st.nextToken());
        }

        List<Student> frame = new ArrayList<>();

        for (int i = 0; i < R; i++) {
            int id = students[i];
            boolean exists = false;

            for (Student s : frame) {
                if (s.id == id) {
                    s.count++;
                    exists = true;
                    break;
                }
            }

            if (exists) continue;

            // 없는 경우
            if (frame.size() == N) {
                Collections.sort(frame); // 추천 수 + 시간 기준 정렬
                frame.remove(0); // 가장 추천 적고 오래된 학생 제거
            }

            frame.add(new Student(id, 1, i)); // 새 학생 추가
        }

        frame.sort(Comparator.comparingInt(s -> s.id));
        for (Student s : frame) {
            System.out.print(s.id + " ");
        }
    }
}
