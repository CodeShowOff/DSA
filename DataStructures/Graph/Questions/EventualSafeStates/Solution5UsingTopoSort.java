package EventualSafeStates;

import java.util.*;

public class Solution5UsingTopoSort {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;

        // First reverse the adjList:
        List<List<Integer>> revAdjList = new ArrayList<>(n);
        int[] outDegree = new int[n];

        for (int i = 0; i < n; i++) revAdjList.add(new ArrayList<>());

        for(int i = 0; i < n; i++){
            for(int it: graph[i]){
                revAdjList.get(it).add(i);
                outDegree[i]++;
            }
        }

        // The number of out-degrees a node has in the original graph becomes its in-degree in the reversed graph.

        // Start with all terminal nodes (outDegree == 0)
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (outDegree[i] == 0)
                queue.offer(i);
        }

        boolean[] safe = new boolean[n];

        while(!queue.isEmpty()){
            int node = queue.poll();
            safe[node] = true;

            for(int it: revAdjList.get(node)){
                outDegree[it]--;
                if(outDegree[it] == 0) queue.offer(it);
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (safe[i]) result.add(i);
        }

        return result;
    }
}