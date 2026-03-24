import java.util.*;

// Correct but not optimise; TC: O((m * n) * (m * n))
public class DistanceOfNearest0 {
    public int[][] updateMatrix(int[][] mat) {
        int[][] result = new int[mat.length][mat[0].length];

        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                if(mat[i][j] == 1)
                    result[i][j] = bfs(mat, i, j);
            }
        }

        return result;
    }

    private int bfs(int[][] mat, int rowi, int coli){
        if(mat[rowi][coli] == 0) return 0;

        int numRow = mat.length;
        int numCol = mat[0].length;

        boolean[][] visited = new boolean[numRow][numCol];
        visited[rowi][coli] = true;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{rowi, coli});

        int nearest = 0;

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while(!queue.isEmpty()){
            int size = queue.size();
            nearest++;
            for(int i = 0; i < size; i++){
                int[] pair = queue.poll();
                int row = pair[0];
                int col = pair[1];

                for(int[] dir: directions){
                    int nrow = row + dir[0];
                    int ncol = col + dir[1];

                    if(nrow >= 0 && nrow < numRow && ncol >= 0 && ncol < numCol &&
                            !visited[nrow][ncol]){
                        if(mat[nrow][ncol] == 0) return nearest;
                        else queue.add(new int[]{nrow, ncol});
                    }
                }
            }
        }

        return nearest;
    }
}