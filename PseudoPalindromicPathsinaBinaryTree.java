// https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree/

public class PseudoPalindromicPathsinaBinaryTree {

    int[] count = new int[10];

    // Approach
    // 1. Do Inorder traversal and for each leaf node check if the path from root to leaf is pseduo palindrome or not

    public int pseudoPalindromicPaths (TreeNode root) {
        if (root == null) return 0;
        count[root.val]++; // include root in the path
        int leftCount = pseudoPalindromicPaths(root.left);
        
        // if leaf node check if it pseudo-palindrome or not
        if (root.left == null && root.right == null) { 
            boolean hasOdd = false;
            int isPseudoPalindrome = 1; 
            // for pseudo-palindrome atmost one, odd frequencry(count) digit should be allowed.
            for(int i=1;i<=9;i++) {
                if (count[i]%2==1 && hasOdd) isPseudoPalindrome = 0;
                else if (count[i]%2==1 && !hasOdd) hasOdd = true;
            }
            count[root.val]--;
            return isPseudoPalindrome;
        }

        int rightCount = pseudoPalindromicPaths(root.right);
        count[root.val]--; // remove root from the path

        return leftCount + rightCount;
    }
}