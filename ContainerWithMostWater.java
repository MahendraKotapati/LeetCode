import java.util.Scanner;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = {1,8,6,2,5,4,8,3,7};
        System.out.println("Ans: " + maxArea(nums));
        sc.close();
    }


    /*
        → maintain left and right pointers. (left = 0, right = n-1)
        → and calculate water in between left and right pointers (water is always limited by smaller height pillar)
        → if height[left] < height[right] move left++; else right—;
        why are we always moving a pointer which has less height ?
        assume if we move a pointer having more height even then it won’t increase water area because we are always limited by small height pillar. 
     */

    public static int maxArea(int[] height) {
        
        int left = 0, right = height.length - 1, max_water = 0;

        while(left < right ) {
            int container_height = Math.min(height[left], height[right]);
            max_water = Math.max(max_water, container_height * (right - left));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }   


        return max_water;
    }
}
