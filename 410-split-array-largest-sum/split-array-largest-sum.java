class Solution {
    public int splitArray(int[] arr, int k) {
        int totalsum=arr[0];
        int max=arr[0];
        for(int i=1;i<arr.length;i++){
            totalsum+=arr[i];
            max=Math.max(max,arr[i]);
        }
        int low=max;
        int h=totalsum;
        while(low<=h){
            int mid= low+(h-low)/2;
            if(Cansplit(arr,k,mid)){
                h=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;

    }

    public static boolean Cansplit (int [] arr,int k,int t){
        int sum=0;
        int p=1;
        for(int i=0;i<arr.length;i++){
            if(sum+arr[i]>t){
                p++;
                sum=arr[i];
            }
            else{
                sum+=arr[i];
            }

        }
        return p<=k;
    }
       
}