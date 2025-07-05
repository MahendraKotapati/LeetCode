public class MinimumSizeSubarraySum_209 {

    /*
        1. Use sliding window approach and keep adding elements to window till currSum < target
        2. once currSum >= target note down the minLength 
        and try to remove the elements from start of window to get even lesser minLength if possible
    */

    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0, n = nums.length, currSum=0, minLength = Integer.MAX_VALUE;


        while(left <= right) {
            if (currSum >= target) { 
                minLength = Math.min(minLength, right - left);
                currSum = currSum - nums[left]; // removing elements from start of window
                left++;
            } else {
                if (right >= n) // if right pointer reaches end of array 
                    break;
                currSum += nums[right];
                right++;
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
