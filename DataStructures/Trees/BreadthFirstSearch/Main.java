package BreadthFirstSearch;

/*
            10
           /  \
         5     20
        / \    / \
       3   7  15  25
      /     \      \
     1       8      30

*/
public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);

        root.left = new TreeNode(5);
        root.right = new TreeNode(20);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);

        root.left.left.left = new TreeNode(1);
        root.left.right.right = new TreeNode(8);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(25);
        root.right.right.right = new TreeNode(30);

        LevelOrderTraversal levelOrderTraversal = new LevelOrderTraversal();
        System.out.println(levelOrderTraversal.levelOrder(root));
    }
}

