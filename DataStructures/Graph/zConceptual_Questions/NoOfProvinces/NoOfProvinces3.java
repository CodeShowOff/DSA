package zConceptual_Questions.NoOfProvinces;

import java.util.LinkedList;
import java.util.Queue;

public class NoOfProvinces3 {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int provinces = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                provinces++;
                bfs(isConnected, visited, i);
            }
        }

        return provinces;
    }

    private void bfs(int[][] isConnected, boolean[] visited, int i) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i);
        visited[i] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int j = 0; j < isConnected.length; j++) {
                if (isConnected[node][j] == 1 && !visited[j]) {
                    visited[j] = true;
                    queue.offer(j);
                }
            }
        }
    }
}
