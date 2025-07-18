// https://www.geeksforgeeks.org/detect-cycle-undirected-graph/

import java.util.*;

class DetectCycleInUnDirectedGraph {

    ArrayList<Integer>[] graph;
    boolean visited[];

    // given an undirected graph find if it has cycle or not
    @SuppressWarnings("unchecked")
    public boolean detectCycle(int n, int[][] edges) {
        graph = new ArrayList[n];
        visited = new boolean[n];
        Arrays.fill(visited, false);

        for(int i=0;i<n;i++)
            graph[i] = new ArrayList<>();

        for(int i=0;i<edges.length;i++) { // construct graph
            graph[edges[i][0]].add(edges[i][1]);
            graph[edges[i][1]].add(edges[i][0]);
        }

        for(int i=0;i<n;i++) { // if graph is disconnected
            if (!visited[i]) {
                if (hasCycle(i, -1))
                    return true;
            }
        }

       return false; 
    }

    public boolean hasCycle(int node, int parent) {
       visited[node] = true;

       for(int child: graph[node]) {
            if (child == parent) continue; // since it is a undirected graph, there always exists an edge from  child to parent and parent to child
            
            if (visited[child]) { // if child is already visisted, there is a back edge so it forms a cycle
                return true;
            } else if (hasCycle(child, node)) {
                return true;
            }
       }

       return false;
    }
}