package EventualSafeStates;

import java.util.*;

public class Solution3 {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        boolean[] visited = new boolean[n];
        boolean[] pathVis = new boolean[n];
        boolean[] safeNodes = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(graph, visited, pathVis, safeNodes, i);
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (safeNodes[i]) result.add(i);
        }
        return result;
    }

    private boolean dfs(int[][] graph, boolean[] visited, boolean[] pathVis, boolean[] safeNodes, int node) {
        if (visited[node]) return safeNodes[node];

        visited[node] = true;
        pathVis[node] = true;

        for (int neighbor : graph[node]) {
            if (pathVis[neighbor] || !dfs(graph, visited, pathVis, safeNodes, neighbor)) {
                return false;
            }
        }

        pathVis[node] = false;
        safeNodes[node] = true;
        return true;
    }
}
