import java.util.*;

class Solution {

    /*
     This problem is similar to merge intervals problem.
     1. only exception is while covering the range we take intervalRangeEnd = Math.min(intervalRangeEnd, currentEnd);
        beacause only in common point we should shoot in order to minimize no.of arrows used.
     2. for intervals which are overlapping try to shoot in common point.
     3. once overlapping interval is ended. look for another overlapping interval if not found just use one arrorw for one interval.

     Note: we use one arrow for the entire overlapping interval ballons.
    */
    public int findMinArrowShots(int[][] points) {
        @SuppressWarnings("unused")
        int i=1, noOfArrows = 0, currentStart, currentEnd, intervalRangeStart, intervalRangeEnd;
        // intervalRangeStart, intervalRangeEnd - interval which we are covering right now.
        
        // sort by start times.
        Arrays.sort(points, (int[] a, int[] b) -> (a[0] < b[0]) ? -1 : 1);

        intervalRangeStart = points[0][0];
        intervalRangeEnd = points[0][1];

        while(i<points.length) {
            currentStart = points[i][0];  
            currentEnd = points[i][1];
            
            if(intervalRangeEnd >= currentStart) {
                intervalRangeEnd = Math.min(intervalRangeEnd, currentEnd); 
                // take minimum as we need to shoot in common point. if maximum taken it might cover some more intervals but we miss (we can't shoot) few starting intervals.
            } else {
                noOfArrows++;

                intervalRangeStart = currentStart;
                intervalRangeEnd = currentEnd;
            }  
            i++;  
        }

        // to cover last interval.
        noOfArrows++;

        return noOfArrows; 
    }
}