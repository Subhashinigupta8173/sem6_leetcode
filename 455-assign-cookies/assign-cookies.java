class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int n = g.length;
        int m = s.length;
        int c = 0;
        int j = 0;
        if(m == 0 || n == 0){
            return 0;
        }
        Arrays.sort(g);
        Arrays.sort(s);

        for (int i = 0; i < n && j < m; i++) {
            if (s[j] >= g[i]) {
                c++;
                j++;
            }
            else{
                j++;
                i--;
            }
        }
        return c;

        
    }
}