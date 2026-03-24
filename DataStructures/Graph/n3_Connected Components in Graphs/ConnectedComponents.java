import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ConnectedComponents {
    public ArrayList<ArrayList<Integer>> getComponents(int n, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) adjList.add(new ArrayList<>());

        // Build the adjacency list
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]); // remove for directed adjList
        }


        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[n];

        for(int i = 0; i < n; i++){
            if(!visited[i]){
                result.add(bfs(adjList, visited, i));
            }
        }

        return result;
    }

    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adjList, boolean[] visited, int start){
        ArrayList<Integer> result = new ArrayList<>();

        Queue<Integer> queue = new LinkedList<>();// 0,
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()){
            Integer node = queue.poll();
            result.add(node);

            for(Integer it: adjList.get(node)){
                if (!visited[it]){
                    visited[it] = true;
                    queue.add(it);
                }
            }
        }
        return result;
    }
}