import java.util.*;

class Node {
    String node;
    double weight;

    Node(String node, double weight) {
        this.node = node;
        this.weight = weight;
    }
}

class Solution {
    HashSet<String> visited;

    /*  Approach:
        1. model this problem as graph problem, let a/b = 2.0, b/c = 3.0
            then (a/b) * (b/c) = 2*3 ==> a/c = 6.0
            construct the graph for edges a -> b, b -> a, b -> c, c -> b
        2. then for each query run dfs from source to target
        3. if there is a path from source to target means we can find the source/target value
           which is nothing but each edge weight is multipled in source to target path
    */

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
       HashMap<String, List<Node>> graph = new HashMap<>();
       double[] ans = new double[queries.size()];
       visited = new HashSet<String>();

       for(int i=0;i<equations.size();i++) {
            List<String> edge = equations.get(i);
            double weight = values[i];
            addEdge(edge.get(0), edge.get(1), weight, graph);  // add edge from a, b 
            addEdge(edge.get(1), edge.get(0), 1.0/weight, graph); // add edge from b, a
       }

       for(int i=0;i<queries.size();i++) {
            List<String> query = queries.get(i);
            visited.clear(); // visited array is cleared for each query
            if (graph.get(query.get(0)) == null || graph.get(query.get(1)) == null) {
                ans[i] = -1;
            } else if (query.get(0).equals(query.get(1))) {
                ans[i] = 1;
            } else {
                ans[i] = dfs(query.get(0), query.get(1), graph);
            }
       }

       return ans;
    }

    public double dfs(String src, String target, HashMap<String, List<Node>> graph) {
        if (src.equals(target))
            return 1.0;
        
        double currentPathWeight = -1;

        visited.add(src);

        for(Node node: graph.get(src)) {
            if (!visited.contains(node.node)) {
                currentPathWeight = dfs(node.node, target, graph);
                if (currentPathWeight != -1) { // it means found the target
                    return node.weight * currentPathWeight;
                }
                // as reached here target not found, look in other children trees
            }
        }

        return currentPathWeight;
    }

    public void addEdge(String a, String b, double weight, HashMap<String, List<Node>> graph) {
        if (graph.get(a) == null) {
            graph.put(a, new ArrayList<>());
        }
        graph.get(a).add(new Node(b, weight));
    }
}