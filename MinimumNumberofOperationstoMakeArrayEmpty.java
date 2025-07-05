import java.util.*;

public class MinimumNumberofOperationstoMakeArrayEmpty {

    /*
     * Approach:
     * 1. first apply divide 3 operation (minOperations += freqCount/3)
     * 2. if remainder of freqCount is 1 then get back 3 from previous (accordingly decrement minOperations by 1) now freqCount is 4
     * 3. now, minOperations += freqCount/2
     */

    public int minOperations(int[] nums) {
        HashMap<Integer, Integer> count = new HashMap<>();
        int minOperations = 0;

        for(int i=0;i<nums.length;i++) {
            count.put(nums[i], count.getOrDefault(nums[i], 0)+1);
        }

        for(int key: count.keySet()) {
            int freqCount = count.get(key);
            if (freqCount == 1) return -1;
            else if (freqCount == 2 || freqCount == 3) minOperations++;
            else {
                // first apply divide by 3 operation 
                minOperations += freqCount/3; freqCount = freqCount%3;
                if (freqCount%2 == 1) { // if remaining is 1 then
                    freqCount = 3 + freqCount%2; // get back 3 from previous (accordingly decrement minOperations by 1) now freqCount is 4
                    minOperations--; 
                }
                minOperations += freqCount/2;
            }
        }

        return minOperations;
    }
}