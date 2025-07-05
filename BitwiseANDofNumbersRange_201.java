class Solution {

    /*
        Approach: O(32 = no.of bits in right)
        1. work in terms of bits
        2. for 'right', if bit in position is '0' then in result also it is '0'
        3. if bit in position is 1, then try to look if 0 exists in the same position, for any one of the number in range [left, right] 
           
           i. create a temp number which it nothing but 'right' but in bit position it will be '0', 
              and all bits which are right to it is '1' // why ? if all '0's then in condition ii, it say, temp < left but it is not correct.
          ii. if temp < left means zero which we are looking for is not there (is outside of range[left, right])
              so, in result this bit will be '1'

    */


    public int rangeBitwiseAnd(int left, int right) {
        int max = right, res = 0, pos=0;

        while(max > 0) {
            int currentBit = max % 2;

             //  if currentBit is 1, then try to look if 0 exists in current bit position in range [left, right] 
            if (currentBit == 1) {
                int temp = (right & (~(1<<pos))); // make bit in currentBit position to '0'
                temp = temp | ((1<<pos)-1); // set all bits which are right to currentBit as '1'
                
                if (temp < left) { // if temp number formed in less than left (min) means zero which we are looking for is not there 

                    // in [left, right] for all, currentBit position is 1 so, in result also it should be 1 
                    res = res | (1<<pos); // setting a bit to 1 in 'pos' position. 
                }
            }

            // if currentBit is 0, then in res, this bit will also zero

            pos++;
            max = max / 2;
        }

        return res;
    }
}