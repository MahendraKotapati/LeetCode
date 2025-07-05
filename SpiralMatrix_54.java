import java.util.*;

class Solution {

    /*
      Approach: TC: O(n*m)
      1. write 4 while loop to conver each side of spriral
      2. iteration is incremented for every cycle (after 4 sides covering)
      3. for iteration=1, our matrix bounds are row[1:n-1) col[1:m-1)
         for iteration=2, our matrix bounds are row[2:n-2) col[2:m-2)

    */

    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int i = 0, j=0, iteration=0;
        List<Integer> spiralOrderList = new ArrayList<>();

        while(spiralOrderList.size() < n*m) {  

            while(j<m-iteration) { // to cover left to right  
                spiralOrderList.add(matrix[i][j]);
                j++;
            }

            j--; i++;
            if (!(i<n-iteration)) break; // if this side is not possible further sides also not possible
            
            while(i < n-iteration) { // to cover top to bottom  
                spiralOrderList.add(matrix[i][j]);
                i++;
            }

            i--;j--;
            if (!(j>=iteration))  break;  // if this side is not possible further sides also not possible

            while(j>=iteration) { // to cover right to left
                spiralOrderList.add(matrix[i][j]);
                j--;
            }

            j++;i--;
            if (!(i>iteration)) break; // if this side is not possible further sides also not possible

            while(i>iteration) { // to cover bottom to top
                spiralOrderList.add(matrix[i][j]);
                i--;
            }

            i++;j++;
            iteration++; // completed one cycle, so increment iteration
        }

        return spiralOrderList;

    }
}

/*

   a00  a01 a02
   a10  a11 a12
   a20  a21 a22

   a00  a01 a02 a03
   a10  a11 a12 a13
   a20  a21 a22 a23

   a00  a01 a02 a03 a04
   a10  a11 a12 a13 a14
   a20  a21 a22 a23 a24
   a30  a31 a32 a33 a34
   a40  a41 a42 a43 a44
*/