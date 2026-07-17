class Solution {
 public boolean isValidSudoku(char[][] board) {
        Set<Character>[] rowSets = new Set[9];
        Set<Character>[] colSets = new Set[9];
        Set<Character>[] boxSets = new Set[9];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j]=='.') continue;
                if (rowSets[i]==null) {
                    rowSets[i] = new HashSet<>();
                }
                if (colSets[j]==null) {
                    colSets[j] = new HashSet<>();
                }
                // sub-boxes
                int index = 3*(i/3) + j/3;
                if(boxSets[index]==null) {
                    boxSets[index] = new HashSet<>();
                }
                if(!rowSets[i].add(board[i][j]))
                    return false;
                if(!colSets[j].add(board[i][j]))
                    return false;
                if(!boxSets[index].add(board[i][j])) 
                    return false;
            }
        }
        return true;
    }
}
