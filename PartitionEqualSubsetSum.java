import java.util.Scanner;
import java.util.stream.*;

/*
 * Given an integer array nums, return true if you can partition the array into two subsets such that the sum of the elements in both subsets is equal or false otherwise.
 * 
 */

public class PartitionEqualSubsetSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = {7,1,5,3,6,4};
        System.out.println("Ans: " + canPartition(nums));
        sc.close();
    };



    // This is problem boils dows to finding a subset sum with target = k using dp
    public static boolean canPartition(int[] nums) {

        int arraySum = IntStream.of(nums).sum(); // sum of array elements

        // if sum of array elements is odd we can't partition into two set with equal sum.
        if (arraySum % 2 == 1) {
            return false;
        }

        int target = arraySum / 2;
        boolean[][] dp = new boolean[nums.length + 1 ][target + 1];
        // dp[i][j] represents can we make subset sum = j, by using nums[0:i-1];

        // subset with sum zero we can always make by not including any elements
        for (int i = 0; i <= nums.length; i++) {
            dp[i][0] = true;
        }

        // using 0 elements of array we can't make any subset value > 0 , hence it is false.
        for (int j = 0; j <= target; j++) {
            dp[0][j] = false;
        }

        dp[0][0] = true; // with zero elements we can always make zero sum.

        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= target; j++) {
                if (j >= nums[i-1]) {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]]; // with out including nums[i-1] || with including nums[i-1] 
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[nums.length][target];
    }


}
