class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        return divideAndConquer(nums,0,nums.length-1,lower,upper);
    }
    public int divideAndConquer(int[] nums,int l,int r,int lower,int upper){
        if(l == r) {
            return nums[l] >= lower && nums[r] <= upper ? 1 : 0;
        }
        int mid = l + (r - l)/ 2;
        long[] prefixSum = new long[r - mid]; // l - mid - r // left-> l,mid ; right -> mid+1,r
        prefixSum[0] = nums[mid + 1];
        for(int i = mid + 2; i <= r; i++){
            prefixSum[i - mid - 1] = prefixSum[i - mid - 2] + nums[i];
        }

        Arrays.sort(prefixSum);

        long count = 0;
        long sum = 0;
        for(int le = mid; le >= l; le--){
            sum += nums[le];
            // binary search
            long bLeftIndex = findIndex(prefixSum,lower-sum - 0.5), bRightIndex = findIndex(prefixSum,upper-sum + 0.5);
            count += bRightIndex - bLeftIndex;
        }

        // left[] & right[]
        // prefixRight[]
        /*
        * 0. Create binary search
        * 1. Prefix sum of right array - Done
        * 2. sort the prefix array - Done
        * 3. for loop to find suffix sum from left array - Done
        * 4. Inside for loop we will find bLeftIndex and bRightIndex from prefixSum, such that lower - sum <= x <= upper - sum - Done
        * 5. update the count - Done
        * 6. T(0,n) = T(0,mid) + T(mid+1,n-1) + C
        *
        * */
        int leftSubProblem = divideAndConquer(nums,l,mid,lower,upper);
        int rightSubProblem = divideAndConquer(nums,mid+1,r,lower,upper);
        return leftSubProblem + rightSubProblem + (int)count;
    }
    // -> x ; i -> i+1
    private static int findIndex(long[] arr, double val) {
        int l = 0, r = arr.length - 1, m = 0;

        while (l <= r) {
            m = l + (r - l) / 2;

            if (arr[m] < val) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return l;
    }
}