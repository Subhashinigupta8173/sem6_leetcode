// Last updated: 3/9/2026, 10:15:08 AM
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int n=nums1.length;
    int m=nums2.length;
     int [] mer=new int[n+m];
     int i=0,j=0,k=0;
    while(i<n && j<m){
            if(nums1[i]<nums2[j]){
                mer[k++]=nums1[i++];
            }
            else{
                mer[k++]=nums2[j++];
            }
        }
        while(i<n){
            mer[k++]=nums1[i++];

        } 
        while(j<m) {
            mer[k++]=nums2[j++];
        }                               
int t=n+m;

    if(t%2==0){
       return (mer[t/2 - 1] + mer[t/2]) / 2.0;
    }
     else {
            return mer[t/2];
        }

    }  
} 
