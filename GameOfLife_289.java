public class GameOfLife_289 {

    /*
        Approach: O(n*m)
        1. visit each cell and calculate no.of neighbours based on that update current cell.
        but don't update directly 
        (use mapping  0 --> 1 == 2, 
                      1 --> 0 == -2)
        Note: the board needs to be updated simultaneously: You cannot update some cells first and then use their updated values to update other cells.
    */


    // 0 --> 1 == 2, original value is 0 but it changed to 1 during the process. this represented using 2 
    // 1 --> 0 == -2, original value is 1 but it changed to 0 during the process. this represented using -2 
    public int calculateNoOfNeighbours(int i, int j, int n, int m, int[][] board) {
        int count = 0;
        for(int di=-1; di<2;di++) {
            for(int dj=-1;dj<2;dj++) {
                if ((di==0 && dj==0) || i+di < 0 || i+di >=n || j+dj<0 || j+dj >= m) 
                    continue;
                if (board[i+di][j+dj] == 1) {
                    count++;
                } else if (board[i+di][j+dj] == -2) {
                    count++;
                }
            }
        }

        return count;
    }

    public void gameOfLife(int[][] board) {
       int n = board.length, m = board[0].length; 

       for(int i=0;i<n;i++) {
        for(int j=0;j<m;j++) {
            int count = calculateNoOfNeighbours(i, j, n, m, board);
            if (board[i][j] == 0 && count == 3)
                board[i][j] = 2;
            else if(board[i][j] == 1 && count < 2) 
                board[i][j] = -2; // not directly changing it to 0, because it also acts as neighbour to some of the cells
            else if (board[i][j] == 1 && count > 3) {
                board[i][j] = -2; // not directly changing it to 0, because it also acts as neighbour to some of the cells
            }
            else if (board[i][j] == 1 && (count == 2 || count == 3)) {
                continue;
            }
        }
       }

        // reverting back the mapping
       for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if (board[i][j] == 2) 
                    board[i][j] = 1;
                else if (board[i][j] == -2)
                    board[i][j] = 0;
            }
       }
    }
}