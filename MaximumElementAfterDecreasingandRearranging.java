import java.util.Arrays;

class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        
        if (arr.length == 1) return 1;

        Arrays.sort(arr);
        arr[0] = 1; // first element always should be 1

        for(int i=1;i<arr.length;i++) {
            // try to set the value arr[i] to arr[i-1] + 1, it is not possible if existing arr[i] even less than arr[i-1] + 1 
            // because only decrease operation is allowed on arr[i]
            if (arr[i-1]+1 <= arr[i]) 
                arr[i] = arr[i-1]+1; // we need maximum element after all operations, so try to increase the value
            else 
                arr[i] = arr[i-1]; // as we can't increase the value keep the value same as previous element
        }

        return arr[arr.length-1]; // return maximum value
    }
}