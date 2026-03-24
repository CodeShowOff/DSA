package Questions;

import java.util.*;

public class BottomView {
    static class Pair{
        TreeNode key;
        int value;

        Pair(TreeNode key, int value){
            this.key = key;
            this.value = value;
        }
    }

    public ArrayList<Integer> bottomView(TreeNode root) {
        // Code here
        Map<Integer, Integer> map = new TreeMap<>();

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));

        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            TreeNode node = pair.key;
            int val = pair.value;

            map.put(val, node.val);

            if(node.left != null) queue.add(new Pair(node.left, val - 1));
            if(node.right != null) queue.add(new Pair(node.right, val + 1));
        }

        return new ArrayList<Integer>(map.values());
    }
}
