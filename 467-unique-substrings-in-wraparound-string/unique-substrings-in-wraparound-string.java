class Solution {
    public int findSubstringInWraproundString(String s) {
       int [] dp = new int[26];
       int len = 0;
       for(int i = 0; i < s.length(); i++){
        if(i > 0 && (s.charAt(i) == s.charAt(i - 1) + 1 || (s.charAt(i - 1) == 'z' && s.charAt(i) == 'a'))){
            len++;
        }
        else{
            len = 1;
        }
        int index = s.charAt(i) - 'a';
        dp[index] = Math.max(dp[index], len);
       }
       int ans = 0;
       for(int x : dp){
        ans += x;
       }
       return ans;
        
    
    }

}