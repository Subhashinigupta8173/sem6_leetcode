class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < houses.length; i++) {
            int min = Integer.MAX_VALUE;

            for (int j = 0; j < heaters.length; j++) {
                min = Math.min(min,
                    Math.abs(heaters[j] - houses[i]));
            }

            max = Math.max(max, min);
        }

        return max;
    }
}