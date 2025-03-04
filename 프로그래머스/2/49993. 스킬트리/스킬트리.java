class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for(String s : skill_trees){
            StringBuilder check = new StringBuilder();
            for(int i = 0; i < s.length(); i++){
                if(skill.contains(s.charAt(i) + "")){
                    check.append(s.charAt(i));
                }
            }
            if(skill.startsWith(check.toString())){
                answer++;
            }
        }
        return answer;
    }
}