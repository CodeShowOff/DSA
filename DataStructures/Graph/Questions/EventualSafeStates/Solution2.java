package EventualSafeStates;

import java.util.*;

public class Solution2 {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        boolean[] visited = new boolean[graph.length];
        boolean[] safeNodes = new boolean[graph.length];

        for(int i = 0; i < graph.length; i++){
            if(!visited[i]) dfs(graph, visited, safeNodes, i);
        }

        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < safeNodes.length; i++){
            if(safeNodes[i]) result.add(i);
        }

        return result;
    }

    private boolean dfs(int[][] graph, boolean[] visited, boolean[] safeNodes, int start){
        visited[start] = true;

        for(int node: graph[start]){

            if(!visited[node]){
                if(!dfs(graph, visited, safeNodes, node)){
                    return false;
                }
            }
            else if(!safeNodes[node]){
                return false;   // We don't return true immediately if the neighbor is safe, because we need to check all neighbors to ensure the current node is also safe.

//          If the node has already been visited and is not marked as a safe node, then it is certainly unsafe. This is because
//          it was previously encountered, and if it were safe or unsafe, it should have already been marked accordingly. If it is
//          not yet marked, it implies that we are currently revisiting it in a circular path, which still indicates an unsafe condition.
//          Therefore, return false.
            }

        }

        safeNodes[start] = true;
        return true;
    }
}