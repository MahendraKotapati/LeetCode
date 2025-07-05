import java.util.*;

class Solution {

    /* TC: O(n) SC: O(n)
        1. for every element find nearest duplicate on its left.
        2. and update this element index in indexMap 
           as this element becomes left elmement for upcoming duplicate element
    */

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> indexMap = new HashMap<>();

        for(int i=0; i<nums.length; i++) {
            Integer prevIndex = indexMap.get(nums[i]);
            
            if (prevIndex == null) {
                indexMap.put(nums[i], i);
            } else {
                if (i - prevIndex <= k)
                    return true;
                indexMap.put(nums[i], i);
            }
        }

        return false;
    }
}