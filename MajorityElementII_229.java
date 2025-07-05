import java.util.*;

class Solution {

    /*
    1. follow boyer moore voting algorithm same like MajorityElement with n/2 times repeated.
    2. from below note, we know that at most two majorityElement elements (n/3 repeated) exists.
       why solution algo works ?
       i. assume we have two majorityElements then
       - we are sharing elements (which are not majorityElements) with majorityElements while cancelling out.
       - first majorityElement repeats > n/3 times [assume it from I to mid of II]
       - second majorityElement repeats > n/3 times [assume it from end of II to III]
       - the portion mid of II to just before end of II is shared between two majorityElements to cancel out.
       - this becomes same like MajorityElement with > n/2 times repeated in array[I:II] & array [II:III] individually.
       2. assume we have one majorityElements then
        - first majorityElement held in candidate1, 
          remaining all non-majorityElement elements being cancelled out by candidate2.

    Note: at most only 2 elements can be appear n/3 times in array of size n.
       because ..........|.........|...........
                n/3 (I)    n/3 (II)   n/3 (III)
       assume array is sorted and it consists of three parts
       let us say first majorityElement is from I and expand till mid of II.
       and second majorityElement is from II and expand till mid of III.
       here we can see that there is no space for third majorityElement existance.
    */

    public List<Integer> majorityElement(int[] nums) {
        int candidate1 = Integer.MIN_VALUE, candidate2 = Integer.MIN_VALUE, count1 = 0, count2 = 0, i;

        for(i=0;i<nums.length;i++) { 
             // nums[i] != candidate2 this check is to avoid candidate1 & candidate2 being hold same element
            if (count1 == 0 && nums[i] != candidate2) {
                candidate1 = nums[i];
                count1++;
            } else if (count2 == 0 && nums[i] != candidate1) { // nums[i] != candidate1 this check is to avoid candidate1 & candidate2 being hold same element
                candidate2 = nums[i];
                count2++;
            } else if (nums[i]==candidate1) {
                count1++;
            } else if (nums[i]==candidate2) {
                count2++;
            } else {
                // sharing non-majorityElements between two majorityElements to cancel out
                count1--;
                count2--;
            } 
        }; 

        List<Integer> res = new ArrayList<>();
        count1 = 0;
        count2 = 0;

        // check if candidate1, candidate2 are actually majorityElements or not.
        for(i=0;i<nums.length;i++) { 
            if (nums[i] == candidate1)  
                count1++;
            if (nums[i] == candidate2)
                count2++;
        }

        if (count1 > nums.length/3) res.add(candidate1);
        if (count2 > nums.length/3) res.add(candidate2);

        return res;

    }
}

/*
    [1,1,1,1,2,3,4,5,6,7]
*/