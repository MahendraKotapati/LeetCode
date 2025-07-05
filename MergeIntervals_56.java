import java.util.*;

class Solution {

    /*
        Approach: TC: O(n*log(n)) SC: O(1)
        1. sort intervals by start time.
        2. for current interval check if it is started even before the previous interval ended.
           if  
            so, merge current interval with previous interval 
            also update intervalRangeEnd = Math.max(intervalRangeEnd, currentEnd);
            now, we are covering the interval till Math.max(intervalRangeEnd, currentEnd)

           else
            just add the intervalRange which we are covering to ansList and start new intervalRange

        Note: why sorting by start times work ?
              [s1, e1] [s2, e2], [s3, e3] - sorted by start time
              proof by contradiction, 
              assume there is case that [s1, e1] [s2, e2] are not overlapping but [s1, e1] [s3, e3] are overlapping, 
              but it is not posssible because it should be s1 < e1 < s2 < s3
              as e1 < s3 , how would [s1, e1] [s3, e3] will overlap ? so, our assumed case is invalid.

    */

    public int[][] merge(int[][] intervals) {
        int i=1, currentStart, currentEnd, intervalRangeStart, intervalRangeEnd;
        // intervalRangeStart, intervalRangeEnd - interval which we are covering right now.
        List<List<Integer>> ans = new ArrayList<>();

        // sort by start times.
        Arrays.sort(intervals, (int[] a, int[] b) -> a[0]-b[0]);

        intervalRangeStart = intervals[0][0];
        intervalRangeEnd = intervals[0][1];

        while(i<intervals.length) {
            currentStart = intervals[i][0];  
            currentEnd = intervals[i][1];
            
            if(intervalRangeEnd >= currentStart) {
                intervalRangeEnd = Math.max(intervalRangeEnd, currentEnd);
            } else {
                ans.add(new ArrayList<>(Arrays.asList(intervalRangeStart, intervalRangeEnd))); 

                intervalRangeStart = currentStart;
                intervalRangeEnd = currentEnd;
            }  
            i++;  
        }

        // to cover the last interval.
        ans.add(new ArrayList<>(Arrays.asList(intervalRangeStart, intervalRangeEnd))); 
        
        // convert 2d list to 2d array
        int[][] mergedIntervals = ans.stream()
                   .map(row -> row.stream().mapToInt(a -> a).toArray())
                   .toArray(int[][]::new);

        return mergedIntervals;
    }
}