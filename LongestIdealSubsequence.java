import java.util.Arrays;

public class LongestIdealSubsequence {

    /* 
        Approach: 
        1. Use DP, similar to pick / not pick subsequence problems
        2. maintain index (current_index_processing), previousChar as state of DP
        3. at every index, try with pick and with out pick of current element and proceed further
    */

    public int longestIdealString(String s, int k) {
        int[][] dp = new int[s.length()][26];

        for(int i=0;i<s.length();i++) 
            Arrays.fill(dp[i], -1);

        return memo(s, 0, '-', k, dp); // passed '-' to indicate there is no previous char  
    }

    public int memo(String s, int index, char prevChar, int k, int[][] dp) {
        
        if (index >= s.length()) 
            return 0;

        if (prevChar != '-' && dp[index][prevChar-'a'] != -1) { // return if already computed
            return dp[index][prevChar-'a'];
        }

        int maxIdealLength = 0;
        if (prevChar == '-' || Math.abs(prevChar-s.charAt(index)) <=k) // if first char or previousChar - current char <= k
            maxIdealLength = 1 + memo(s, index+1, s.charAt(index), k, dp);  // pick current_char as part of sequence

        maxIdealLength = Math.max(maxIdealLength, memo(s, index+1, prevChar, k, dp)); // don't pick current_char as part of sequence 

        if (prevChar != '-')
            dp[index][prevChar-'a'] = maxIdealLength;

        return maxIdealLength;
    }
}

