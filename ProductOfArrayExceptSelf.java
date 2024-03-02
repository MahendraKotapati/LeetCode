class Solution {

    /*
     * Using approach Left & Right product array conecpt
     * Left[i] = nums[0] * .... * nums[i];
     * Right[i] = nums[n-1] * .... * nums[i];
     */
    public int[] ProductOfArrayExceptSelf(int[] nums) {
        
        int leftProduct = 1, n = nums.length;
        int[] answer = new int[n]; // intially loaded with right product array values
        // left product values calculated on the fly.

        answer[n-1] = nums[n-1];

        for(int i = n-2; i>=0; i--) {
            answer[i] = answer[i+1] * nums[i];
        }

        for(int i=0;i<n;i++) {
            answer[i] = leftProduct * (i+1 < n ? answer[i+1] : 1);
            leftProduct *= nums[i];
        }
        
        return answer;
    }
}
