class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        String [] [] dp = new String[n+1][m+1];
        String ans  = lcs( 0 ,0 ,str1,str2,dp);
         StringBuilder res = new StringBuilder();

        int i = 0;
        int j = 0;

        for (int k = 0; k < ans.length(); k++) {

            char ch = ans.charAt(k);

            while (str1.charAt(i) != ch) {
                res.append(str1.charAt(i));
                i++;
            }

            while (str2.charAt(j) != ch) {
                res.append(str2.charAt(j));
                j++;
            }

            res.append(ch);

            i++;
            j++;
        }

        while (i < str1.length()) {
            res.append(str1.charAt(i));
            i++;
        }

        while (j < str2.length()) {
            res.append(str2.charAt(j));
            j++;
             }

        return res.toString();
    }
        
    public static  String lcs(int i ,int j ,String str1, String str2,String[][] dp){
        if (i == str1.length() || j == str2.length()) {
            return "";
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

      
        if (str1.charAt(i) == str2.charAt(j)) {

            return dp[i][j] =
                    str1.charAt(i) + lcs(i + 1, j + 1, str1, str2,dp);
        }

       
        String take1 = lcs(i + 1, j, str1, str2,dp);
        String take2 = lcs(i, j + 1, str1, str2,dp);

        if (take1.length() >= take2.length()) {
            return dp[i][j] = take1;
        } else {
             return dp[i][j] = take2;
        }
        
        
    }

}