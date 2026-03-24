package EventualSafeStates;

import java.util.*;

public class Solution4 {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] state = new int[n]; // 0 = unvisited, 1 = visiting, 2 = safe

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (dfs(graph, i, state)) {
                result.add(i);
            }
        }

        return result;
    }

    private boolean dfs(int[][] graph, int node, int[] state) {
        if (state[node] != 0) {
            return state[node] == 2;
        }

        state[node] = 1; // mark as visiting

        for (int neighbor : graph[node]) {
            if (!dfs(graph, neighbor, state)) {
                return false; // found a cycle
            }
        }

        state[node] = 2; // mark as safe
        return true;
    }
}
