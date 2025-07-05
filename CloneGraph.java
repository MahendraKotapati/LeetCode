import java.util.*;

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class CloneGraph {
    
    int[] visited = new int[101];
    HashMap<Node, Node> cloneMap = new HashMap<Node, Node>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        Arrays.fill(visited, 0);
        // create a rootNode Clone and save in cloneMap
        Node rootNodeCopy = new Node(node.val, new ArrayList<>());
        cloneMap.put(node, rootNodeCopy);

        dfsCopyNodes(node);
        return rootNodeCopy; 
    }

    /*
        Approach1:  TC: O(V+E)    SC: O(V)
        1. do DFS traversal, while traversing make a clone for each node
        2. save mapping of original_node to clone_node in cloneMap
        3. and add childClone in parentClone neighbors[] list while traversing


        Approach2: 
         We can follow same approach1 with BFS
    */
    public void dfsCopyNodes(Node node) {
        if (node == null) {
            return ;
        }

        visited[node.val] = 1;
        Node currNodeCopy = cloneMap.get(node);

        for(Node child: node.neighbors) {
            if (visited[child.val] == 0) {
                // child is not visited so, create a child clone and put it in cloneMap
                cloneMap.put(child, new Node(child.val, new ArrayList<>()));
                dfsCopyNodes(child);
            }

            // if child already visited then it's copy should exist in cloneMap
            Node childNodeCopy = cloneMap.get(child);
            currNodeCopy.neighbors.add(childNodeCopy);
        }   

    }

}