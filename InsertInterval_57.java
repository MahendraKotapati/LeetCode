import java.util.*;

class Solution {

    /*
        Approach: TC: O(n) SC: O(1)
        1. look for the position where new interval can be added following the condition array sorted by start time 
           also add intervals till before new interval to ansList
        2. Here we have 3 cases
            I. [1, 10] [200, 300] New - [5, 45]
           II. [1, 10] [200, 300] New - [30, 40]
          III. [1, 10] [200, 300] New - [200, 250]
        3. Now insert and merge the new interval 
        4. add the remaining intervals to ansList
    */

    public int[][] insert(int[][] intervals, int[] newInterval) {   
        int i=0;
        List<List<Integer>> ansList = new ArrayList<>();

        // copy all intervals till before new interval can be added.
        while(i<intervals.length && intervals[i][0] < newInterval[0]) {
            ansList.add(new ArrayList<>(Arrays.asList(intervals[i][0], intervals[i][1])));
            i++;
        }


        // if newInterval should be merged with current last interval of ansList
        // To handle case:I
        if (i>0 && ansList.get(ansList.size()-1).get(1) >= newInterval[0]) {
            List<Integer> last = ansList.get(ansList.size()-1);
            newInterval[0] = last.get(0);
            newInterval[1] = Math.max(newInterval[1], last.get(1));
            // remove last
            ansList.remove(ansList.size()-1); 
        }

        // merging intervals which are overlapping with newInterval.
        while(i < intervals.length && newInterval[1] >= intervals[i][0]) {    
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        // all newInterval overlapping intervals are merged.
        // so just one interval representing all of them. 
        ansList.add(new ArrayList<>(Arrays.asList(newInterval[0], newInterval[1])));


        // copy remaining all intervals after new interval added.
        while(i<intervals.length) {
            ansList.add(new ArrayList<>(Arrays.asList(intervals[i][0], intervals[i][1])));
            i++;
        }

        // 2d list to 2d array
        return ansList.stream()
                   .map(row -> row.stream().mapToInt(a->a).toArray())
                   .toArray(int[][]::new);
    }
}