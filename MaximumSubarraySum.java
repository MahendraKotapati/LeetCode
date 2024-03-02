import java.util.Scanner;

public class MaximumSubarraySum {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = {-1,0,1,2,-1,-4,-2,-3,3,0,4};
        System.out.println("Ans: " + maxSubArray(nums));
        sc.close();
    }

    /*
     *  i.....j, j+1, j+2 .......p,p+1
     *  we can generate all subarrays in O(n^2)
     *  nums[i,j], nums[i, j+1], nums[i, j+2] ......
     *  nums[i+1,j], nums[i+1, j+1], nums[i+1, j+2] .......
     *  let us say at any point of time nums[i, j] is -ve 
     *  then we don't need to calculate nums[i, j+1], nums[i, j+2].... because negative contribution always decrease the value
     *  so, instead now calculate the subarray from j+1 so, calculate nums[j+1, p], nums[j+1, p+1].....
     */

    public static int maxSubArray(int[] nums) {
        
        int curr_sum = 0, max_sum = nums[0];

        for(int i = 0; i<nums.length; i++) {
            curr_sum += nums[i];
            max_sum = Math.max(max_sum, curr_sum);

            if (curr_sum < 0) {
                curr_sum = 0;
            }
        }

        return max_sum;
    }

}
