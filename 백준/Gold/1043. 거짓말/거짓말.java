import java.util.*;
import java.io.*;

class Main {

    static int[] parent;
    static boolean[] truthKnown;
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int trustCnt = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        truthKnown = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
        
        List<Integer> truthPeople = new ArrayList<>();
        for (int i = 0; i < trustCnt; i++) {
            int person = Integer.parseInt(st.nextToken());
            truthPeople.add(person);
            truthKnown[person] = true;
        }

        List<List<Integer>> parties = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            List<Integer> party = new ArrayList<>();
            
            int firstPerson = -1;
            for (int j = 0; j < cnt; j++) {
                int person = Integer.parseInt(st.nextToken());
                party.add(person);
                
                if (firstPerson != -1) {
                    union(firstPerson, person);
                }
                firstPerson = person;
            }
            parties.add(party);
        }

        for (int person : truthPeople) {
            int root = find(person);
            truthKnown[root] = true;
        }
        
        int lieCount = 0;
        for (List<Integer> party : parties) {
            boolean canLie = true;
            for (int person : party) {
                if (truthKnown[find(person)]) {
                    canLie = false;
                    break;
                }
            }
            if (canLie) lieCount++;
        }

        System.out.println(lieCount);
    }

    public static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    public static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            parent[rootB] = rootA;
        }
    }
}