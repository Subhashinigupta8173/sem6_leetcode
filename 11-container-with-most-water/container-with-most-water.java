class Solution {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int max = 0;

        while (i < j) {
            int minHeight = Math.min(height[i], height[j]);
            int area = minHeight * (j - i);
            max = Math.max(max, area);

            // move the smaller height
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return max;
    }
}