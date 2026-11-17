class Solution {
    private int largerValidSize;
    private int smallerValidSize;

    private final PriorityQueue<Integer> larger = new PriorityQueue<>();
    private final PriorityQueue<Integer> smaller  = new PriorityQueue<>(Collections.reverseOrder());
    private final Map<Integer, Integer> delayedFreqMap = new HashMap<>();

    public double[] medianSlidingWindow(int[] nums, int k) {
        
        // Sliding window
        int n = nums.length;
        double[] result = new double[n - k + 1];
        for(int i = 0; i < n; i++) {
            // Add to window
            addNum(nums[i]);

            // Remove if needed
            if(i >= k) {
                removeNum(nums[i-k]);
            }

            // Update solution
            if(i >= k - 1) {
                result[i-k+1] = getMedian(k);
            }
            

        }
        return result;
    }

    private void addNum(int num) {
        if(larger.isEmpty() || num >= larger.peek()) {
            larger.offer(num);largerValidSize++;
        } else {
            smaller.offer(num);smallerValidSize++;
        }
        rebalance();
    }

    private void removeNum(int num) {
        // Add to delay map
        delayedFreqMap.merge(num, 1, Integer::sum);

        // Update logical valid size
        if(num <= smaller.peek()) {

            smallerValidSize--;
            if(num == smaller.peek()) {
                prune(smaller);
            }
        } else {
            largerValidSize--;
            if(num == larger.peek()) {
                prune(larger);
            }
        }
        rebalance();
    }

    // Goal, maintain larger size >= smaller + 1
    private void rebalance() {
        if(largerValidSize > smallerValidSize) {
            prune(larger);
            smaller.offer(larger.poll());
            smallerValidSize++;
            largerValidSize--;
            prune(larger);
        } else if(smallerValidSize > largerValidSize + 1) {
            prune(smaller);
            larger.offer(smaller.poll());
            smallerValidSize--;
            largerValidSize++;
            prune(smaller);
        }

    }

    private void prune(PriorityQueue<Integer> heap) {
        // real Delete
        while(!heap.isEmpty() && delayedFreqMap.containsKey(heap.peek())) {
            int num = heap.poll();
            int freq = delayedFreqMap.get(num);
            if(freq == 1) {
                delayedFreqMap.remove(num);
            } else {
                delayedFreqMap.merge(num, -1, Integer::sum);
            }
        }
    }

    private double getMedian(int k) {
        int size = largerValidSize + smallerValidSize;
        if(size == 0) return 0;
        if(k % 2 == 0) {
            return ((double) larger.peek() + smaller.peek()) / 2.0;
        } else {
            return (double) smaller.peek();
        }
    }

}