import java.util.Scanner;
/* 

Problem: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/description/

Solution: https://youtu.be/-uQGzhYj8BQ?si=bWtcpClwGEj67adO

*/

public class BestTimeToBuyAndSellStockIII {

    static int[][][] dp = new int[(int)1e5][2][3];
    static int MAX_TRANSACTIONS_ALLOWED = 2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = {3,3,5,0,0,3,1,4};
        System.out.println("Ans: " + maxProfit(nums));
        sc.close();
    };

    public static int maxProfit(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < 2; j++) {
                for(int k = 0; k < 3; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }

        maxProfitHelper(nums, 0, 1, 0);
        // result will be indexes which we pass as parameters
        return dp[0][1][0];
    }

    public static int maxProfitHelper(int[] nums, int index, int can_buy, int total_transactions) {

        if (index >= nums.length || total_transactions >= MAX_TRANSACTIONS_ALLOWED) {
            return 0;
        }

        if (dp[index][can_buy][total_transactions] != -1) {
            return dp[index][can_buy][total_transactions];
        } 

        // can_buy == 1 means, we can buy new stock.
        if (can_buy == 1) {
            
            int a = -nums[index] + maxProfitHelper(nums, index + 1, 0, total_transactions); // we bought the stock
            int b = 0 + maxProfitHelper(nums, index + 1, 1, total_transactions); // skip the stock from buying
            dp[index][can_buy][total_transactions] = Math.max(a, b);

        } else {
            // we sold the stock, so one transaction is recorded.
            int c = nums[index] + maxProfitHelper(nums, index + 1, 1, total_transactions + 1);
            
            int d = 0 + maxProfitHelper(nums, index + 1, 0, total_transactions); // skip the stock from selling.
            dp[index][can_buy][total_transactions] = Math.max(c, d);
        }

        return dp[index][can_buy][total_transactions];  
    }
}


