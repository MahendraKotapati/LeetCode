import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class BurstBallons {
    
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums =  {3, 1, 5, 8}; // {3, 1, 5, 8};
        // int[] nums =  {1, 5};
        System.out.println("Ans: " + maxCoins(nums));
        sc.close();
    }

    public static int maxCoins(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];

        for(int i = 0; i<nums.length; i++) {
            for(int j = 0; j<nums.length; j++) {
                dp[i][j] = -1;
            } 
        }

        return maxCoinsMemo(nums, 0, nums.length-1, dp);
    }

    public static int maxCoinsMemo(int[] nums, int start, int end, int[][] dp) {
        
        if (start > end) {
            return 0;
        }

        if (dp[start][end] != -1) {
            return dp[start][end];
        }

        int maxCoins = Integer.MIN_VALUE;
        int l = start - 1, r = end + 1 , leftElement, rightElement;
        leftElement = (l >= 0) ? nums[l] : 1;
        rightElement = (r < nums.length) ? nums[r] : 1;

        for(int i = start; i<=end; i++) {
            int currentMaxCoins = (leftElement * nums[i] * rightElement) + maxCoinsMemo(nums, start, i-1, dp) + maxCoinsMemo(nums, i+1, end, dp);
            maxCoins = Math.max(maxCoins, currentMaxCoins);
        }

        dp[start][end] = maxCoins;
        
        return maxCoins;
    }
}
