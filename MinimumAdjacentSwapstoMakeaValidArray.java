/* 

You are given a 0-indexed integer array nums.

Swaps of adjacent elements are able to be performed on nums.

A valid array meets the following conditions:

The largest element (any of the largest elements if there are multiple) is at the rightmost position in the array.
The smallest element (any of the smallest elements if there are multiple) is at the leftmost position in the array.
Return the minimum swaps required to make nums a valid array.

Ex:
nums = [3,4,5,5,3,1]
minimums swaps = 6

*/

/*
 * Approach:
 * 1) Get minimum element index (left most) and maximum element index (right most)
 * 2) if min_index == max_index only one element exists in arrays so, min_swaps = 0
 *    else if (min_index < max_index) 
 *      min_swaps = no.of swaps to move min to left + no.of swaps to move max to right
 *    else if (min_index > max_index)
 *      min_swaps = no.of swaps to move min to left + no.of swaps to move max to right - 1  
 *   // In above case, 1 is substracted because while moving either min or max to towards its end. other element (min or max) will be make one shift towards its position
 *    
 * 
 */

public class MinimumAdjacentSwapstoMakeaValidArray {
    public int minimumSwaps(int[] nums) {

        int n = nums.length, minimum = Integer.MAX_VALUE, minIndex = -1, maximum = Integer.MIN_VALUE, maxIndex = -1;

        for(int i=0;i<nums.length;i++) {
            if (nums[i] < minimum) { 
                minimum = nums[i];
                minIndex = i;
            }

            if (nums[i] >= maximum) {
                maximum = nums[i];
                maxIndex = i;
            }
        }

        if (minIndex == maxIndex) 
            return 0;
        else if (minIndex<maxIndex) {
            return minIndex + ((n-1) - maxIndex);
        } else {
            return minIndex + ((n-1) - maxIndex) - 1;
        }
        
    }
}