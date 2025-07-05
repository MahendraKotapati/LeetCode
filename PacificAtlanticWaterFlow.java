import java.util.*;


class Solution {

    /*
     * Approach: TC: O(m*n)   SC: O(m*n)
     * 1. Instead of traditional way of doing BFS/DFS for every cell to check if it gets water from both pacific and atlantic ocean
     * 2. Find all cells where pacific water reaches (pacificReachable[][] find using BFS)
     * 3. Find all cells where atlantic water reaches (atlanticReachable[][] find using BFS)
     * 4. Now, find cells which gets both pacific and atlantic water.
     */

     
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] pacificReachable = new boolean[m][n];
        boolean[][] atlanticReachable = new boolean[m][n];
        
        Queue<int[]> pacificQueue = new LinkedList<>();
        Queue<int[]> atlanticQueue = new LinkedList<>();

        for(int i=0;i<n;i++) {
            pacificQueue.add(new int[]{0, i});   
            atlanticQueue.add(new int[]{m-1, i});   
        }

        for(int i=0;i<m;i++) {
            pacificQueue.add(new int[]{i, 0});   
            atlanticQueue.add(new int[]{i, n-1});   
        }

        pacificReachable = bfs(pacificQueue, m, n, heights);
        atlanticReachable = bfs(atlanticQueue, m, n, heights);

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++)
                if (pacificReachable[i][j] && atlanticReachable[i][j])  
                    result.add(Arrays.asList(i,j));
        }

        return result;
    }

    public boolean[][] bfs(Queue<int[]> queue, int m, int n, int[][] heights) {
        boolean[][] reachable = new boolean[m][n];
        boolean[][] visited = new boolean[m][n];
        int[][] directions = new int[][] {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

        while(!queue.isEmpty()) {
            int[] position = queue.poll();
            int x = position[0];
            int y = position[1]; 
            visited[x][y] = true;
            reachable[x][y] = true;

            for(int[] direction: directions) {
                if (isValid(x+direction[0], y+direction[1], m, n, heights, visited, heights[x][y])) {
                    queue.add(new int[]{x+direction[0], y+direction[1]});
                }   
            }  
        }

        return reachable;
    }

    public boolean isValid(int i, int j, int m, int n, int[][] heights, boolean[][] visited, int parentHeight) {
        return (i>=0 && i<m) && (j>=0 && j<n) && (!visited[i][j]) && parentHeight <= heights[i][j] ; // height condition is a bit confusing in the question
    }

}