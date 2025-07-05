public class SurroundedRegions_130 {

    /*
        1. Traverse all borders of matrix, then in each border 'O' cell connected regions are marked with 'E' (any identifier)
        2. Now, traverse entire matrix and for each cell  
            if cell is 'O' then it is surrended (not reachable from boundaries) then make it 'X'
            if cell is 'E' then it is not surrended so write back it to 'O'
    */
    public void solve(char[][] board) {
        boolean[][] visited = new boolean[200][200];
        int n = board.length, m = board[0].length;

        // traverse all borders
        for(int j=0;j<m;j++) { 
            dfs(0, j, board, visited); // top row
            dfs(n-1, j, board, visited); // bottom row
        }

        for(int i=0;i<n;i++) {
            dfs(i, 0, board, visited); // left row
            dfs(i, m-1, board, visited); // right row
        }

        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++)
            {
                if (board[i][j] == 'O') // if cell is 'O' then it is surrended then make it 'X'
                    board[i][j] = 'X';
                else if (board[i][j] == 'E') // if cell if 'E' then it is not surrended so write back it to 'O'
                    board[i][j] = 'O';
            }
        }
    }

    public void dfs(int r, int c, char[][] board, boolean[][] visited) { 
        if (r < 0 || r >= board.length || c < 0 || c>= board[r].length || board[r][c] == 'X' || visited[r][c]) {
            return ;
        }

        visited[r][c] = true;

        dfs(r, c+1, board, visited);
        dfs(r, c-1, board, visited);
        dfs(r+1, c, board, visited);
        dfs(r-1, c, board, visited);

        board[r][c] = 'E'; // cells which are not surrended is marked with an identifier 
    }
}