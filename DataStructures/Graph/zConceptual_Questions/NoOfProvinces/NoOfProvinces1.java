package zConceptual_Questions.NoOfProvinces;
import java.util.*;

public class NoOfProvinces1 {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;

        // First converting matrix into adjacency list then solving:
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adjList.add(new ArrayList<>());

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1 && i < j) {
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }

            }
        }

        boolean[] visited = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                dfs(i, adjList, visited);
            }
        }

        return count;
    }

    private void dfs(int node, ArrayList<ArrayList<Integer>> adjList, boolean[] visited) {
        visited[node] = true;

        for (int neighbor : adjList.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adjList, visited);
            }
        }
    }
}