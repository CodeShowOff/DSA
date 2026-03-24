// Kahn's Algorithm
//Time Complexity: O(V + E); Space Complexity: O(V + E)
import java.util.*;

public class KahnsAlgorithm_for_TopologicalSort {
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // Convert to adj:
        List<List<Integer>> adj = giveAdjList(V, edges);

        // In-degree calculation
        int[] inDegree = new int[V];
        for(int i = 0; i < V; i++){
            for(Integer node: adj.get(i)){
                inDegree[node]++;
            }
        }

        // Initialize queue with 0 in-degree nodes
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < V; i++){
            if(inDegree[i] == 0) queue.offer(i);
        }

        ArrayList<Integer> result = new ArrayList<>();

        while(!queue.isEmpty()){
            int node = queue.poll();
            result.add(node);

            for(Integer child: adj.get(node)){
                inDegree[child]--;
                if(inDegree[child] == 0) queue.add(child);
            }
        }

        return result;
    }

    private List<List<Integer>> giveAdjList(int V, int[][] edges){
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
        }
        return adj;
    }
}