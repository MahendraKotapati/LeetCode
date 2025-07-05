import java.util.*;

public class DetectCycleInDirectedGraph {

    ArrayList<Integer>[] graph;
    int visited[];

    // given an undirected graph find if it has cycle or not
    @SuppressWarnings("unchecked")
    public boolean detectCycle(int n, int[][] edges) {
        graph = new ArrayList[n];
        visited = new int[n];
        Arrays.fill(visited, 0);

        for(int i=0;i<n;i++)
            graph[i] = new ArrayList<>();

        for(int i=0;i<edges.length;i++) { // construct graph
            graph[edges[i][0]].add(edges[i][1]);
            graph[edges[i][1]].add(edges[i][0]);
        }

        for(int i=0;i<n;i++) { // if graph is disconnected
            if (visited[i] == 0) { // if node is not visisted
                if (hasCycle(i, -1))
                    return true;
            }
        }

       return false; 
    }

    public boolean hasCycle(int node, int parent) {
       visited[node] = 1; // 1 means node is in recursion stack, node visited but not explored

       for(int child: graph[node]) {
            if (visited[child] == 2) { // if child is already visited and explored
                continue;
            } else if (visited[child] == 1) { // if child is in recursion stack and comes again means there is a back edge and hence cycle exists
                return true;
            } else if (hasCycle(child, node)) { // if child not visisted
                return true;
            }
       }

       visited[node] = 2; // 2 means node is visted and explored

       return false;
    }
}