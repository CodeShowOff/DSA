package Questions.Vertical_Order_Traversal_Of_A_Binary_Tree;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
}



class Solution1 {

    public void dfs(TreeNode node, int row, int col,
                    TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map) {
        if (node == null) return;

        // Column exists or not
        if (!map.containsKey(col)) {
            map.put(col, new TreeMap<>());
        }

        // Row map exists or not within this column
        TreeMap<Integer, PriorityQueue<Integer>> rowMap = map.get(col);
        if (!rowMap.containsKey(row)) {
            rowMap.put(row, new PriorityQueue<>());
        }

        // Add current node value
        rowMap.get(row).add(node.val);

        // Traverse children
        dfs(node.left, row + 1, col - 1, map);
        dfs(node.right, row + 1, col + 1, map);
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        dfs(root, 0, 0, map);

        List<List<Integer>> result = new ArrayList<>();

        for (int col : map.keySet()) {
            List<Integer> colList = new ArrayList<>();
            TreeMap<Integer, PriorityQueue<Integer>> rowMap = map.get(col);

            for (int row : rowMap.keySet()) {
                PriorityQueue<Integer> pq = rowMap.get(row);
                while (!pq.isEmpty()) {
                    colList.add(pq.poll());
                }
            }

            result.add(colList);
        }

        return result;
    }
}






class Solution2 {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, Map<Integer, List<Integer>>> map = new TreeMap<>();
        solver(root, map, 0, 0);

        List<List<Integer>> result = new ArrayList<>();

        for (Map<Integer, List<Integer>> rowMap : map.values()) {
            List<Integer> colList = new ArrayList<>();
            for (List<Integer> nodes : rowMap.values()) {
                Collections.sort(nodes); // sort values at same position
                colList.addAll(nodes);
            }
            result.add(colList);
        }

        return result;
    }

    private void solver(TreeNode root, Map<Integer, Map<Integer, List<Integer>>> map, int col, int row) {
        if (root == null) return;

        map.computeIfAbsent(col, x -> new TreeMap<>())
                .computeIfAbsent(row, x -> new ArrayList<>())
                .add(root.val);

        solver(root.left, map, col - 1, row + 1);
        solver(root.right, map, col + 1, row + 1);
    }
}








class Solution3 {
    // Helper class to represent a node's position in the tree
    static class Tuple {
        TreeNode node;
        int x; // vertical
        int y; // level

        public Tuple(TreeNode node, int x, int y) {
            this.node = node;
            this.x = x;
            this.y = y;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        // TreeMap to sort verticals (x), then levels (y), and sort values at each level
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> columnMap = new TreeMap<>();

        Queue<Tuple> queue = new LinkedList<>();
        queue.offer(new Tuple(root, 0, 0));

        while (!queue.isEmpty()) {
            Tuple t = queue.poll();
            TreeNode node = t.node;
            int x = t.x;
            int y = t.y;

            columnMap
                    .computeIfAbsent(x, k -> new TreeMap<>())
                    .computeIfAbsent(y, k -> new PriorityQueue<>())
                    .offer(node.val);

            if (node.left != null) {
                queue.offer(new Tuple(node.left, x - 1, y + 1));
            }
            if (node.right != null) {
                queue.offer(new Tuple(node.right, x + 1, y + 1));
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        for (var levelMap : columnMap.values()) {
            List<Integer> col = new ArrayList<>();
            for (var pq : levelMap.values()) {
                while (!pq.isEmpty()) {
                    col.add(pq.poll());
                }
            }
            result.add(col);
        }

        return result;
    }
}








