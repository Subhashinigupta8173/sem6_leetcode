class Solution {
    public int findContentChildren(int[] arr, int[] s) {
        int n=arr.length;
        int m=s.length;
        int c=0;
        int i=0;
        int j=0;
        Arrays.sort(s);
        Arrays.sort(arr);
        while(i<n && j<m){
           
                if(s[j]>=arr[i] ){
                    c++;
                    i++;
                    j++;
                
            }
            else{
                j++;
            }
        }
        return c;
    }
}