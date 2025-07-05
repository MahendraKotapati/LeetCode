public class JumpGame {
    
    // greedy approach
    // start from left to right,
    // while traversing keep track max jumps possible
    // curr_jump_len = Math.max(curr_jump_len, nums[i]); // if nums[i] has max jumps take it.

    public boolean canJump(int[] nums) {

        int curr_jump_len = nums[0];

        for(int i = 1;i<nums.length;i++) {
            if (curr_jump_len<=0) {
                return false;
            }
            curr_jump_len--;
            curr_jump_len = Math.max(curr_jump_len, nums[i]);
        } 

        return true;
    }
}