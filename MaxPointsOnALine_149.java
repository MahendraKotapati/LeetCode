import java.util.*;

public class MaxPointsOnALine_149 {

    /*
    Approach: TC - O(n^2)  SC - O(n)
        https://math.stackexchange.com/questions/3663161/show-that-three-points-lie-on-the-same-line
        1. 3 points A, B, C lie on same line if slope of AB = slope of BC, and both should have common point B
           we can generalize above point to 'n' points.
        2. we can take each point as mid point and calculate slope with remaining points
            the points which are in same line with mid point will have same slope.
        Note: current mid point might be part of multiple lines, In below figure the intersection is mid point.

           /
          /\ 
         /  \
        /

    */


    public int maxPoints(int[][] points) {
        HashMap<Double, Integer> countMap = new HashMap<>();
        int midX, midY, x2, y2, currCount, maxPointsInLine = 0;
        double slope;

        for(int mid=0;mid<points.length;mid++) {
            for(int i=0;i<points.length;i++) {
                if (i==mid)
                    continue;
                midX = points[mid][0]; midY = points[mid][1];
                x2 = points[i][0]; y2 = points[i][1];
                
                slope = (y2 - midY + 0.0)/ (x2 - midX);
                currCount = countMap.getOrDefault(slope, 0) + 1;
                countMap.put(slope, currCount);
                maxPointsInLine = Math.max(maxPointsInLine, currCount);
            }
            countMap.clear();
        }

        return maxPointsInLine + 1; // + 1 is done to include mid point as well
    }
}