class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int [] left  = new int [n];
        int [] right = new int [n];
        int minPrice  = prices[0];
        for(int i = 1; i < n ;i++){
            minPrice = Math.min(minPrice,prices[i]);
            left[i] = Math.max(left[i - 1],prices[i] - minPrice);

        }
        int maxPrice = prices[n - 1];
        for(int i = n - 2; i >= 0; i--){
            maxPrice = Math.max(maxPrice, prices[i]);
            right[i] = Math.max(right[i + 1],maxPrice - prices[i]);

        }
        int ans  = 0;
        for(int i = 0; i < n; i++){
            ans =  Math.max(ans,left[i] + right[i]);

        }
        return ans;
       
    }
}