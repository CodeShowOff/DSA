package EventualSafeStates;

import java.util.*;

public class Solution1 {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        boolean[] visited = new boolean[graph.length];
        boolean[] pathVis = new boolean[graph.length];
        boolean[] safeNodes = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) dfs(graph, visited, pathVis, safeNodes, i);
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < safeNodes.length; i++) {
            if (safeNodes[i]) result.add(i);
        }

        return result;
    }

    private boolean dfs(int[][] graph, boolean[] visited, boolean[] pathVis, boolean[] safeNodes, int start) {
        visited[start] = true;
        pathVis[start] = true;

        for (int node : graph[start]) {
            if (!visited[node]) {
                if (!dfs(graph, visited, pathVis, safeNodes, node)) {
//                    safeNodes[node] = false;  <- not required as by default false.
                    return false;
                }
            } else if (pathVis[node]) {
                return false; // cycle detected
            }

            // If the neighbor is already visited and not part of the current path,
            // it means it's a safe node. We must still check all other neighbors,
            // because the current node is safe only if all outgoing paths are safe.
        }

        pathVis[start] = false;

        // Since the for loop completed without returning false, all neighbors are safe.
        // Therefore, mark this node as safe as well.
        safeNodes[start] = true;
        return true;
    }
}