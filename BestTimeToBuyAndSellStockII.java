import java.util.Scanner;

public class BestTimeToBuyAndSellStockII {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = {7,1,5,3,6,4};
        System.out.println("Ans: " + maxProfit(nums));
        sc.close();
    };

    public static int maxProfit(int[] prices) {
        int[] ahead = new int[2]; 
        int[] curr = new int[2];
        // column 0 - can't buy
        // column 1 - can buy

        ahead[0] = ahead[1] = 0;

        // here we are processing array in reverse order so, we first sell a stock then buy.
        for (int i = prices.length-1; i>=0; i--) {
            // Max(sell current stock + next time can buy stock, don't sell stock + can't buy stock next time)
            curr[0] = Math.max(prices[i] + ahead[1], 0 + ahead[0]);  //  prices[i] is added because we are selling the stock.

            // Max(buy current stock + can't buy stock next time, don't buy stock + can buy stock next time)
            curr[1] = Math.max(-prices[i] + ahead[0], 0 + ahead[1]); //  prices[i] is subtracted because we are buying the stock


            ahead = curr.clone(); // copying array
        }

        return ahead[1]; // not considering ahead[0] because ahead[0] hold a share which already added to profit (without buying)
    }


     // dp without space optimization
    /* 
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length + 1][2]; 
        // column 0 - can't buy
        // column 1 - can buy

        dp[prices.length][0] = dp[prices.length][1] = 0;

        for (int i = prices.length-1; i>=0; i--) {
            dp[i][0] = Math.max(prices[i] + dp[i+1][1], 0 + dp[i+1][0]);
            dp[i][1] = Math.max(-prices[i] + dp[i+1][0], 0 + dp[i+1][1]);
        }

        return dp[0][1];
    }
    */
}



