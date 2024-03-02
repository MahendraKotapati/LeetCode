import java.util.Scanner;

public class SingleElementInSortedArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = {1,1,2,2,3,3,4,4,5};
        System.out.println("Ans: " + singleNonDuplicate(nums));
        sc.close();
    }

    /*
     * if all elements are repeated twice , then every Even and Odd pair index elements should be same.
     * if single element is introduced in the array this pattern will be missed (from single element index to end of array)
     */

    public static int singleNonDuplicate(int[] nums) {

        int low = 0, mid, high = nums.length - 1;

        while(low <= high) {
            
            mid = (low + high) / 2;

            // if left element different or left element doesn't exist
            boolean isLeftDifferent = mid - 1 < 0 || (mid - 1 >= 0 && nums[mid] != nums[mid-1]); 

            // if right element different or right element doesn't exist
            boolean isRightDifferent = mid + 1 >= nums.length || (mid + 1 < nums.length && nums[mid] != nums[mid+1]); 

            
            if (isLeftDifferent && isRightDifferent) { // if left and right elements are different means arr[mid] is single element
                return nums[mid];
            } else if (isLeftDifferent) {
                if (mid % 2 == 0) { // mid is even and left is different means arr[low:mid] every element is twice
                    low = mid + 1; 
                } else {
                    high = mid - 1; // mid is odd and left is different arr[mid:high] every element is twice
                }
            } else if (isRightDifferent) {
                if (mid % 2 == 0) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

        }

        return -1;
    }

    /*
     
     1 1 2 2 3 3 4 4 5     --- arr[i]
     0 1 2 3 4 5 6 7 8     --- index

     1 1 2 3 3 4 4 5 5     --- arr[i]
     0 1 2 3 4 5 6 7 8     --- index

    */

}
