import java.util.HashMap;
import java.util.PriorityQueue;


// TC: O(N*logk)

class Node {
    int element;
    int frequency;

    Node(int element, int frequency) {
        this.element = element;
        this.frequency = frequency;
    }
}

class Solution {

    /*
        -> first save the frequency of every element in map
        -> then create a min heap of size k from the frequency map
        -> not max heap because we are only maintaining heap of size k 
        if (pq.size()>k) {
            pq.poll();`  // if used max heap then this will remove max frequency element, which shouldn’t be case.
        } 
     */


    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> mp = new HashMap<>();
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) ->  a.frequency - b.frequency); 
        int[] ans = new int[k];
        

        for(int i = 0;i<nums.length;i++) {
            mp.put(nums[i], mp.getOrDefault(nums[i], 0) + 1);
        }

        // O(Nlogk)
        for(int element: mp.keySet()) {
            pq.add(new Node(element, mp.get(element)));
            if (pq.size()>k) {
                pq.poll();
            }
        }

        // O(klogk)
        for(int i=k-1; i>=0; i--) {
            ans[i] = pq.poll().element;
        }

        return ans;

    }
}