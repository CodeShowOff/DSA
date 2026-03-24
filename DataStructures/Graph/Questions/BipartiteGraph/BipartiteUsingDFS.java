package BipartiteGraph;
import java.util.Arrays;

public class BipartiteUsingDFS {
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        Arrays.fill(color, -1); // Mark all nodes as unvisited

        for (int i = 0; i < graph.length; i++) {
            if (color[i] == -1) {
                if (!dfs(graph, color, i, 0)) return false;
            }
        }

        return true;
    }

    private boolean dfs(int[][] graph, int[] color, int node, int currColor) {
        color[node] = currColor;

        for (int neighbor : graph[node]) {
            if (color[neighbor] == -1) {
                if (!dfs(graph, color, neighbor, 1 - currColor)) return false;
            } else if (color[neighbor] == currColor) {
                return false;
            }
        }

        return true;
    }
}
