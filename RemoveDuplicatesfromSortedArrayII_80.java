class Solution {

    /*
    Approach: TC: O(n)
    1. maintain separate varible 'k' which holds result array length.
    2. skip inserting nums[i], if nums[i] is same as last two elements in result array (nums[k-1], nums[k-2])
       else insert nums[i] into nums[k]; 
    */

    public int removeDuplicates(int[] nums) {

        if (nums.length <= 2)
            return nums.length;

        int k=2, i=2;

        while(i<nums.length) {
            // skip inserting nums[i], if nums[i] is same as last two elements in result array (nums[k-1], nums[k-2])
            if (nums[i] == nums[k-1] && nums[i] == nums[k-2]) {
                i++;
            } else {
                nums[k] = nums[i];
                k++;
                i++;
            }
        }

        return k;
    }
}