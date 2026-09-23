class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int maxweight = -1;
        int totalweight = 0;
        for(int weight : weights){
            maxweight = Math.max(maxweight,weight);
            totalweight += weight;
        }
        int left = maxweight;
        int right = totalweight;
        while(left < right){
            int mid = left + (right - left) / 2;
            int day  = 1;
            int currentweight = 0;
            for(int w : weights){
                if(w + currentweight > mid){
                    day++;
                    currentweight = 0;
                }
                currentweight += w;


            }
            if(day > days){
                left = mid + 1;
            }
            else{
                right = mid;
            }
        }
        return left;
    }
}