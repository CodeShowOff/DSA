import java.util.*;

public class BFS {
    // TC: O(V + E), SC: O(V)
    // TC: O(N) + O(2*Edges); SC: O(3N)
    public List<Integer> breadthFirstSearch(ArrayList<ArrayList<Integer>> adjList){
        int vertices = adjList.size();

        List<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[vertices + 1];

        Queue<Integer> queue = new LinkedList<>();// 0,
        queue.add(0);
        visited[0] = true;

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
