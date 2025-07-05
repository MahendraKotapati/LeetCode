import java.util.*;

public class SummaryRanges_228 {

    /*
     TC: O(N) SC: O(1)
     1. start the range with first element, see if it can be continued
        else { 
            save the current range and
            start another new range
        }
    */
    public List<String> summaryRanges(int[] nums) {

        List<String> rangesList = new ArrayList<>();
        
        if (nums.length == 0) {
            return rangesList;
        }

        int i=1, rangeStart = nums[0], requiredNum = nums[0]+1;
        
        while(i < nums.length) {
            if (nums[i] == requiredNum) { // current range is going good
                requiredNum++;
            }
            else {
                if (rangeStart == requiredNum - 1) { // same as rangeStart == nums[i-1]
                    rangesList.add(String.valueOf(rangeStart));
                } else {
                    rangesList.add(String.valueOf(rangeStart) + "->" + String.valueOf(requiredNum - 1));
                }
                // start new range
                rangeStart = nums[i]; requiredNum = rangeStart+1;
            }
            i++;
        }

        // same loop code to handle last range after 'i' reached n
        if (rangeStart == nums[nums.length-1]) {
            rangesList.add(String.valueOf(rangeStart));
        } else {
            rangesList.add(String.valueOf(rangeStart) + "->" + String.valueOf(requiredNum - 1));
        }

        return rangesList;
    }
}