import java.util.LinkedList;
import java.util.Iterator;

// DFS algorithm to print graph
// Time Complexity: O(V + E), where V is the number of vertices and E is the number of edges in the graph.

public class DFS_Algorithm {
    LinkedList<Integer> adjList[];
    static boolean visited[];

    DFS_Algorithm(int vertices) {
        adjList = new LinkedList[vertices];
        visited = new boolean[vertices];

        for (int i = 0; i < vertices; i++) {
            adjList[i] = new LinkedList<Integer>();
        }
    }

    void addEdge(int src, int dest) {
        adjList[src].add(dest);
    }

    void dfs(int vertex) {
        visited[vertex] = true;
        System.out.print(vertex + " ");

        Iterator<Integer> it = adjList[vertex].listIterator();

        while(it.hasNext()) {
            int adj = it.next();
            if (!visited[adj]) {
                dfs(adj);
            }
        }
        
    }

    public static void main(String[] args) {

        int vertices = 4;
        DFS_Algorithm g = new DFS_Algorithm(vertices);
        
        // creating directed graph
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 3);

        // since graph is disconnected graph we need run dfs from each vertex to cover all nodes.
        for (int i = 0; i < vertices; i++) { 
            if (!visited[i]) {
                g.dfs(i);
                System.out.println();
            }
        }
    }
}
