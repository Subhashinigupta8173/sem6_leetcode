class Solution {
    public int maximumCandies(int[] candies, long k) {
        int n=candies.length;
        long sum = candies[0];
        int max = candies[0];
        for(int i=1;i<n;i++){
            max=Math.max(max,candies[i]);
            sum+=candies[i];
        }
        if(sum<k){
            return 0;
        }
        int low = 1;
        int high = max;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(CanDistribute(candies,k,mid)){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return high;
    }
    public static boolean CanDistribute(int [] candies ,long k,int c ){
        int n=candies.length;
        long child=0;
        for(int i=0;i<n;i++){
            child+=candies[i]/c; 
        }
        return  child>=k;

    }
}