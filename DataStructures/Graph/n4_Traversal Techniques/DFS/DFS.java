import java.util.ArrayList;

public class DFS {
    // TC: O(V + E), SC: O(V)
    // TC: O(N) + O(2*Edges); SC: O(3N)
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] visited = new boolean[adj.size()];
        ArrayList<Integer> result = new ArrayList<>();

        dfsHelper(adj, 0, visited, result);
        return result;
    }

    private void dfsHelper(ArrayList<ArrayList<Integer>> adj, int node, boolean[] visited, ArrayList<Integer> result){
        visited[node] = true;
        result.add(node);

        for(int it: adj.get(node)){
            if(!visited[it]){
                dfsHelper(adj, it, visited, result);
            }
        }
    }
}