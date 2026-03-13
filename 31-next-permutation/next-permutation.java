class Solution {
    public void nextPermutation(int[] nums) {
        int i=nums.length-2;
        //find pivot value means jo next greater se just small ai
        while(i>=0 && nums[i]>=nums[i+1]){
            i--;
        }
        // find next greater value to swap 
        if(i>=0){
        int j=nums.length-1;
        while( nums[j]<=nums[i]){
            j--;
        }
        //swap them
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
        
    }
    // reverse whole array after the i
    reverse(nums,i+1);
    }
      private void reverse(int[] nums, int start) {
        int end = nums.length - 1;

        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start++;
            end--;
        }
     }
}