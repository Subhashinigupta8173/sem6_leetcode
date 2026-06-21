class Solution {
    public int findDuplicate(int[] nums) {
        int n=nums.length;
        int i=0;
        int j=i+1;;
        Arrays.sort(nums);
        int ans=0;
        while(i<j && j<n){
            if(nums[i]==nums[j]){
                ans= nums[j];

            }
           i++;
           j++;
           if(j==n-1){
            if(nums[j]==nums[j-1]){
            ans= nums[j-1];
           }

        }
        }
        return ans;
    }
}