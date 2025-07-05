import java.util.PriorityQueue;


// TC: O(nlogk)

public class MaximizeHappinessofSelectedChildren {
    public long maximumHappinessSum(int[] happiness, int k) {

        long totalHappiness = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // minHeap

        for(int i=0;i<happiness.length;i++) {
            minHeap.add(happiness[i]);
            if (minHeap.size() > k) { // maintain minHeap of size k
                minHeap.poll();
            }
        }

        while(minHeap.size() > 0) {
            int currentHappiness = minHeap.poll() - (k-1);
            currentHappiness = currentHappiness > 0 ? currentHappiness : 0 ;
            totalHappiness += currentHappiness;
            k--;
        }

        return totalHappiness;

    }
}