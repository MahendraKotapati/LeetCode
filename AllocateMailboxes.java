import java.util.*;

/*
 * Solution Link: https://leetcode.com/problems/allocate-mailboxes/solutions/685321/java-heavily-commented-proof-on-why-median-work
 * 
 */

public class AllocateMailboxes {
    int[][] dp;
    int[][] cost;


    /*
     * Approach:  TC: O(n^3 + k*n^2)  SC: O(n^2)
     * 1. If only one mailbox, then minimum distance is obtained allocating the mailbox in the median of the array houses.
     * 2. Based on point1, try allocate mailbox for set of consecutive houses[i..j] and then try allocating remaining k-1 mailboxes for houses[j+1...n] recursively
     * 3. for hourses[i...j] to get minimum distance, mailbox should be placed in median of houses[i..j]
     */

    public int minDistance(int[] houses, int k) {
        int n = houses.length;
        dp = new int[n][k+1];
        cost = new int[n][n];

        for(int i=0;i<n;i++)
            Arrays.fill(dp[i], -1);
        
        Arrays.sort(houses);
        
        // precalculation to improve Time Complexity
        // for every subarray, calculate cost by placing mailbox in median of that subarray
        for(int i=0;i<n;i++) {
            for(int j=i;j<n;j++) {
                int median = houses[(i+j)/2];
                
                int currCost = 0;
                for(int p=i; p<=j; p++)
                    currCost += Math.abs(houses[p]-median);

                cost[i][j] = currCost;
            }
        }

        return memo(houses, 0, k);
    }

    public int memo(int[] houses, int index, int remainingMailBoxes) {

        if (remainingMailBoxes == 0) { 
            // if all Mail Boxes Used and reached end of array the assignment of mailboxes is valid 
            // for invalid assignment return MAX_VALUE so, that this assignment cost is treated to calculate answer
            return index == houses.length ? 0 : Integer.MAX_VALUE;
        }    

        if (index >= houses.length) // invalid assignment as all mail boxes not used;
            return Integer.MAX_VALUE;
        
        if (dp[index][remainingMailBoxes] != -1)
            return dp[index][remainingMailBoxes];
        
        
        int currMinCost = Integer.MAX_VALUE;

        for(int i=index;i<houses.length;i++) {
            // if one mailbox is placed in median of houses[index..i] then calculate remainingCost
            int remainingCost = memo(houses, i+1, remainingMailBoxes-1);

            if (remainingCost != Integer.MAX_VALUE)
                currMinCost = Math.min(currMinCost, cost[index][i] + remainingCost);
        }

        dp[index][remainingMailBoxes] = currMinCost;
        return dp[index][remainingMailBoxes];
    }
}