package DepthFirstSearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
Inorder (Left → Root → Right):
    Recur on the left subtree
    Visit the current node
    Recur on the right subtree

    Commonly used in Binary Search Trees to get nodes in sorted order
*/
public class InorderTraversal {
    public List<Integer> inorder(TreeNode root){
        List<Integer> result = new ArrayList<>();
        traverseRecursive(root, result);
        return result;
    }

    // Recursive approach:
    // Logic: Traverse left subtree first, then visit root, then traverse right
    public void traverseRecursive(TreeNode root, List<Integer> result){
        if(root == null){
            return;
        }

        traverseRecursive(root.left, result);  // Traverse left
        result.add(root.val);         // Visit root
        traverseRecursive(root.right, result); // Traverse right
    }

    // Iterative approach:
    // Logic:
    // - Use a stack to simulate recursion.
    // - Go as left as possible, pushing nodes on the stack.
    // - Then pop, visit, and move right.
    public void traverseIterative(TreeNode root, List<Integer> result){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            // Go to the leftmost node
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            // Process node and go right
            current = stack.pop();
            result.add(current.val); // Visit root
            current = current.right;
        }
    }
}