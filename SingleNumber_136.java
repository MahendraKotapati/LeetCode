class Solution {

    /*
        Approach: TC - O(n)
        1. XOR operation on two same numbers gives zero as result. (check xor bitwise gate)
        2. since every number appears twice except one. 
           we can xor entire array elements, then which are repeated will be cancelled out in xor operation.
        3. result of xor operation is the element which appears only once. 
    */

    public int singleNumber(int[] nums) {
        int xor  = 0;

        for(int num: nums) {
            xor = (xor ^ num);
        }

       return xor;
    }
}