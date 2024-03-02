import java.util.Arrays;

public class SplitArrayLargestSum {

    public int splitArray(int[] nums, int k) {
        int[][] dp = new int[nums.length][k+1];

        for(int i=0;i<nums.length;i++)
            Arrays.fill(dp[i], -1);

        return memoization(0, nums, k, dp);
    }

    /*
     * Top down DP approach
     * 
     */
    public int memoization(int start, int[] nums, int k, int[][] dp) {

        if (k==0 && start == nums.length) { // !!important --- both k==0 and start == nums.length then only the partition is completed
            return 0;
        }

        if (start >= nums.length || k<0) {
            return Integer.MAX_VALUE; // !!important -- partition is not possible so return some max value, so that it is overridden.
        }

        if (dp[start][k] != -1) {
            return dp[start][k];
        }

        int curr_subarray_sum = 0, curr_ans = Integer.MAX_VALUE;

        for(int i=start;i<nums.length;i++) {
            curr_subarray_sum += nums[i];

            // make a cut a i, then find answer for nums[i+1:n] with k-1 partitions
            int max_subarray_sum_in_remaining_splits = memoization(i+1, nums, k-1, dp);

            // curr_split_max_subarray_sum holds maximum subarray sum in the curr split at i'th position
            int curr_split_max_subarray_sum = Math.max(curr_subarray_sum, max_subarray_sum_in_remaining_splits);

            // we need minimized largest sum, so finding a split at position where having minimized maxium split.
            curr_ans = Math.min(curr_ans, curr_split_max_subarray_sum);
        }

        // curr_ans holds best possible value (minized largest sum) out of all possible ways of partitions (no.of partitions should be equal to k) from nums[start:n]
        return dp[start][k] = curr_ans;

    }

}