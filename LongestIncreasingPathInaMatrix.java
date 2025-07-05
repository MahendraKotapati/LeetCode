import java.util.*;

public class LongestIncreasingPathInaMatrix {
    int[][] dp;
    int longestPath;

    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        dp = new int[n][m];

        for(int i=0;i<n;i++)
            Arrays.fill(dp[i], -1);

        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                dfs(matrix, i, j, n, m, Integer.MIN_VALUE);
            }
        }

        return longestPath;
    }

    /*
     * Approach:   TC: O(n*m)  SC: O(n*m)
     * 1. Apply DFS with DP(memoization),  [DFS with DP is not so common pattern, but here based on nature of problem it works here]
     * 2. As problem requires increasing path, we don't need to maintain visited[] array, since we only go to next element if it is greater than current element 
     */

    public int dfs(int[][] matrix, int i, int j, int n, int m, int previous) {
        if (i<0 || i>=n || j<0 || j>=m || matrix[i][j]<= previous) { // currElement should greater than previous element
            return 0;
        }

        if (dp[i][j] != -1)
            return dp[i][j];
        
        int currMaxPath = 0;
        currMaxPath = Math.max(currMaxPath, 1 + dfs(matrix, i, j-1, n, m, matrix[i][j]));
        currMaxPath = Math.max(currMaxPath, 1 + dfs(matrix, i, j+1, n, m, matrix[i][j]));

        currMaxPath = Math.max(currMaxPath, 1 + dfs(matrix, i-1, j, n, m, matrix[i][j]));
        currMaxPath = Math.max(currMaxPath, 1 + dfs(matrix, i+1, j, n, m, matrix[i][j]));

        longestPath = Math.max(longestPath, currMaxPath);
        return dp[i][j] = currMaxPath;                                                                               
    }
}