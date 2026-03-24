package DepthFirstSearch;

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


        PreorderTraversal preorderTraversal = new PreorderTraversal();
        System.out.println(preorderTraversal.preorder(root)); // prints: [10, 5, 3, 1, 7, 8, 20, 15, 25, 30]

        InorderTraversal inorderTraversal = new InorderTraversal();
        System.out.println(inorderTraversal.inorder(root)); // prints: [1, 3, 5, 7, 8, 10, 15, 20, 25, 30]

        PostorderTraversal postorderTraversal = new PostorderTraversal();
        System.out.println(postorderTraversal.postorder(root)); // prints: [1, 3, 8, 7, 5, 15, 30, 25, 20, 10]
    }
}

