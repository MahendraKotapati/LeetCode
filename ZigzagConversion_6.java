import java.util.*;

class Solution {

    /*
        Approach:
        1. simulate zigZag pattern, i..e go straight down, cross up, straight down, cross up, ......
           and fill zig zag matrix
        2. finally print zigzag matrix by skipping '-' placeholder.
    */

    public String convert(String s, int numRows) {

        if (numRows == 1)
            return s;
        int n = s.length(), i=0, j=0;
        boolean goDown = true;
        char[][] zigZag = new char[n][n];
        StringBuilder ans = new StringBuilder("");

        for(int k=0;k<n;k++)
            Arrays.fill(zigZag[k], '-'); // filling entire matrix with placeholder '-'

        for(char k: s.toCharArray()) {
            zigZag[i][j] = k;
            if (goDown) { 
                i++;
                if (i==numRows) {
                    goDown = false;
                    i = i-2; j++;
                }
            } else { // going up here
                i--; j++;
                if (i<0) {
                    goDown = true;
                    i=1;j--;
                }
            }
        }

        // create answer string from zigzag_matrix
        for(int p=0;p<n;p++) {
            for(int q=0;q<n;q++) {
                if (zigZag[p][q] != '-') 
                    ans.append(zigZag[p][q]);
            }
        }

        return ans.toString();
    }
}