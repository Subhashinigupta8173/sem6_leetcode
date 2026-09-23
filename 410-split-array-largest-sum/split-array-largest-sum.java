class Solution {
    public int splitArray(int[] nums, int k) {
        int n  = nums.length;
        int lower =  Integer.MIN_VALUE;
        int high = 0;
        if(n < k){
            return 0;
        }
        for(int num : nums){
            lower = Math.max(lower , num);
            high += num;
        }
        int Kcal = 0;
        
        while(lower <= high){
            int mid = lower + (high - lower) / 2;
            if(canFit(nums,mid,k)){
                Kcal = mid;
                high = mid - 1;
            }
            else{
                lower = mid + 1;
            }
        }
        return Kcal;

    }
    public boolean canFit(int [] nums ,int mid ,int k){
        int c = 1;
        int sum = 0;
        for(int num : nums){
            if(sum + num > mid){
                c++;
                sum = num;
            }
            else{
                sum += num;
            }
        }
        return c <= k;
    }
}