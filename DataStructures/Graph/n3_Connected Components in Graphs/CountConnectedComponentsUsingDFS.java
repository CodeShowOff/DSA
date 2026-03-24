import java.util.*;

public class CountConnectedComponentsUsingDFS {
    public int findNumberOfComponent(int V, List<List<Integer>> adjList) {
        boolean[] visited = new boolean[V];
        int count = 0;

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                count++;
                dfs(i, adjList, visited);
            }
        }

        return count;
    }

    private void dfs(int node, List<List<Integer>> adjList, boolean[] visited) {
        visited[node] = true;

        for (int neighbor : adjList.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adjList, visited);
            }
        }
    }
}
