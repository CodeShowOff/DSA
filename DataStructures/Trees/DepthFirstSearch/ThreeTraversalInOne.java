package DepthFirstSearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ThreeTraversalInOne {
    static class Pair{
        TreeNode node;
        int status;
        Pair(TreeNode node, int status){
            this.node = node;
            this.status = status;
        }
    }

    public List<List<Integer>> preInPostTraversal(TreeNode root) {
        List<Integer> preOrder = new ArrayList<>();
        List<Integer> inOrder = new ArrayList<>();
        List<Integer> postOrder = new ArrayList<>();

        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, 1));

        while(!stack.isEmpty()){
            Pair curr = stack.pop();

            if(curr.status == 1){
                preOrder.add(curr.node.val);
                curr.status = 2;
                stack.push(curr);

                if(curr.node.left != null){
                    stack.push(new Pair(curr.node.left, 1));
                }
            }
            else if(curr.status == 2){
                inOrder.add(curr.node.val);
                curr.status = 3;
                stack.push(curr);

                if(curr.node.right != null){
                    stack.push(new Pair(curr.node.right, 1));
                }
            }
            else{
                postOrder.add(curr.node.val);
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        result.add(preOrder);
        result.add(inOrder);
        result.add(postOrder);
        return result;
    }
}
