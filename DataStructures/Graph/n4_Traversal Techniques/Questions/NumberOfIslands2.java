// Using DFS: TC: O(N * M); SC: O(1)
public class NumberOfIslands2 {
    public int numIslands(char[][] grid) {
        int numRows = grid.length;
        int numCols = grid[0].length;
        int islandCount = 0;

        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                if (grid[row][col] == '1') {
                    islandCount++;
                    dfs(grid, row, col);
                }
            }
        }
        return islandCount;
    }

    private void dfs(char[][] grid, int row, int col) {
        int numRows = grid.length;
        int numCols = grid[0].length;

        // Base case: out of bounds or water or already visited
        if (row >= 0 && row < numRows && col >= 0 && col < numCols && grid[row][col] == '1') {
            // Mark the current cell as visited by sinking the island
            grid[row][col] = '0';

            // Explore all four directions
            dfs(grid, row - 1, col); // up
            dfs(grid, row + 1, col); // down
            dfs(grid, row, col - 1); // left
            dfs(grid, row, col + 1); // right
        }
    }
}
