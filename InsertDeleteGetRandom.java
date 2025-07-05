/*
    Approach: 
    1. we can use ArrayList / array to support Insert in O(1) and getRandom in O(1).
    
    To support Delete in O(1)
    2. In general, deletion in arrayList/ array is O(n) but we can delete last element in O(1)
    3. if we are able to swap the element to be deleted (delete element) with last element of array, then now 
       delete element is in last position so, we can perform deletion in O(1)
    4. In order to swap the delete element and last element we should get the delete element index in O(1) time
       so, we use HashMap and store element -> index mapping.
*/

import java.util.HashMap;
import java.util.Random;

class RandomizedSet {
    int[] dataSet;
    HashMap<Integer, Integer> indexDataMap;
    int size;

    public RandomizedSet() {
        dataSet = new int[2*100000];
        indexDataMap = new HashMap<>(); // element to index map
        size = 0;
    }
    
    public boolean insert(int val) {
        if (indexDataMap.containsKey(val)) {
            return false;
        }
        dataSet[size] = val;
        indexDataMap.put(val, size);
        size++;

        return true;
    }
    
    public boolean remove(Integer val) {
        if (!indexDataMap.containsKey(val)) {
            return false;
        } 
        
        int removeIdx = indexDataMap.get(val);
        // order of below 2 lines is important if only one element is in dataSet;
        indexDataMap.put(dataSet[size-1], removeIdx); // set last element index to delete element index, since we gonna swap
        indexDataMap.remove(val); // remove "delete element" entry from HashMap

        // swap delete element and last element
        int temp = dataSet[size-1];
        dataSet[size-1] = dataSet[removeIdx];
        dataSet[removeIdx] = temp;

        size--; // decrement size as last element is deleted;

        return true;
    }
    
    public int getRandom() {
        int randomIndex = new Random().nextInt(size); // generates random index between [0, size-1]
        return dataSet[randomIndex];
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */