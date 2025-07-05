class Solution {

    /*
    TC: O(N) - we visit each & every node.
    SC: O(N) - recursion call stack in case skewed tree
    */

    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return 1+ Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}