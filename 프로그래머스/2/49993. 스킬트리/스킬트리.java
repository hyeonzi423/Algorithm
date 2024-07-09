class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0; 
        for (String one : skill_trees){
            StringBuilder check = new StringBuilder();
            for(int i = 0; i < one.length(); i++){
                Character c = one.charAt(i);
                if(skill.contains(Character.toString(c))){
                    check.append(c);
                }
            }
            if(skill.startsWith(check.toString())){
                answer++;
            } 
        }   
        return answer;
    }
}