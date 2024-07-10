import java.util.*;
class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        for(int i = 1; i < elements.length + 1; i++){
            for(int j = 0; j < elements.length; j++){
                int tmp = 0;
                for(int k = j; k < j + i; k++){
                    tmp += elements[k % elements.length];
                }
                set.add(tmp);
            }
        }
        return set.size();
    }
}