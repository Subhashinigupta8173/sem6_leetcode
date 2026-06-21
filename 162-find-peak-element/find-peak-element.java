class Solution {
    public int findPeakElement(int[] arr) {
        int n=arr.length;
        int max=Integer.MIN_VALUE;
        int ans=0;
        for(int i=0;i<n; i++){
        
        if(arr[i]>max){
            max=arr[i];
            ans=i;

        }
        
        }
        return ans;
        
    }
}