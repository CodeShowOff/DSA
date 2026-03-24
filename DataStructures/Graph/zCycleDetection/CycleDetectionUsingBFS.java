import java.util.*;

public class CycleDetectionUsingBFS {
//    TC: O(N + 2E); SC: O(N)
    public boolean detectCycle(List<List<Integer>> adjList){
        int size = adjList.size();
        boolean[] visited = new boolean[size];
        for(int i = 0; i < size; i++){
            if(!visited[i] && bfs(adjList, visited, i)){
                return true;
            }
        }
        return false;
    }

    private boolean bfs(List<List<Integer>> adjList, boolean[] visited, int start){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start, -1});
        visited[start] = true;

        while(!queue.isEmpty()){
            int[] pair = queue.poll();
            int curr = pair[0];
            int prev = pair[1];

            for(Integer neighbor : adjList.get(curr)){
                if(!visited[neighbor]){
                    visited[neighbor] = true;
                    queue.add(new int[]{neighbor, curr});
                }
                else if(neighbor != prev){
                    return true; // Cycle detected
                }
            }
        }
        return false;
    }
}