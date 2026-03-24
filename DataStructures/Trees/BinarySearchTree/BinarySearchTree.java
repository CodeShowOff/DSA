package BinarySearchTree;

//public class BinarySearchTree {
//    TreeNode root;
//
//    BinarySearchTree(){
//        root = null;
//    }
//
//    public void insert(TreeNode root, int val){
//        if (root == null){
//            root = new TreeNode(val);
//            return;
//        }
//
//        if(root.val > val){
//            insert(root.left, val);
//        }
//        else{
//            insert(root.right, val);
//        }
//    }

public class BinarySearchTree {
    TreeNode root;

    BinarySearchTree() {
        root = null;
    }

    // to insert a node in bst:
    public void insert(int val) {
        root = insert(root, val);
    }

    private TreeNode insert(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (val < root.val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }

        return root;
    }

    // to delete a node in bst:
    public void delete() {

    }
}

