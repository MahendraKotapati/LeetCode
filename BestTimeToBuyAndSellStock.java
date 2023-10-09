import java.util.Scanner;

public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = {7,1,5,3,6,4};
        System.out.println("Ans: " + maxProfit(nums));
        sc.close();
    };


    public static int maxProfit(int[] prices) {

        int min = Integer.MAX_VALUE;
        int maxProfit = 0;

        // at every index, calculate min till that index
        // now subtract that min with prices[i] if prices[i] > min , 
        // prices = .....min, a, b, prices[i] , 
        // let us say we are at prices[i] we don't need to check prices[i] - a, prices[i] - b  as this is not max profit for sure. { a > min && b > min for sure }

        for(int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);

            if (prices[i] > min) {
                maxProfit = Math.max(maxProfit, prices[i] - min);
            }
        }

        return maxProfit;
    }

}
