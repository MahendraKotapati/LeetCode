class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
}


/*
 * 
 *  Approach 1: Inorder traversal of BST should produce sorted order, so do Inorder traversal and if all curr_node > prev_node or not
 *  Approach 2: Do PostOrder traversal and root should follow root_node > max(left_sub_tree) && root_node < min(right_subtree)
 * 
 * 
 * 
 * Wrong approach: For every node just checking root.val > root.left.val && root.val < root.right.val
 * This approach will fail for the case 
 *             10
 *            /   \
 *           2     20 
 *                /  \
 *              15   100
 */

class ValidateBinarySearchTree {

    boolean isValid;

    public boolean isValidBST(TreeNode root) {
        isValid = true;
        postOrder(root);
        return isValid;
    }

    // Approach 2 
    public int[] postOrder(TreeNode root) {
        if (root == null) {
            int[] res = new int[2];
            return res;
        }

        int[] left = postOrder(root.left);
        int[] right = postOrder(root.right);

        int left_min = left[0], left_max = left[1];
        int right_min = right[0], right_max = right[1];


        if ((root.left!= null && root.val <= left_max) || (root.right!= null && root.val >= right_min)) {
            isValid = false;
        }

        // if left sub tree is null;
        if (root.left == null) {
            left_min = root.val;
        }

        // if right sub tree is null;
        if (root.right == null) {
            right_max = root.val;
        }

        int[] res = {left_min, right_max};

        return res;
    }
}