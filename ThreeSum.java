import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.Scanner;


/*
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] 
 * such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * Notice that the solution set must not contain duplicate triplets.
 */

public class ThreeSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = {-1,0,1,2,-1,-4,-2,-3,3,0,4};
        System.out.println("Ans: " + threeSum(nums));
        sc.close();
    }

    /*
     * Two Pointers approach
     * It is similar to two sum problem. 
     * Sort the array
     * Fix nums[i], then find nums[j] + nums[k] such that nums[i] + nums[j] + nums[k] = 0 using two pointer approach
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> tripletList = new HashSet<List<Integer>>(); // Set to avoid dulicate triplets;
        int j,k;

        Arrays.sort(nums);

        for(int i = 0; i < nums.length-2; i++) {

            // two pointer approach
            j = i+1; k = nums.length - 1;

            while(j < k) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    tripletList.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;k--;
                } else if (nums[i] + nums[j] + nums[k] < 0) {
                    j++;
                } else if (nums[i] + nums[j] + nums[k] > 0) {
                    k--;
                }
            }
        }

        return new ArrayList<>(tripletList);  
    }

    /*
     *  HashMap approach
     * 
     *  Run two loops. let us say nums = [...nums[i]...........nums[j]....] , the elements between i, j are inserted into map
     *  so, now we have nums[i] , nums[j] we check for -(nums[i] + nums[j]) in the map if found. we found a triplet.
     *  add that triplet to Java Set.
     * 

    
    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> tripletList = new HashSet<List<Integer>>(); // Set to avoid dulicate triplets;
        Map<Integer, Integer> mp = new HashMap<Integer, Integer>();

        for(int i = 0; i < nums.length; i++) {
            mp.clear();

            for (int j = i+1; j < nums.length; j++) {

                if (mp.get(-(nums[i] + nums[j])) != null) {
                    ArrayList<Integer> triplet = getSortedTriplet(nums[i], nums[j], -(nums[i] + nums[j]));
                    tripletList.add(triplet);
                }
                mp.put(nums[j], 1);
            }
        }

        return new ArrayList<>(tripletList);  
    }

    public static ArrayList<Integer> getSortedTriplet(int a, int b, int c) {
        Integer[] arr = {a, b, c};
        Arrays.sort(arr);
        return new ArrayList<Integer>(Arrays.asList(arr));
    } 
    */

}
