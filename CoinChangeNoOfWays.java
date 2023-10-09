import java.util.Scanner;

public class CoinChangeNoOfWays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] coins = {1 , 2, 3}; // new int[10];
        int amount = 4;
        System.out.println("Ans: " + coinChange(coins, amount));
        sc.close();
    };

    public static int coinChange(int[] coins, int amount) {


        int[][] dp = new int[coins.length][amount + 1]; // rows coins, column amount

        // populate 0th column
        for(int i = 0; i < coins.length; i++) {
            dp[i][0] = 1;   // amount zero can be made everytime without including any coins (1 way).
        }

        // populate 0th row
        for(int j = 1; j <= amount; j++) {
            dp[0][j] = (j - coins[0] >= 0) ? dp[0][j-coins[0]] : 0;
        }


        for(int i = 1;i < coins.length; i++) {
            for(int j = 1; j <= amount; j++) {
                
                if (j - coins[i] >=0) {
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i]];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        

        return dp[coins.length - 1][amount];
    }
}
