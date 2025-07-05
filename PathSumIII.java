import java.util.HashMap;

public class PathSumIII {

    HashMap<Long, Integer> prefixMap = new HashMap<>();

    public int pathSum(TreeNode root, int targetSum) {
        return pathSumHelper(root, 0, targetSum);
    }

    /*
        1. Use preOrder technique to traverse the tree
        2. Use prefix sum technique over tree path
        3. At every node in path, save prefix path sum (path sum till that node) in HashMap
        4. if currentPathSum == targetSum then ans = ans + 1
        5. ans = ans + prefixMap.getOrDefault(currentPathSum - targetSum, 0);
    */
    public int pathSumHelper(TreeNode root, long currentPathSum, int targetSum) {
        if (root == null)
            return 0;
        
        int ans = 0; 
        currentPathSum += root.val;

        if (currentPathSum == targetSum) {
            ans = ans + 1;
        }

        // if we are able to find prefix paths with sum = "currentPathSum - targetSum" 
        // then we can remove that prefix path from curr_prefix_path then we found path which sums to target

        // In genereal, two prefix paths can have same sum, if last element added in path is zero
        if (prefixMap.get(currentPathSum - targetSum) != null) {
            ans = ans + prefixMap.get(currentPathSum - targetSum);
        }
        
        // add prefix path sum to prefixMap
        prefixMap.put(currentPathSum, prefixMap.getOrDefault(currentPathSum, 0)+1);

        ans = ans + pathSumHelper(root.left, currentPathSum, targetSum);
        ans = ans + pathSumHelper(root.right, currentPathSum, targetSum);

        // remove prefix path sum from prefixMap
        if (prefixMap.get(currentPathSum) == 1)
            prefixMap.remove(currentPathSum);
        else {
            prefixMap.put(currentPathSum, prefixMap.get(currentPathSum)-1);
        } 
        
        return ans;
    }
}
