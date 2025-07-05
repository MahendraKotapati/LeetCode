import java.util.*;

class Solution {

    /*
    TC: O(log(n)) SC: O(log(n))
    
    ideally time complexity should be O(no.of nodes in chain * log(n))
    but no.of nodes in chain will be constant. so it can be ignored.

    Note:
    - log(n) = to traverse all digits of numbers.
    - Think about what would happen if you had a number with 1 million digits in it. The first step of the algorithm would process those million digits, and then the next value would be, at most (pretend all the digits are 9), be 81∗1,000,000=81,000,000. 
    In just one step, we've gone from a million digits, down to just 8. The largest possible 8 digit number we could get is 99,9999,999, which then goes down to 81∗8=648. And then from here, the cost will be the same as if we'd started with a 3 digit number. 
    Starting with 2 million digits (a massively larger number than one with a 1 million digits) would only take roughly twice as long, as again, the dominant part is summing the squares of the 2 million digits, and the rest is tiny in comparison.
    */

    public boolean isHappy(int n) {
        HashSet<Integer> visited = new HashSet<>();
        int currentN = n, sumOfSquares = 0;

        while(currentN != 1) {
            sumOfSquares = 0;
            while(currentN > 0) {
                sumOfSquares = sumOfSquares + (currentN % 10) * (currentN % 10);
                currentN = currentN / 10;
            }
            currentN = sumOfSquares;
            if (visited.contains(sumOfSquares))
                return false;
            visited.add(sumOfSquares);
        }
        return true;
    }
}