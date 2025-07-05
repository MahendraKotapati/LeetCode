class Solution {
    /*
    Approach: TC: O(n*n) SC: O(1)
    1. The problem asks for 90 degrees clockwise rotation.
    2. do column wise swapping (i.e up side down)
    3. then do transpose of a matrix. (i.e matrix[i][j] = matrix[j][j])

    Note: 
    - if problem asks for 90 degree anticlockwise rotation then
    - do row wise swapping (i.e left to right)
    - then do transpose of a matrix. (i.e matrix[i][j] = matrix[j][j])
    */
    public void rotate(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length, i, j, start, end, temp;
        
        // column wise swapping
        for(j=0; j<m;j++) {
            start = 0; end = n-1;
            while(start < end) {
                temp = matrix[start][j]; 
                matrix[start][j] = matrix[end][j];
                matrix[end][j] = temp;
                start++; end--;
            }
        }

        // transpose of matrix
        for(i=0;i<n;i++) {
            for(j=0;j<m;j++) {
                if (i<j) {
                    temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }

    }
}


/*

   a00 a01 a02        a20 a10 a00
   a10 a11 a12   -->  a21 a11 a01  
   a20 a21 a22        a22 a12 a02

   a00 a01 a02 a03    a30 a20 a10 a00   
   a10 a11 a12 a13    a31 a21 a11 a01
   a20 a21 a22 a23    a32 a22 a12 a02 
   a30 a31 a32 a33    a33 a23 a13 a03

*/
