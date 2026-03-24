package DepthFirstSearch;

/*
Postorder (Left → Right → Root):
    Recur on the left subtree
    Recur on the right subtree
    Visit the current node
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostorderTraversal {
    public List<Integer> postorder(TreeNode root){
        List<Integer> result = new ArrayList<>();
        traverseRecursive(root, result);
        return result;
    }

    public void traverseRecursive(TreeNode root, List<Integer> result){
        if(root == null){
            return;
        }

        traverseRecursive(root.left, result);
        traverseRecursive(root.right, result);
        result.add(root.val);
    }

    public void traverseIterative1(TreeNode root, List<Integer> result){ // Using 2 stack:
        if(root == null){
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> store = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()){
            TreeNode temp = stack.pop();
            store.push(temp);

            if(temp.left != null) stack.push(temp.left);
            if(temp.right != null) stack.push(temp.right);
        }

        while (!store.isEmpty()){
            result.add(store.pop().val);
        }
    }

    public void traverseIterative2(TreeNode root, List<Integer> result){ // Using 1 stack:
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        TreeNode lastVisited = null;

        while (current != null || !stack.isEmpty()) {
            // Go as far left as possible
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                TreeNode peekNode = stack.peek();

                // If right child exists and not yet visited, go right
                if (peekNode.right != null && lastVisited != peekNode.right) {
                    current = peekNode.right;
                } else {
                    // Visit the node
                    result.add(peekNode.val);
                    lastVisited = stack.pop();
                }
            }
        }
    }

}
