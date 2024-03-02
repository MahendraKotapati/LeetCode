import java.util.ArrayList;
import java.util.Arrays;

// https://leetcode.com/problems/loud-and-rich/description/
// TC: O(V+E)


public class LoudAndRich {

    ArrayList<Integer>[] graph;
    int[] visited;
    int[] ans;


    /*
     * --> Create directed graph, root node will be poor, leaf nodes are richer.
     * --> apply dfs and find a node with min quiet in the current_node's sub tree (including that node)
     * --> apply dfs with caching so that only one dfs is sufficient to find answer for all nodes
     */
    @SuppressWarnings("unchecked")
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        
        int n = quiet.length;
        ans = new int[n];
        visited = new int[n];
        

        graph = new ArrayList[n];

        for(int i=0;i<n;i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i=0;i<richer.length;i++) {
            graph[richer[i][1]].add(richer[i][0]);
        }

        Arrays.fill(visited, 0);

        for(int i=0;i<ans.length;i++) {
            if (visited[i] == 0)
                dfs(i, quiet);
        }

        return ans;
    }

    public void dfs(int node, int[] quiet) {
        visited[node] = 1;
        ans[node] = node;  // node itself can also be answer sometimes in cases like leaf node or all nodes in subtree having quiet > curr_node quiet

        for(int child: graph[node]) {
            if (visited[child] == 0) {
                dfs(child, quiet);
            }

            // by here ans[child] is already calculated, so use that to find ans[node] 
            // ans[child] is alredy min quiet in that child's subtree so no need to calculate once again.
            if (quiet[ans[child]] < quiet[ans[node]]) { 
                ans[node] = ans[child];
            }
        }
    } 
}
