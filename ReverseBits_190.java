class Solution {

    /*
    Approach: TC: O(1)
    1. we don't convert number to binary and then reverseBits instead we generate bits on fly 
       and work on it in terms of decimal (as we need to return decimal answer).
    2. do unsinged right shift operator (>>>) and get each bit to right most position 
       and then do number % 2 to get right most bit.
       multiply that bit with corresponding power
    3. repeat step2 for all bits and return the answer.
    */

    public int reverseBits(int number) {
        // ideally the input number should be binary string 
        // instead they are giving number and asking us to convert it to binary (2's complement as well if -ve)
        // now, treat the binary (which we get after convering the number) as input
        // now, reverse bits 

        int ret = 0, power = 31; // power should start at 31, because right most will be in left most in reversed bits.
        while (number != 0) {
            if ((number & 1) == 1) { // check if right most bit is 1, cannot use number % 2 == 1 because number can be -ve as well.
                ret += 1 << power; // cannont use Math.pow(2, power) because it overflow INT type.
            }
            number = number >>> 1; // unsinged right shift, doesn't preserve the sign
            power--;
        } 

        // as mentioned in question output can also -ve.
        // but in our solution when are we returing -ve ?
        // 1 << 31 = 2^31 cannot be stored in INT type. so it get stored as -2^31
        // remaining we sum like 2^30 or 2^27 .... so, 'ret' will be -ve.

        // so, indirectly we are converting 2's complement to decimal.
        // https://math.stackexchange.com/a/2268089
        return ret;

    }


    /*
    MY solution: find binary revers bits and return answer in decimal
    // you need treat n as an unsigned value
    public int reverseBits(int number) {
    
        StringBuilder binary = new StringBuilder("00000000" + "00000000" + "00000000" + "00000000");
        int idx=31, ans = 0;
        long n = number; // long is used to handle -2147483648
        boolean isNegative = false, skipComplement;

        if (n<0) {
            n = Math.abs(n); // if long not used Math.abs(-2147483648) cannot hold in int.
            isNegative = true;
        }

        while(n>0) {
            if (n%2 == 1)
                binary.setCharAt(idx, '1');

            n = n/2;
            idx--;
        }

        // shortcut way of finding 2's complement of a binary
        if (isNegative) {
            skipComplement = true;
            for(int i=binary.length()-1; i>=0; i--) {
                if (!skipComplement) {
                    binary.setCharAt(i, (binary.charAt(i) == '1' ? '0' : '1'));
                } else {
                    if (binary.charAt(i) == '1')
                        skipComplement = false;
                }
            }
        }

        binary = binary.reverse();
        System.out.println(binary);

        // convert binary number (treating it as unsigned integer) to decimal 
        for(int i=binary.length()-1; i>=0; i--) {
            ans = ans + (int)((long)Math.pow(2, 31-i) * (binary.charAt(i)-'0'));
        }

        return (int)ans;
    }
    */
}