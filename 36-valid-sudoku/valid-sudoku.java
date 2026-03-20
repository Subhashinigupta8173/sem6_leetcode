import java.util.*;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        for (int i = 0; i < 9; i++) {
            HashSet<Character> row = new HashSet<>();
            HashSet<Character> col = new HashSet<>();
            HashSet<Character> box = new HashSet<>();
            
            for (int j = 0; j < 9; j++) {
                
             
                if (board[i][j] != '.') {
                    if (row.contains(board[i][j])) return false;
                    row.add(board[i][j]);
                }
                
                
                if (board[j][i] != '.') {
                    if (col.contains(board[j][i])) return false;
                    col.add(board[j][i]);
                }
                
            
                int rowIndex = 3 * (i / 3) + j / 3;
                int colIndex = 3 * (i % 3) + j % 3;
                
                if (board[rowIndex][colIndex] != '.') {
                    if (box.contains(board[rowIndex][colIndex])) return false;
                    box.add(board[rowIndex][colIndex]);
                }
            }
        }
        
        return true;
    }
}