import java.util.Scanner;

/*
 *  Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
    You have the following three operations permitted on a word:    
    Insert a character
    Delete a character
    Replace a character
 * 
 */

public class EditDistance {
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in);
        String str1 = "horse";
        String str2 = "ros";
        System.out.println("Ans: " + minDistance(str1, str2));
        sc.close();
    }

    public static int minDistance(String word1, String word2) {

        int[][] dp = new int[word1.length()+1][word2.length()+1];
        // dp[i][j] represents min operations required to convert word1[0:i-1] to word2[0:j-1];
 
        for(int i = 0; i <= word1.length(); i++) {
            dp[i][0] = i; // if word2 is empty , we need delete characters in word1
        }  

        for(int j = 0; j <= word2.length(); j++) {
            dp[0][j] = j; // // if word1 is empty , we need insert characters in word1 
        } 

        dp[0][0] = 0;
    

        for(int i = 1; i<= word1.length(); i++) {
            for (int j = 1; j<= word2.length(); j++)
            {
                if(word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    // 1 + min(replace char, remove char, insert char)
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
                }
            }
        }

        return dp[word1.length()][word2.length()];
    }
}
