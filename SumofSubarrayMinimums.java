import java.util.Stack;

class SumofSubarrayMinimums {

    int MOD = (int)(1e9 + 7);

    /*
        -> calculate contribution of each element (let be for element X) in final answer
        -> to find contribution of element X we need to find no.of subarrays where element X is minimum.
        -> So in the given array, find the range where X is minimum. 
        -> required range will be nothing but arr[left_min_index+1 : right_min_index-1]
        -> left_min_index = to the left of X, index of nearest element which is less than X 
        -> right_min_index = to the right of X, index of nearest element which is less than X 
        -> to calculate left_min_index, right_min_index use monotonic stack approach
        -> Now, for that range, find the no.of subarrays which includes element X in them.
        -> no_of_subarrays_X_is_minimum = (right_min_index - X_index) * (X_index - left_min_index) 
        -> contribution of element X in final ans = no_of_subarrays_X_is_minimum * X
    */

    public int sumSubarrayMins(int[] arr) {

        long ans = 0;
        int n = arr.length;
        Stack<Integer> s = new Stack<>();


        for(int i=0;i<n;i++) {

            // maintain strictly increasing monotonic stack array.
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                int top_index = s.pop();  // calculate contribution of the popping out element
                int left_min_index = s.isEmpty() ? -1 : s.peek(); // as we are maintaining increasing monotonic stack s.peek() will left_min_index
                int righ_min_index = i;  // i will be right_min_index as arr[s.peek()] >= arr[i]
                long no_of_times_top_ele_as_min  = (long)((righ_min_index - top_index) * (top_index - left_min_index)) % MOD;
                ans = (ans + (long)(no_of_times_top_ele_as_min * arr[top_index]) % MOD ) % MOD;
            }
            s.push(i);
        }

        // exact copy of above while loop
        while(!s.isEmpty()) {
            int top_index = s.pop();
            int left_min_index = s.isEmpty() ? -1 : s.peek();
            int righ_min_index = n;
            long no_of_times_top_ele_as_min  = (long)((righ_min_index - top_index) * (top_index - left_min_index)) % MOD;
            ans = (ans + (long)(no_of_times_top_ele_as_min * arr[top_index]) % MOD ) % MOD;
        }

        return (int)(ans % MOD);
    }
}