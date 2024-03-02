import java.util.Scanner;

/*
 *  There is an integer array nums sorted in ascending order (with distinct values).
    Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) 
    such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). 
    For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
    Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
 * 
 *  
 * 
 */

public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;
        System.out.println("Ans: " + search(nums, target));

        sc.close();
    }

    /*
     * when arr[low:high] is rotated then either of arr[low:mid] or arr[mid:high] will be in sorted order
     * then we consider one of the half array and check target is in that range if so discard other half
     */
    public static int search(int[] arr, int target) { 
        int mid, low = 0, high = arr.length - 1;

        while (low <= high) {
            mid = (low + high) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[low] > arr[high]) { // arr[low:high] is rotated
                if (arr[low] <= arr[mid]) { // arr[low:mid] is sorted order
                   if (target >= arr[low] && target < arr[mid]) // target is in the range of arr[low:mid]
                    high = mid -1; 
                   else 
                    low = mid + 1;
                }
                else if (arr[high] >= arr[mid]) { // arr[mid:high] is sorted
                    if (target > arr[mid] && target <=arr[high]) low = mid + 1; // // target is in the range of arr[mid:high]
                    else high = mid - 1;
                }
            } else { // arr[low:high] is not rotated
                if (arr[mid] < target) {
                    low = mid +1;
                } else if (arr[mid] > target) {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }
}
