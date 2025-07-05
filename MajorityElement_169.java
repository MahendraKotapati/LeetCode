class Solution {

    /*
    Boyer moore voting algorithm.
    Approach: TC: O(n) SC: O(1)
    1. if count == 0 make nums[i] as candidate majorityElement
    2. if nums[i] == candidate 
        count++
       else 
        count--;

    why this works ?
    1. assume count = 0, for nums[p:q]. then we can safely ignore nums[p:q] because
        if candidate is not majorityElement then 
            actual majorityElement should be present n/2 times in nums[q+1:n]
        if candidate is majorityElement then
            then this candidate should be majorityElement in nums[q+1:n] as well.
            (as we are cancelling out majorityElement & other elements in same ratio)
    */

    public int majorityElement(int[] nums) {
        
        Integer candidate = null, count = 0;

        for(int i=0;i<nums.length;i++) {
            if (count == 0)
                candidate = nums[i];

            if (nums[i] == candidate)
                count++;
            else 
                count--;
        } 
        return candidate;
    }

    /*
    [3,2,3]

    [2,2,1,1,1,2,2]

    [2, 2, 3, 3, 2]

    [2, 2, 3, 3, 2, 2]

    [2, 2, 3, 3, 2, 2, 3]
    */
}