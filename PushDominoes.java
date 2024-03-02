import java.util.Scanner;

public class PushDominoes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = ".L.R...LR..L..";
        // String input = "RR.L";
        System.out.println("Ans: " + pushDominoes(input));
        sc.close();
    }

    public static String pushDominoes(String dominoes) {

        int n = dominoes.length();

        char[] right = new char[n + 1];
        int[] rightTime = new int[n + 1];
        int currentLeftTime = 0;
        char currentLeftForce = '.';
        StringBuilder res = new StringBuilder("");

        right[n] = '.';
        rightTime[n] = 0;

        for(int i = n - 1; i >=0 ; i--) {
            if (dominoes.charAt(i) != '.') {
                right[i] = dominoes.charAt(i);
                rightTime[i] = 0;
            }
            else {
                right[i] = ((right[i + 1] == 'L') ? 'L' : '.');
                rightTime[i] = rightTime[i + 1] + 1;
            }
        }


        for(int i = 0; i < n; i++) {
            if (dominoes.charAt(i) != '.') {
                res.append(dominoes.charAt(i));
                currentLeftTime = 0;
                currentLeftForce = dominoes.charAt(i);
            }
            else {
                currentLeftTime++;
                currentLeftForce =  ((currentLeftForce == 'R')  ? 'R' : '.' ); 

                char currentTotalForce;

                if (currentLeftForce == '.') {
                    currentTotalForce = right[i];
                } else if (right[i] == '.')  {
                    currentTotalForce = currentLeftForce;
                } else {
                    if (currentLeftTime == rightTime[i]) {
                        currentTotalForce = '.';
                    }
                    else {
                        currentTotalForce = currentLeftTime < rightTime[i] ? currentLeftForce : right[i];  
                    }
                }

                res.append(currentTotalForce);
               
            }
        }

        return new String(res);
    }
}
