package BipartiteGraph;
import java.util.*;

public class BipartiteUsingBFS {
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        Arrays.fill(color, -1); // -1 means unvisited

        for (int i = 0; i < graph.length; i++) {
            if (color[i] == -1) {
                if (!bfs(graph, color, i)) return false;
            }
        }

        return true;
    }

    private boolean bfs(int[][] graph, int[] color, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        color[start] = 0; // Start coloring with 0

        while (!queue.isEmpty()) {
            int parent = queue.poll();

            for (int child : graph[parent]) {
                if (color[child] == -1) {
                    color[child] = 1 - color[parent]; // Flip color
                    queue.add(child);
                } else {
                    if (color[child] == color[parent]) return false; // Same color on both ends
                }
            }
        }

        return true;
    }
}
