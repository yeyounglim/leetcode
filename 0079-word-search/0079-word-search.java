class Solution {
    boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0) && backtrack(i, j, board, word, 0))
                    return true;
            }
        }
        return false;
    }

    private boolean backtrack(int x, int y, char[][] board, String word, int count) {
        if (word.length() == count) return true;

        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length
                || word.charAt(count) != board[x][y] || visited[x][y])
            return false;

        visited[x][y] = true;

        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        for (int k = 0; k < 4; k++) {
            int xx = x + dx[k];
            int yy = y + dy[k];

            if (backtrack(xx, yy, board, word, count + 1))
                return true;
        }

        visited[x][y] = false;

        return false;
    }
}