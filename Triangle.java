import java.util.Arrays;
import java.util.List;

public class Triangle {

    // Approach 1:     TC: O(n^2)  SC: O(n^2)
    public int minimumTotal(List<List<Integer>> triangle) {
        
        int n = triangle.size();
        int dp[][] = new int[n][n]; // dp[i][j] stores min path sum which ends in triangle[i][j] (leaf node)

        dp[0][0] = triangle.get(0).get(0);

        for(int i=1; i<n; i++) {
            for(int j=0;j<triangle.get(i).size();j++) {
                if (j==0) { // if first element it don't have j-1 element in previous row
                    dp[i][j] = dp[i-1][j] + triangle.get(i).get(j);
                }
                if (j == triangle.get(i-1).size()) { // if last element it don't have corresponding element in previous row
                    dp[i][j] = dp[i-1][j-1] + triangle.get(i).get(j);
                } else { // either take [previous_row][j] or [previous_row][j-1] which has minimum. and add triangle[i][j] as leaf node.
                    dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j-1]) + triangle.get(i).get(j);
                }
            }
        }

        // find min array dp[n-1]
        return Arrays.stream(dp[n-1]).min().getAsInt();
    }

    /*

    // Approach 2:    TC: O(n^2)  SC: O(n)
    // Here Approach 1 is optimized for space. as we are uinsg only previous row in calculation dp state so, dp[] is sufficient in place of dp[][]

    public int minimumTotal(List<List<Integer>> triangle) {
        
        int n = triangle.size(), prev = 0, temp;
        int dp[] = new int[n];  // dp[j] stores min path sum which ends in triangle[i][j] as leaf node

        dp[0] = triangle.get(0).get(0);

        for(int i=1; i<n; i++) {
            for(int j=0;j<triangle.get(i).size();j++) {
                temp = dp[j]; 
                if (j == 0) { // if first element it don't have previous(j-1) element in row i-1
                    dp[j] = dp[j] + triangle.get(i).get(j);
                }
                else if (j == triangle.get(i-1).size()) { // if last element it don't have corresponding (index j) element in row i-1
                    dp[j] = prev + triangle.get(i).get(j);
                } else {
                    dp[j] = Math.min(dp[j], prev) + triangle.get(i).get(j);
                }
                prev = temp; // prev holds dp[i-1][j-1] as like we are using 2d array
            }
        }

        // find min in array using streams
        return Arrays.stream(dp).min().getAsInt();
    }

    */
}