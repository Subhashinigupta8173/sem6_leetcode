// Last updated: 3/9/2026, 10:15:02 AM
class Solution {
    public int maxArea(int[] height) {
        int l=0;
        int  r=height.length-1;
       int max=0;
       while(l<r){
       int w=r-l;
       int h=Math.min(height[l],height[r]);
       int area=w*h;
       max=Math.max(max,area);
       if(height[l] < height[r]){
                l++;
            }else{
                r--;
            }




       }
       return max;
        
    }
}