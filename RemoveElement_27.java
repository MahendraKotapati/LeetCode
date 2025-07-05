class Solution {
    /*

    1. maintain separate variable 'k' for result array length (which don't contain any 'val')
    2. assign nums[k] = nums[i]; if nums[i] != val
    3. here, we are updaing every 'val' (nums[i]) with next element which is not equal to 'val';
    */

    public int removeElement(int[] nums, int val) {
        int k=0;
        
        for(int i=0;i<nums.length;i++) {
            if (nums[i] == val)
                continue;
            nums[k] = nums[i];
            k++;
        }

        return k;
    }
}