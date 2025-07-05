public class IncreasingTripletSubsequence {
    /*
    Approach1:   TC: O(n)   SC: O(1)
    1. for every element if there exists an element less than that on left side (left_min)
    2. so we formed 'a' , 'b' in the required triplet a < b < c, now we need to lookout for 'c' (element greater than b) while traversing.
    3. let us say while traversing if we found one more 'p', 'q' in the required triplet p < q < r 
    4. Now we need to lookout for element greater than min(b, q)
    
    Example: let us say if we find 12, 13 (a, b)
              and then found 4, 5 (p, q)
              then we nedd to look for an element greater than 5 (not an element greater than 13)
    */

    /*
    Approach2: TC: O(n)  SC: O(n)
    1. calculate leftMin array (contains leftMin[i] contains minElement in nums[0:i])
    2. calculate rightMax array (contains rightMax[i] contains maxElement in nums[n-1:i])
    3. then iterate through nums[] 
       if (nums[i] != leftMin[i] && nums[i] != rightMax[i])
            return true; // we found a triplet
    */

    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) return false;

        int leftMinIndex = 0, minSecondElement = Integer.MAX_VALUE;
        
        for(int i=0;i<nums.length;i++) {
            if (nums[leftMinIndex] > nums[i]) { // calculate left min index
                leftMinIndex = i;
            }

            // looking for third element is triplet, as we have first two elements
            if (nums[i] > minSecondElement) // if found element greater than secondElement
                return true; 

            if (nums[leftMinIndex] == nums[i]) // if current element doesn't have any lesser element on left side 
                continue;
            
            // current element has lesser element on left side, so 'a', 'b' elements found 
            // a -> nums[leftMinIndex], b -> nums[i]
            minSecondElement = Math.min(minSecondElement, nums[i]);
        }

        return false;

    }
}