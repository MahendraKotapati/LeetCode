// https://leetcode.com/problems/single-number-ii/

import java.util.Scanner;

public class SingleNumberII {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = {-2,-2,1,1,4,1,4,4,-4,-2};
        System.out.println("Ans: " + singleNumber(nums));
        sc.close();
    }

    // This approach works for negative numbers too, Integer has 0-31 bits (32 bits total) last bit (31th bit) is used to identify sign 
    public static int singleNumber(int[] nums) {
        long count = 0; int singleNumber = 0;

        for(int bit_position=0; bit_position<32; bit_position++) {
            count = 0;
            for(int i = 0; i< nums.length; i++) {
                if ((nums[i] & (1<<bit_position)) != 0) { // important we can't do (nums[i] & (1<<bit)) > 0, this is wrong if nums[i] is -ve 
                    count++;
                } 
            }
            
            // as every element repeated thrice except one element, 
            // curr_bit in singleNumber = 1, if no.of set bits in curr_bit position for all array elements not a multiple of 3
            // curr_bit in singleNumber = 0, if no.of set bits is a multiple of 3
            if ((count % 3 != 0)) {
                singleNumber = (singleNumber | (1 << bit_position));  // setting bit_position to 1 in singleNumber
            }
        }

        return singleNumber;   
    }
}
