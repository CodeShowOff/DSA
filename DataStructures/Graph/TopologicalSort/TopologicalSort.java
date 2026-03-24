import java.util.*;

public class TopologicalSort {
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        // Convert to adjList:
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            adjList.get(edge[0]).add(edge[1]);
        }

        // Start sorting:
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < V; i++){
            if(!visited[i]){
                dfs(adjList, visited, stack, i);
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        while (!stack.isEmpty()) result.add(stack.pop());

        return result;
    }

    private static void dfs(List<List<Integer>> adjList, boolean[] visited, Stack<Integer> stack, int node){
        visited[node] = true;

        for(int child: adjList.get(node)){
            if(!visited[child]) dfs(adjList, visited, stack, child);
        }

        stack.push(node);
    }
}

