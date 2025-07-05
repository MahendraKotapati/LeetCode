import java.util.*;

class Node {
    int x;
    int y;
    double distance;

    Node(int x, int y, double distance) {
        this.x = x;
        this.y = y;
        this.distance = distance;
    }
}

public class KClosestPointstoOrigin {

    /* Approach1 : Time Complexity: O(nlogK)    SC: O(K)
        1. Calculate Euclidean distance for every point and add it maxHeap
        2. as we need only k points, the size of heap can be 'k'
        3. we need to use maxHeap though we require closest points because at any point of time, if the heap.size() > K
           then we need to remove element which having greater distance (i.e topNode of heap)
    */

    /* Approach2: TC: O(nLogn)    SC: O(1)
        1. sort points in ascending order based on its distance from origin using Euclidean formula
        2. now return first k points in sorted array
    */

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Node> maxHeap = new PriorityQueue<Node>((Node a, Node b) -> { 
            if (b.distance < a.distance) // decreasing order
                return -1;
            else 
                return 1;
        });
        double distance;
        int[][] ans = new int[k][2];

        for(int i=0;i<points.length;i++) {
            distance = Math.sqrt(points[i][0] * points[i][0] + points[i][1] * points[i][1] + 0.0);

            maxHeap.add(new Node(points[i][0], points[i][1], distance));
            if (maxHeap.size() > k) // maintain maxHeap of size K
                maxHeap.poll(); // poll/add operations cost log(k) as size of heap is k
        }

        // returning answer
        int j=0;
        while(!maxHeap.isEmpty()) {
            Node maxNode = maxHeap.poll();
            ans[j][0] = maxNode.x;
            ans[j][1] = maxNode.y;
            j++;
        }

        return ans;
    }


}