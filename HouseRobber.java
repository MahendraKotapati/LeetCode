import java.util.Scanner;

public class HouseRobber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = {1 , 2, 3, 1}; // new int[10];
        System.out.println("Ans: " + rob(nums));
        sc.close();
    }

    public static int rob(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }

        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(nums[i] + dp[i-2], dp[i-1]); // either rob a house or don't rob a house.
        }

        return dp[nums.length - 1];
    }
}