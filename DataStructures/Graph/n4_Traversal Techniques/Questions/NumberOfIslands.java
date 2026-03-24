import java.util.*;
// Using BFS :
//  For N x M grid:
//      Time Complexity: O(N * M) — each cell visited once.
//      Space Complexity: O(N * M) for visited and worst-case BFS queue.

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int numRows = grid.length;
        int numCols = grid[0].length;

        boolean[][] visited = new boolean[numRows][numCols];
        int islandCount = 0;

        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                if (!visited[row][col] && grid[row][col] == '1') {
                    islandCount++;
                    bfs(row, col, visited, grid);
                }
            }
        }
        return islandCount;
    }

    private void bfs(int startRow, int startCol, boolean[][] visited, char[][] grid) {
        int numRows = grid.length;
        int numCols = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { startRow, startCol });
        visited[startRow][startCol] = true;

        int[][] directions = {
                { -1, 0 }, // up
                { 1, 0 },  // down
                { 0, -1 }, // left
                { 0, 1 }   // right
        };

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];

            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (newRow >= 0 && newRow < numRows &&
                        newCol >= 0 && newCol < numCols &&
                        grid[newRow][newCol] == '1' &&
                        !visited[newRow][newCol]) {

                    visited[newRow][newCol] = true;
                    queue.add(new int[] { newRow, newCol });
                }
            }
        }
    }
}
