public class SetMatrixZeroes {

    /*
    Approach 1 (simple): Create row[m], column[n] which indicates whether i th row has zero or not.
    -> iterate over matrix, if matrix[i][j] == 0, then row[i] = 0; column[j] = 0;
    -> iterate again if (row[i] == 0 || column[j] == 0) then set matrix[i][j] = 0;

    Approach 2 (No extra space): 
    Using first row, and first column of matrix as above row[m], column[n] matrices to mark whether it contains zero or not.
    Since, we are using first row, column for marking, the actual data whether if first row has zero or not can be lost;
    So, we save that data in has_first_row_zero, has_first_column_zero and populate at the last.

         * * * * * * *
         * - - - - - - 
         * - - - - - -
         * - - - - - -
         * - - - - - -
         * - - - - - -
         
    */

    // Approach 2 
    public void setZeroes(int[][] matrix) {

        boolean has_first_row_zero = false, has_first_column_zero = false;

        for(int i = 0; i<matrix.length;i++) {
            for(int j = 0; j<matrix[0].length; j++) {
                if (matrix[i][j]==0) {

                    matrix[i][0] = 0;
                    matrix[0][j] = 0;

                    if (i==0) has_first_row_zero = true; // marking whether first row has zero or not
                    if (j==0) has_first_column_zero = true; // marking whether first column has zero or not
                }
            }
        }

        // i, j start with 1
        for(int i = 1; i<matrix.length;i++) {
            for(int j = 1; j<matrix[0].length; j++) {
                if (matrix[i][0]==0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (has_first_column_zero) {
            for(int i = 0;i<matrix.length;i++) {
                matrix[i][0] = 0;
            }
        }

        if (has_first_row_zero) {
            for(int j = 0;j<matrix[0].length;j++) {
                matrix[0][j] = 0;
            }
        }
    }
}