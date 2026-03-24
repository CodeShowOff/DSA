import java.util.*;

public class CountConnectedComponentsUsingBFS {
    public int findNumberOfComponent(int V, List<List<Integer>> adjList) {
        boolean[] visited = new boolean[V];
        int componentCount = 0;

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                componentCount++;
                bfs(i, adjList, visited);
            }
        }

        return componentCount;
    }

    private void bfs(int start, List<List<Integer>> adjList, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : adjList.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }
}
