package Questions;

import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class TopView {
    // Helper class to store a node and its horizontal distance (HD)
    static class Pair {
        Node node;
        int hd;

        Pair(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    // Function to return a list of nodes visible from the top view of a binary tree
    static ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;

        // TreeMap keeps keys sorted (horizontal distances)
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();

        queue.add(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            int hd = current.hd;
            Node node = current.node;

            // Add to map only if this horizontal distance hasn't been seen before
            if (!map.containsKey(hd)) {
                map.put(hd, node.data);
            }

            // Traverse left and right children with updated HD
            if (node.left != null) queue.add(new Pair(node.left, hd - 1));
            if (node.right != null) queue.add(new Pair(node.right, hd + 1));
        }

        // Extract top view from the TreeMap
        result.addAll(map.values());
        return result;
    }
}

