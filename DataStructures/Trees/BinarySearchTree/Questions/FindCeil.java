package BinarySearchTree.Questions;

public class FindCeil {
    int findCeil(TreeNode root, int key) {
        return getCeil(root, key, -1);
    }

    int getCeil(TreeNode root, int key, int ceil){
        if(root == null) return ceil;
        if(root.val == key) return root.val;

        if(root.val > key){
            ceil = root.val;

            return getCeil(root.left, key, ceil);
        }
        else{
            return getCeil(root.right, key, ceil);
        }
    }
}