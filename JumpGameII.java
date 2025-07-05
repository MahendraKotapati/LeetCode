public class JumpGameII {
    
    // Approach 1: Greedy approach, TC: O(n)
    /*  currJumpsLeft - no.of jumps we can still take.
        1) traverse from left to right, while traversing keep track of maxJumps possible because of this index from currEndPoint(the point where currJumpsLeft)
        2) above we are calculating w.r.t currEndPoint because once currJumpsLeft is zero, 
           we need to take a choice (should have jumped to this choosed index earlier, and strated from choosed_index to till currEndPoint) which gives maxJumps possible from currEndPoint
    */
    public int jump(int[] nums) {
        
        int n = nums.length, i, currJumpsLeft, currMaxJumpsPossible, minJumps=0;

        i=0;  // start from 0
        currJumpsLeft = nums[0];

        while(i<n-1) { // if we reach last index we can stop
            currMaxJumpsPossible = Integer.MIN_VALUE;
            minJumps++; // we haven't reached end so for sure we are going to take a jump;
            while(currJumpsLeft > 0) {
                i++;
                currJumpsLeft--;
                if (i>=n-1) break; // if we reach last index we can stop
                currMaxJumpsPossible = Math.max(currMaxJumpsPossible, nums[i]-currJumpsLeft);  // keep track maxJumps possible   
            }
            currJumpsLeft = currMaxJumpsPossible;
        }

        return minJumps;

    }


    /* TC: O(n^2)
     * Approach 2: Using DP
     * 1) start from last, let be i'th index and visit all possible index from i and find the minJumps from i to reach end.
     * 2) save it in minJumps[i], then finally minJumps[0] is our answer. 
     * 
     */

    public int jump2(int[] nums) {
        int MAX_VALUE = (int)1e5;
        int n = nums.length;
        int[] minJumps = new int[n];

        minJumps[n-1] = 0;

        for(int i=n-2;i>=0;i--) {
          int currJumps = nums[i];
          int currMinJumps = MAX_VALUE;

          for(int j=1;j<=currJumps;j++) {
            if (i+j>=n) 
                break;
            currMinJumps = Math.min(1+minJumps[i+j], currMinJumps);
           }
        
           minJumps[i] = currMinJumps;

        } 

        return minJumps[0];
    }
}