class Solution {
    public int solution(int storey) {
        int ans = 0;
        int carry = 0;
        
        while(storey > 0){
            int digit = (storey % 10) + carry;
            int nextDigit = (storey / 10) % 10;
            
            if(digit < 5){
                ans += digit;
                carry = 0;
            }else if(digit > 5){
                ans += (10 - digit);
                carry = 1;
            }else{
                if(nextDigit >= 5){
                    ans += (10 - digit);
                    carry = 1;
                }else{
                    ans += digit;
                    carry = 0;
                }
            }
            storey /= 10;
        }
        
        if(carry == 1){
            ans++;
        }
        return ans;
    }
}