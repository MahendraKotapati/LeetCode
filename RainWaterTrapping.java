import java.util.Stack;

public class RainWaterTrapping {

    /*
     * for every element calculate it's contribution (water trapped because of that) 
     * for every element, to calculate it's contirbution calculate left_max_element_index and right_max_element_index
     * we can calculate left_max_element_index, right_max_element_index using monotonic stack approach (maintain strictly decreasing order stack)
     * height of water trapped because of curr_element, height_water = Math.min(left_max_element, right_max_element) - curr_element;
     * width of water trapped becuase of curr_element = (right_max_index - left_max_index - 1)
     * so, water_trapped  = (right_max_index - left_max_index - 1) * height_water;
     * 
     * In monotonic stack approach here, before pusing curr_element to stack, 
     * we pop any elements which are greater than curr_element in top of the stack.
     * while popping we calculate the contribution of popped out element.
     */

    public int trap(int[] height) {
        Stack<Integer> s = new Stack<>(); // strictly decreasing order
        int ans = 0, i;

        for(i=0;i<height.length;i++) {

            // pop elements from stack, so that it maintains decreasing order.
            while(!s.isEmpty() && height[s.peek()]<=height[i]) {
                int top_index = s.pop();

                int left_max_index = s.isEmpty() ? 0 : s.peek();
                int right_max_index = i;

                int left_max = s.isEmpty() ? 0 : height[s.peek()];
                int right_max = height[i];

                int height_water = Math.min(left_max, right_max) - height[top_index]; 

                // if left_max is 0 (no left max element exist), then height_water will be negative.

                if (height_water > 0) {
                    ans = ans + (right_max_index - left_max_index - 1) * height_water;
                }
            }

            // by here stack is in decreasing order we can safely push curr_element_index (i)
            s.push(i);
        }

        // we can ignore even if stack has some more elements by here, as for those elements in stack didn't have any right_max_element.
        // so, there is no contribution from these elements (water is not trapped)

        return ans;

    }
}