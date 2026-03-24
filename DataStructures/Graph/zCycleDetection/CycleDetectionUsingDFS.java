import java.util.List;

public class CycleDetectionUsingDFS {
//    TC: O(N + 2E); SC: O(N)
    public boolean detectCycle(List<List<Integer>> adjList){
        int size = adjList.size();
        boolean[] visited = new boolean[size];
        for(int i = 0; i < size; i++){
            if(!visited[i] && dfs(adjList, visited, i, -1)){
                return true;
            }
        }
        return false;
    }

    private boolean dfs(List<List<Integer>> adjList, boolean[] visited, int start, int prev){
        visited[start] = true;
        for(int it: adjList.get(start)){
            if(!visited[it]){
                if(dfs(adjList, visited, it, start)) {
                    return true;
                }
            }
            else if(it != prev){
                return true;
            }
        }
        return false;
    }
}