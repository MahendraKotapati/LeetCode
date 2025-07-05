import java.util.*;

class Solution {

    // TC: O(n*m);
    public boolean isValidSudoku(char[][] board) {
        int n = board.length, m = board[0].length;
        boolean[] visited = new boolean[10];

        // row wise validation
        for(int i=0;i<n;i++) {
            Arrays.fill(visited, false);
            for(int j=0;j<m;j++) {
                if (board[i][j] == '.')
                    continue;
                if (visited[board[i][j]-'0']) {
                    return false;
                }
                visited[board[i][j]-'0'] = true;
            }
        }

        // column wise validation
        for(int j=0; j<m; j++) {
            Arrays.fill(visited, false);
            for(int i=0;i<n;i++) {
                if (board[i][j] == '.')
                    continue;

                if (visited[board[i][j]-'0']) {
                    return false;
                }
                visited[board[i][j]-'0'] = true;
            }
        }

        // 3x3 sub box wise validation
        for(int i=0; i<n; i+=3) {
            for(int j=0; j<m; j+=3) {
                Arrays.fill(visited, false);

                for(int di=0; di<3; di++) {
                    for(int dj=0; dj<3; dj++) {
                        if (board[i+di][j+dj] == '.')
                            continue;

                        if (visited[board[i+di][j+dj]-'0']) {
                            return false;
                        }
                        visited[board[i+di][j+dj]-'0'] = true;
                    }
                }
            }
        }

        return true;

    }
}