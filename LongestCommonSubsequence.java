import java.util.Scanner;
 
public class LongestCommonSubsequence {
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in);
        String str1 = "ace";
        String str2 = "abcde";
        System.out.println("Ans: " + longestCommonSubsequence(str1, str2));
        sc.close();
    }

    public static int longestCommonSubsequence(String text1, String text2) {

        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        // filling zeros in 0th column
        for(int i = 0; i <= text1.length(); i++) {
            dp[i][0] = 0;
        }

        // filling zeros in 0th row
        for(int j = 0; j <= text2.length(); j++) {
            dp[0][j] = 0;
        }

        for(int i = 1; i <= text1.length(); i++) {
            for(int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[text1.length()][text2.length()];
    }
}
