package BinarySearchTree.Questions;

public class FindFloor {
    int findFloor(TreeNode root, int key) {
        return getFloor(root, key, -1);
    }

    int getFloor(TreeNode root, int key, int floor){
        if(root == null) return floor;
        if(root.val == key) return root.val;

        if(root.val < key){
            floor = root.val;
            return getFloor(root.right, key, floor);
        }
        else{
            return getFloor(root.left, key, floor);
        }
    }
}
