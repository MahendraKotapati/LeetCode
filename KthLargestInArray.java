// https://leetcode.com/problems/kth-largest-element-in-an-array/

// TC: O(nLogk)
// SC: O(k)

import java.util.PriorityQueue;
import java.util.Scanner;

public class KthLargestInArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = {-1,0,1,2,-1,-4,-2,-3,3,0,4};
        int k = 2;
        System.out.println("Ans: " + findKthLargest(nums, k));
        sc.close();
    }    

    // maintain a minHeap of size k

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for(int i = 0; i < nums.length; i++) {
            minHeap.add(nums[i]);

            // minHeap should always contain k largestElements
            // if minHeap size > k means we have k + 1 largest elements, 
            // so we can delete minHeap head as we are sure that it won't be kth largest element.
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        return minHeap.peek();
    }

}


