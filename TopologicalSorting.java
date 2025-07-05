// https://www.geeksforgeeks.org/topological-sorting-indegree-based-solution/  (Khan's algorithm)
// TC: O(V+E), V - total vertices, E - total edges
// SC: O(V)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class TopologicalSorting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] edges = {{0, 1}};
        int totalNodes = 2;

        List<Integer> topologicalOrder = findTopologicalOrder(totalNodes, edges);

        for(int node: topologicalOrder) {
            System.out.print(node + " ");
        }

        sc.close();
    }

    // find topo sort using Khan's algorithm
    public static List<Integer> findTopologicalOrder(int totalNodes, int[][] edges) {
        Queue<Integer> q = new LinkedList<Integer>();
        
        @SuppressWarnings("unchecked")
        List<Integer>[] adj = new ArrayList[totalNodes]; 
        List<Integer>topologicalOrder = new ArrayList<Integer>();

        int[] indegree = new int[totalNodes];
        int a, b;
        Arrays.fill(indegree, 0);


        for(int i = 0; i < totalNodes; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        

        for(int i = 0; i < edges.length; i++) {
            a = edges[i][0];
            b = edges[i][1];
            indegree[b]++;

            adj[a].add(b);
        }

        for(int i = 0; i < totalNodes; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        while(q.size() > 0) {

            int node = q.poll();
            topologicalOrder.add(node);

            for(int child: adj[node]) {
                indegree[child]--;

                if (indegree[child] == 0) {
                    q.add(child);
                }
            }
        }

        // topological sorting is not possible
        if (topologicalOrder.size() < totalNodes) {
            System.out.println("Topological sorting is not possible");
            return new ArrayList<>(); // returning empty array
        }

        return topologicalOrder;
    }
}
