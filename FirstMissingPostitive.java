import java.util.Scanner;

public class FirstMissingPostitive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = {8, 9, 10, 11, 12}; // new int[10];
        firstMissingPositive(nums);
        sc.close();
    };

    public static int firstMissingPositive(int[] nums) {

        int INT_MAX = (int)Math.round(Math.pow(2, 31));

        for(int i = 0; i < nums.length ; i++) {
            int curr = nums[i];
            if (Math.abs(curr) > INT_MAX) {
                curr = nums[i] % INT_MAX;   
            }

            if (Math.abs(curr) > nums.length || curr <= 0) {
                continue;
            }
            
            nums[curr - 1] = (nums[curr - 1] % INT_MAX) * INT_MAX;
        }

        // store two numbers in same index
        // x*C

        return 0;
    }


}
