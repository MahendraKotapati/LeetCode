/* https://www.geeksforgeeks.org/problems/number-of-distinct-words-with-k-maximum-contiguous-vowels--141631/
 *
 * Find the number of unique words consisting of lowercase alphabets only of length N that can be formed with at-most K contiguous vowels. 
 * 
 * Ex:  Input: N = 2, K = 0
        Output: 441
 */


public class NumberofDistinctWordsWithKmaximumContiguousVowels {
    
    long MOD = (long)(1e9+7);
    int[][] dp;
    
    public int kvowelwords(int N,int K) {
        dp = new int[N+1][K+1];
        
        for(int i=0;i<=N;i++)
           for(int j=0;j<=K;j++)
                dp[i][j] = -1;
        
        return calculateWords(N, 0, K);
        
    } 
    
    
    /* 
     * Approach:
     * 1. find no.of unique words we get if index i, is assigned with vowel (if possible)
     * 2. find no.of unique words we get if index i, is assigned with consonent (always possible)
     * 3. then sum both the no.of unique words
     * 4. as we have overlapping subproblems use DP
     */




    /*
     * ---------     Wrong Approach:    ------------------
     * for(int i=1;i<=N;i++) {
            if (consecutiveLen>=K) {
                consecutiveLen = 0;
                uniqueWords = ((uniqueWords % MOD) * (21 % MOD)) % MOD;
            } else {
                uniqueWords = ((uniqueWords % MOD) * (26 % MOD)) % MOD;
                consecutiveLen++; // here, we can assign vowel or consonent but we always increasing consecutiveLen, so this approach won't work.
            }
        }
        ------ This FOR loop approach is wrong, added here to show that it won't work -----
     */

    public int calculateWords(int n, int currVowelConsecutiveLen, int k) {
        if (n<=0)
            return 1;
        
        if (dp[n][currVowelConsecutiveLen] != -1)
            return dp[n][currVowelConsecutiveLen];
            
        long curr_ans = 0;
        
        // assign vowel
        if (currVowelConsecutiveLen < k) { // current consective vowel len < k , then assign vowel and go a head
            curr_ans = ((5 % MOD) * (calculateWords(n-1, currVowelConsecutiveLen+1, k) % MOD) ) % MOD;   
        }
        
        
        // we can always assign consonent, and then reset currVowelConsecutiveLen to 0
        curr_ans = ( (curr_ans % MOD) + ((21 % MOD) * (calculateWords(n-1, 0, k) % MOD) ) % MOD ) % MOD;  // assign consonent 
        
        dp[n][currVowelConsecutiveLen] = (int)(curr_ans % MOD);
        
        return dp[n][currVowelConsecutiveLen];
    }
}