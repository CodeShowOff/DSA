package BinaryTreeImplementation;

public class Main {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        int[] values = {25, 15, 50, 10, 22, 35, 70, 4, 12, 18, 24, 31, 34, 66, 90};
        for (int val : values) {
            tree.insertNode(val);
        }

        System.out.println("Inorder Traversal:");
        BinaryTree.printInorder(tree.root);
    }
}
/*
In this specific case, the inserted nodes' values happen to align in a way that the in-order traversal appears to print them in
sorted order, but this is a coincidence based on how the specific values were inserted in this particular example.
*/
