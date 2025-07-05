class Solution {
    
    /*
        Approach: 
        1. as nums1, nums2 is already sorted individually.
        2. we can compare nums1[i] , nums2[j] and proceed.
        3. Instead of pointers i, j starting from left, start them from right. this makes solution easier.

        Note: if pointers i, j started from left. then let's say nums1[i] > nums2[j]
              then nums2 be inserted (following increasing order) in num1[i] position only. it gives conflicts.
    */

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1, j = n-1; 

        for(int k=m+n-1; k>=0; k--) {
            if (j<0 || (i>=0 && nums1[i] > nums2[j])) { // nums2 is ended or (nums1 exist and nums1[i] > nums2[j])
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
        }
    }
}