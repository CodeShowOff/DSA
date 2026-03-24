package BinaryTreeImplementation;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

    TreeNode root;

    /*
    This insertNode(int val) method is for inserting a node into a binary tree, specifically a complete binary tree — not a binary search tree (BST).

    What it does:
        It inserts the new value (val) into the tree level by level, from left to right, just like how a complete binary tree is constructed.
        The method uses a breadth-first search (BFS) approach using a Queue to find the first available position.
    */
    public void insertNode(int val) {
        if (root == null) {
            root = new TreeNode(val);
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            if (current.left == null) {
                current.left = new TreeNode(val);
                break;
            } else {
                queue.add(current.left);
            }

            if (current.right == null) {
                current.right = new TreeNode(val);
                break;
            } else {
                queue.add(current.right);
            }
        }
    }

    // Inorder traversal printer
    public static void printInorder(TreeNode root) {
        if (root == null) return;

        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }
}