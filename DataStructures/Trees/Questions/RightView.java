package Questions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class RightView {
    // Solution-1:
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            Integer lastElement = null;

            for (int i = 0; i < queueSize; i++) {
                TreeNode node = queue.poll();
                lastElement = node.val;

                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            result.add(lastElement);
        }
        return result;
    }


    // Solution-2: More Optimised;
    public List<Integer> rightSideView2(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        traverse(root, 0, ans);
        return ans;
    }
    private void traverse(TreeNode root, int level, List<Integer> ans) {
        if(root == null) return;
        if(ans.size()== level) {
            ans.add(root.val);
        }
        traverse(root.right, level+1, ans);
        traverse(root.left, level+1, ans);
    }
}