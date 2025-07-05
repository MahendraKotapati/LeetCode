public class MaximumScoreofaGoodSubarray {

    /*
    Approach: TC: O(n).   SC: O(1)
    1. Use Sliding window, as index 'k' should always be included in answer subarray.
    2. we take index 'k' as base point, and expand to left, right of it.    
    3. while expanding maintain currMin, expanding to left (i--) or right (j++) depends on currMin 
    4. if nums[j] >= currMin expand to right (j++), if we include nums[j] it won't decrease the score as min of subarray still same as previous
       else if nums[i] >= currMin expand to left (i--), if we include nums[i] it won't decrease the score as min of subarray still same as previous
    5. at each step keep track of maximumScore.   
    */

    public int maximumScore(int[] nums, int k) {

        int n = nums.length, currMin = nums[k], i=k-1, j=k+1, maximumScore = nums[k] * 1;

        while (i>=0 || j<n) {
            if (j<n && nums[j] >= currMin) // expand to right
                j++;
            else if (i>=0 && nums[i] >= currMin)  // expand to left
                i--;
            else {
                if (i<0) { // if left is exhausted, expand to right
                    currMin = nums[j]; j++;
                } else if (j>=n) { // if right exhausted, expand to left
                    currMin = nums[i]; i--;
                } else if(nums[i] > nums[j]) { // if both left and right exists and both < currMin, then expand to side where we get highest minimum
                    currMin = nums[i]; i--;
                } else {
                    currMin = nums[j]; j++;
                }
            }

            maximumScore = Math.max(maximumScore, currMin * (j-i-1));
            
        }

        return maximumScore;

    }
}