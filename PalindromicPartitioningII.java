import java.util.Arrays;
import java.util.Scanner;

public class PalindromicPartitioningII {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = "aab";
        System.out.println("Ans: " + minCut(s));
        sc.close();
    }

    // Time complexity : O(n^2)
    // Space complexity : O(n^2)
    public static int minCut(String s) {
        int[] dp = new int[s.length()];
        boolean[][] isPalindrome = new boolean[s.length()][s.length()]; // isPalindrome[i][j] represents s[i:j] is palindrome or not.

        Arrays.fill(dp, -1);

        for(int i = 0; i<s.length(); i++) {
            for(int j = 0; j<s.length(); j++) {
                isPalindrome[i][j] = false;
            }
            isPalindrome[i][i] = true; // single character is always a palindrome
        }

        generatePalindromes(s, isPalindrome);

        return minCutMemo(s, 0, dp, isPalindrome);
    }


    /*  
        Time complexity : O(n^2)   because , this memoization has n distinct states each state solved in O(n) time  
    */
    public static int minCutMemo(String s, int idx, int[] dp, boolean[][] isPalindrome) {

        int ans = Integer.MAX_VALUE;

        // for length 1 , no.of cuts is 0;
        if (idx == s.length()-1) {
            return 0;
        }
        
        // important at last we don't need to make cut ,but we are adding one in function call to compensate that we return -1;
        if (idx >= s.length()) {
            return -1;
        }

        if (dp[idx] != -1) {
            return dp[idx];
        }

        for(int i = idx; i < s.length(); i++) {
            if (isPalindrome[idx][i]) { // if str[idx:i] is panlindrome
                ans = Math.min(ans, 1 + minCutMemo(s, i + 1, dp, isPalindrome));
            }
        }
        
        dp[idx] = ans;
        return dp[idx];
        
    }

    public static void generatePalindromes(String s, boolean[][] isPalindrome) {
        
        int j = 0;
        for(int len = 2; len<=s.length() ; len++) {
            for(int i = 0; i + len - 1 < s.length(); i++) {
                j = i + len - 1;
                isPalindrome[i][j] = (s.charAt(i) == s.charAt(j)) && (len == 2 || isPalindrome[i+1][j-1]);
            }
        }
    }
}