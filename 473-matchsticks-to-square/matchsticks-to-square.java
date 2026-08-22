class Solution {
    List<Integer> ll;

    public boolean makesquare(int[] matchsticks) {

        int sum = 0;

        ll = new ArrayList<>();

        for (int x : matchsticks) {
            sum += x;
            ll.add(x);
        }

        if (sum % 4 != 0) {
            return false;
        }

        int tar = sum / 4;

        Collections.sort(ll, Collections.reverseOrder());

        return solve(0, 0, 0, 0, 0, tar);
    }

    public boolean solve(int s1, int s2, int s3, int s4,
                         int i, int tar) {

       
        if (s1 > tar || s2 > tar ||
            s3 > tar || s4 > tar) {
            return false;
        }

        
        if (i == ll.size()) {
            return s1 == tar &&
                   s2 == tar &&
                   s3 == tar &&
                   s4 == tar;
        }

        int stick = ll.get(i);

        return solve(s1 + stick, s2, s3, s4, i + 1, tar) ||
               solve(s1, s2 + stick, s3, s4, i + 1, tar) ||
               solve(s1, s2, s3 + stick, s4, i + 1, tar) ||
               solve(s1, s2, s3, s4 + stick, i + 1, tar);
    }
}