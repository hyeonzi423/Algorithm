class Solution {
    int maxJoin = 0;
    int maxSales = 0;
    int[][] users;
    int[] emoticons;
    
    public int[] solution(int[][] users, int[] emoticons) {
        this.users = users;
        this.emoticons = emoticons;

        int[] discounts = new int[emoticons.length];
        int[] rates = {10, 20, 30, 40};

        dfs(0, discounts, rates);

        return new int[]{maxJoin, maxSales};
    }
    
    public void dfs(int cnt, int[] discounts, int[] rates){
        if(cnt == emoticons.length){
            calculate(discounts);
            return;
        }
        
        for(int rate: rates){
            discounts[cnt] = rate;
            dfs(cnt + 1, discounts, rates);
        }
    }
    
    public void calculate(int[] discounts){
        int join = 0;
        int sales = 0;
        
        for(int[] user : users){
            int per = user[0], limit = user[1];
            int sum = 0;
            
            for(int i = 0; i < emoticons.length; i++){
                if(discounts[i] >= per){
                    int discountedPrice = emoticons[i] * (100 - discounts[i]) / 100;
                    sum += discountedPrice;
                }
            }
            
            if(sum >= limit){
                join++;
            } else{
                sales += sum;
            }
            
            if(join > maxJoin || (join == maxJoin && sales > maxSales)){
                maxJoin = join;
                maxSales = sales;
            }
        }
    }
}