// https://leetcode.com/problems/powx-n/description/

// TC: log(n), n is power or exponenet;

import java.util.Scanner;

public class PowerLogn {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = -2147483648;
        System.out.println("Ans: " + myPow(2, n));
        sc.close();
    }


    // Binary Exponentiation approach.
    // if n is even, then (x)^n = (x^2)^(n/2) = (x*x)^(n/2)  

    public static double myPow(double x, long n) {

        double res = 1;
        long curr_n = (long)Math.abs(n);

        // to handle negative powers;
        if (n<0) {
            x = 1/x;
        }

        while (curr_n > 0) {
            if (curr_n % 2 == 1) { // if curr_n is odd
                res = res * x;
            }
            x = x * x;
            curr_n = curr_n / 2;
        } 
        return res;
    }
}
