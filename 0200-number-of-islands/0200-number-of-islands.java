class Solution {
    private static boolean[][] visited;

    public int numIslands(char[][] grid) {
        visited = new boolean[grid.length][grid[0].length];
        int islandCount = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
               
                if (grid[i][j] == '1' && !visited[i][j]) {
                    islandCount++;
                    dfs(i, j, grid);
                }
            }
        }
        return islandCount;
    }

    private void dfs(int i, int j, char[][] grid) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || visited[i][j] || grid[i][j] == '0')
            return;

        visited[i][j] = true;

        int[] dr = {0, 0, -1, 1};
        int[] dc = {1, -1, 0, 0};

        for (int k = 0; k < 4; k++) {
            int row = i + dr[k];
            int column = j + dc[k];
            dfs(row, column, grid);
        }
    }
}