class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        if (grid[0][0] != 0 || grid[n - 1][n - 1] != 0) return -1;

        int[][] directions = {
                {-1, -1}, {-1, 0}, {-1, 1},
                {0, -1},           {0, 1},
                {1, -1},  {1, 0},  {1, 1}
        };

        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{0, 0, 1});
        grid[0][0] = 1;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int column = current[1];
            int pathLength = current[2];

            if (row == n - 1 && column == n - 1) return pathLength;

            for (int[] direction : directions) {
                int nextRow = row + direction[0];
                int nextColumn = column + direction[1];

                if (nextRow >= 0 && nextColumn >= 0 && nextRow < n && nextColumn < n
                        && grid[nextRow][nextColumn] == 0) {
                    grid[nextRow][nextColumn] = 1;
                    queue.add(new int[]{nextRow, nextColumn, pathLength + 1});
                }
            }
        }
        return -1;
    }
}