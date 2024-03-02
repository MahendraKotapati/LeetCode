// https://www.geeksforgeeks.org/detect-cycle-undirected-graph/
//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DetectCycleInUndirectedGraph {
     public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.

    static boolean[] visited;

    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        
        visited = new boolean[V];

        Arrays.fill(visited,false);

        for(int i = 0; i < V; i++) { // to deal forests (not a connected graph)
            if (!visited[i]) {
                visited[i] = true;
                if (hasCycle(i, -1, adj)) {
                    return true;
                }
            }
        }

        return false;
    }


    public boolean hasCycle(int source, int parent, ArrayList<ArrayList<Integer>> adj) {

        for(int child: adj.get(source)) {

            if (visited[child]) {
                if (child == parent) { // since graph is undirected , source adjList has parent too. but that's not a cycle.
                    continue;
                }
                
                // means there is a back-edge to one of its ancestors
                return true;
            }

            visited[child] = true;
            if (hasCycle(child, source, adj)) {
                return true;
            }
        }
        return false;
    }
}