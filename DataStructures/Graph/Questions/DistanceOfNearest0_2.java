import java.util.*;
//  TC: O(m * n)
public class DistanceOfNearest0_2 {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] result = new int[m][n];

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];

        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                if(mat[i][j] == 0){
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while(!queue.isEmpty()){
            int[] pair = queue.poll();
            int row = pair[0];
            int col = pair[1];

            for(int[] dir: directions){
                int nrow = row + dir[0];
                int ncol = col + dir[1];

                if(nrow >= 0 && nrow < m && ncol >= 0 && ncol < n &&
                        !visited[nrow][ncol])
                {
                    result[nrow][ncol] = result[row][col] + 1;
                    visited[nrow][ncol] = true;
                    queue.add(new int[]{nrow, ncol});
                }
            }
        }

        return result;
    }
}