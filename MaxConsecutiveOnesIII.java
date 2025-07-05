public class MaxConsecutiveOnesIII {

    /*
     * Approach:
     * 1. Use sliding window approach
     * 2. Move end pointer till all 'k' flips used, 
     * 3. Once we are out of flips remove first flip from the window, so that window can expanded further
     * 4. When window is expanding parallely track maxConsectiveOnes (=max_window_size)
     */
    public int longestOnes(int[] nums, int k) {
        
        int start=0, end=0, maxConsectiveOnes = 0, currentFlips = 0;

        while (end<nums.length) {
            if (nums[end]==0) {
                if (currentFlips<k) { // if we still have flips, use them
                    end++; currentFlips++;
                } else { // we are out of flips
                   while(nums[start]==1 && start<end) // find the first flip
                    start++; 

                    if (start==end) { // if first flip not found (happens when zero flips are allowed)
                     end++; start=end; currentFlips=0;
                    }
                    else { // if first flip found, so remove it from the window
                        currentFlips--; start++;
                    } 
                }
            } else { // if nums[end] is 1
                end++;
            }
            
            maxConsectiveOnes = Math.max(maxConsectiveOnes, end-start);
        }

        return maxConsectiveOnes;
    }
}