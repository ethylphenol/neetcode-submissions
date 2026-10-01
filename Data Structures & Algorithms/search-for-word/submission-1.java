class Solution {
    public boolean dfsWord(char[][] board, int j, int i, String word, Set<List<Integer>> visited) {
        if (word.isEmpty()) return true;
        if (i >= board.length || j >= board[0].length
                || i < 0 || j < 0) return false;
        if (word.charAt(0) == board[i][j]) {
            List<Integer> l = new ArrayList<>();
            l.add(j);
            l.add(i);
            if (!visited.add(l)) {
                return false;
            }
            word = word.substring(1);
            return dfsWord(board, j + 1, i, word, new HashSet<>(visited))
                    || dfsWord(board, j - 1, i, word, new HashSet<>(visited))
                    || dfsWord(board, j, i + 1, word, new HashSet<>(visited))
                    || dfsWord(board, j, i - 1, word, new HashSet<>(visited));
        } else {
            return false;
        }
    }

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfsWord(board, j, i, word, new HashSet<>())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
