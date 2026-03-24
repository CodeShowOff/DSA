import java.util.*;

public class AlienDictionary {
    public String findOrder(String[] words) {

        // Graph: adjacency list for each character
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < 26; i++) graph.add(new ArrayList<>());

        int[] indegree = new int[26];
        boolean[] seen = new boolean[26];

        // Step 1: Mark all seen characters
        for (String word : words)
            for (char c : word.toCharArray())
                seen[c - 'a'] = true;

        // Step 2: Build the graph
        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i], w2 = words[i + 1];
            int len = Math.min(w1.length(), w2.length());
            boolean foundDiff = false;

            for (int j = 0; j < len; j++) {
                char c1 = w1.charAt(j), c2 = w2.charAt(j);
                if (c1 != c2) {
                    graph.get(c1 - 'a').add(c2 - 'a');
                    indegree[c2 - 'a']++;
                    foundDiff = true;
                    break;
                }
            }

            // Invalid case: ["abc", "ab"]
            if (!foundDiff && w1.length() > w2.length())
                return "";
        }

        // Step 3: Topological sort using BFS (Kahn's algorithm)
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < 26; i++)
            if (seen[i] && indegree[i] == 0)
                queue.offer(i);

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            result.append((char)(curr + 'a'));

            for (int neighbor : graph.get(curr)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0)
                    queue.offer(neighbor);
            }
        }

        // Step 4: Check if all characters are included (cycle detection)
        for (int i = 0; i < 26; i++)
            if (seen[i] && indegree[i] > 0)
                return ""; // cycle detected

        return result.toString();
    }
}
