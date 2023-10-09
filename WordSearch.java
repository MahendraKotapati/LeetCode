import java.util.Scanner;


/*
 * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
 * 
 */

/*
 * Time Complexity: O(N * M * 4^K)
 * K - length of word 
 * TC explanation: https://cs.stackexchange.com/questions/96626/whats-the-big-o-runtime-of-a-dfs-word-search-through-a-matrix
 */

public class WordSearch {

    static boolean[][] visited;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] nums = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        System.out.println("Ans: " + exist(nums, "ACCED"));
        sc.close();
    }

    public static boolean exist(char[][] board, String word) {

        visited = new boolean[100][100];

        for(int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (wordSearch(board, i, j, board.length, board[i].length, word, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    // using DFS to search for the word in board.
    public static boolean wordSearch(char[][] board, int i, int j, int n, int m, String word, int wordIndex) {

        if (wordIndex >= word.length()) {
            return true;
        }

        if (isInvalid(board, i, j, n, m, word.charAt(wordIndex))) {
            return false;
        }

        visited[i][j] = true; // making visited true to avoid visiting same node, hence avoiding infinte loop.

        if (wordSearch(board, i, j + 1, n, m, word, wordIndex + 1) || 
            wordSearch(board, i, j - 1, n, m, word, wordIndex + 1) || 
            wordSearch(board, i + 1, j, n, m, word, wordIndex + 1) || 
            wordSearch(board, i - 1, j, n, m, word, wordIndex + 1)) {
             
            visited[i][j] = false;
            return true;
        }

        visited[i][j] = false;
        return false;
    }

    public static boolean isInvalid(char[][] board, int i, int j, int n, int m, char currentChar) {
        return i < 0 || i >=n || j < 0 || j >= m || board[i][j] != currentChar || visited[i][j]; 
    }
}
