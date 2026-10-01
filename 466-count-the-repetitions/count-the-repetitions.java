class Solution {  
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {  

        
        int n = s1.length();  
        int m = s2.length();  

        int c = 0;  
        int j = 0;  

        int[] seenK = new int[m];
        int[] seenC = new int[m];

        Arrays.fill(seenK, -1);

        int k = 0;

        while(k < n1) {

           
            for(int i = 0; i < n; i++) {

                if(s1.charAt(i) == s2.charAt(j)) {
                    j++;
                }

                if(j == m) {
                    c++;
                    j = 0;
                }
            }

            k++;

           
            if(seenK[j] != -1) {

                int oldK = seenK[j];
                int oldC = seenC[j];

                int cycleK = k - oldK;
                int cycleC = c - oldC;

                int remaining = n1 - k;

                int times = remaining / cycleK;

                k += times * cycleK;
                c += times * cycleC;

            } 
            else {
               
                seenK[j] = k;
                seenC[j] = c;
            }
        }

        return c / n2;
    }  
}