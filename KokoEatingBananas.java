// https://leetcode.com/problems/koko-eating-bananas/
// TC: O(n * Log(max(arr)))

// intuition: https://leetcode.com/problems/koko-eating-bananas/solutions/3270468/complete-intuition-to-use-binary-search-explained-easy-to-understand/

import java.util.Arrays;
import java.util.Scanner;

public class KokoEatingBananas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = {3,6,7,11};
        int h = 8;
        System.out.println("Ans: " + minEatingSpeed(nums, h));
        sc.close();
    }

    public static boolean canFinish(int[] piles, int k, int h) {

        int i = 0;

        while(h > 0 && i < piles.length) {
            h = h - (int)(Math.ceil((double) piles[i] / k)); // at k rate per hour, it will take ceil(piles[i] / k) hours to complete piles[i] bananas
            i++;
        }

        if (i == piles.length && h>=0) {
            return true;
        }
        return false;
    }

    /*  Given
     *  piles.length <= h <= 10 ^ 9
     *  So, we can always complete all banana piles.
     *  max possible value for K (eat rate per hour) = max(piles[])
     *  to get K value, we do binary search on possible answer space, 1 ..... max(piles[])
     */
    public static int minEatingSpeed(int[] piles, int h) {
        int low = 1, high, mid, ans = -1;

        high = Arrays.stream(piles).max().orElseThrow(); // max of array.

        while(low <= high) {

            mid = (low + high) / 2;
            
            if (canFinish(piles, mid, h)) {
                high = mid - 1;
                ans = mid;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }
}
