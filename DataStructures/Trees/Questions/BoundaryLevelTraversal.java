package Questions;

import java.util.ArrayList;
import java.util.List;

public class BoundaryLevelTraversal {
    public List<Integer> boundary(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        if (!isLeaf(root)) result.add(root.val);

        leftBoundary(root.left, result);
        leafNodes(root, result);
        rightBoundary(root.right, result);

        return result;
    }

    public boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    public void leftBoundary(TreeNode root, List<Integer> result){
        if(root == null || isLeaf(root)) return;

        result.add(root.val);
        if(root.left != null) leftBoundary(root.left, result);
        else leftBoundary(root.right, result);
    }

    public void leafNodes(TreeNode root, List<Integer> result) {
        if (root == null) return;

        if (isLeaf(root)) {
            result.add(root.val);
            return; // No need to go deeper if it's a leaf
        }

        leafNodes(root.left, result);
        leafNodes(root.right, result);
    }

    public void rightBoundary(TreeNode root, List<Integer> result){
        if(root == null || isLeaf(root)) return;

        if(root.right != null) rightBoundary(root.right, result);
        else rightBoundary(root.left, result);

        result.add(root.val); // add AFTER recursion — for bottom to up direction
    }
}

/* Method-2: 

public class BoundaryLevelTraversal {
    public List<Integer> boundary(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        if (!isLeaf(root)) result.add(root.data);

        leftBoundary(root.left, result);
        leafNodes(root, result);
        rightBoundary(root.right, result);

        return result;
    }

    public boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    // Iterative left boundary (top-down), excluding leaves
    public void leftBoundary(TreeNode root, List<Integer> result) {
        TreeNode curr = root;
        while (curr != null) {
            if (!isLeaf(curr)) result.add(curr.data);
            if (curr.left != null) curr = curr.left;
            else curr = curr.right;
        }
    }

    // Recursive leaf nodes (unchanged)
    public void leafNodes(TreeNode root, List<Integer> result) {
        if (root == null) return;

        if (isLeaf(root)) {
            result.add(root.data);
            return;
        }

        leafNodes(root.left, result);
        leafNodes(root.right, result);
    }

    // Iterative right boundary (bottom-up), excluding leaves
    public void rightBoundary(TreeNode root, List<Integer> result) {
        Stack<Integer> stack = new Stack<>();
        TreeNode curr = root;

        while (curr != null) {
            if (!isLeaf(curr)) stack.push(curr.data);
            if (curr.right != null) curr = curr.right;
            else curr = curr.left;
        }

        // Add right boundary nodes in reverse order
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
    }
}
*/