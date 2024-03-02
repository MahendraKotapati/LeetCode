import java.util.Scanner;

public class IrfanPalindromicPrime {

    static int[] palindromicPrimes;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        constructPalidromicPrimes();

        System.out.println("Ans: " + palPrime(8043, 84056));   
        sc.close();
    }

    public static void constructPalidromicPrimes() {
        
        int n = 100000;
        palindromicPrimes = new int[n+1];

        boolean prime[] = new boolean[n+1];

        for(int i=0;i<=n;i++)
            prime[i] = true;
         
        for(int p = 2; p*p <=n; p++)
        {
            if(prime[p] == true)
            {
                for(int i = p*p; i <= n; i += p)
                    prime[i] = false;
            }
        }

        prime[0] = prime[1] = false;

        palindromicPrimes[0] = 0;
        
        for(int i = 1; i <= n; i++) {
            String s = String.valueOf(i);

            if (prime[i] && s.compareTo(new StringBuilder(s).reverse().toString()) == 0) {
                palindromicPrimes[i] = palindromicPrimes[i-1] + 1;
            } else {
                palindromicPrimes[i] = palindromicPrimes[i-1];
            }
        }
    }

    public static int palPrime(int L, int R) {
        return palindromicPrimes[R] - palindromicPrimes[L-1];
    }


}
