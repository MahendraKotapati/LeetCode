import java.util.Scanner;

public class CoinChangeMinCoins {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] coins = {2, 5, 10, 1}; // new int[10];
        int amount = 27;
        System.out.println("Ans: " + coinChange(coins, amount));
        sc.close();
    };

    public static int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount + 1];
        int MAX = Integer.MAX_VALUE;

        // populate 0th column
        for(int i = 0; i < coins.length; i++) {
            dp[i][0] = 0; // min coins required to make amount of zero is 0 coins
        }

        // populate 0th row
        for(int j = 1; j <= amount; j++) {
            dp[0][j] = (j - coins[0] >= 0 && dp[0][j-coins[0]] != MAX) ? (1 + dp[0][j-coins[0]]) : MAX;
        }


        for(int i = 1;i < coins.length; i++) {
            for(int j = 1; j <= amount; j++) {
                
                if (j - coins[i] >=0 && dp[i][j-coins[i]] != MAX) {
                    dp[i][j] = Math.min(dp[i-1][j], 1 + dp[i][j-coins[i]]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        

        return dp[coins.length - 1][amount] == MAX ? -1 : dp[coins.length - 1][amount] ;
    }
}

/*              sum
 *       0  1  2  3  4  5  6  7  8  9 10  11
 *          
 *    1  0  1   
 * 
 *    2  0            
 *          
 *    5  0
 * 
 * 
 */

