package DirectedGraph;
import java.util.*;

public class CycleDetectionInDirectedGraphUsingDFS {
    public boolean isCyclic(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj.get(u).add(v); // Directed edge
        }

        boolean[] visited = new boolean[V];
        boolean[] visPath = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(adj, visited, visPath, i)) return true; // cycle found
            }
        }

        return false; // no cycle
    }

    private boolean dfs(List<List<Integer>> adj, boolean[] visited, boolean[] visPath, int start) {
        visited[start] = true;
        visPath[start] = true;

        for (int node : adj.get(start)) {
            if (!visited[node]) {
                if (dfs(adj, visited, visPath, node)) return true;
            } else if (visPath[node]) {
                return true; // Back edge found → cycle
            }
        }

        visPath[start] = false; // Backtrack
        return false;
    }
}
