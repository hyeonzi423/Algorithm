import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        Arrays.sort(numbers);
        String[] nums = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++){
            nums[i] = numbers[i] + "";
        }
        Arrays.sort(nums, (a, b) -> (b + a).compareTo(a + b));
        for(String n : nums){
            answer += n;
        }
        if(answer.charAt(0) == '0'){
            return "0";
        }
        return answer;
    }
}