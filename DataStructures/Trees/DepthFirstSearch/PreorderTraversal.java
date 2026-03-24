package DepthFirstSearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
Preorder (Root → Left → Right):
    Visit the current node
    Recur on the left subtree
    Recur on the right subtree
*/
public class PreorderTraversal {
    public List<Integer> preorder(TreeNode root){
        List<Integer> result = new ArrayList<>();
        traverseRecursive(root, result);
        return result;
    }

    // Recursive Approach:
    // Logic: Visit root first, then recursively traverse left and right subtrees
    public void traverseRecursive(TreeNode root, List<Integer> result){
        if(root == null){
            return;
        }

        result.add(root.val);
        traverseRecursive(root.left, result);
        traverseRecursive(root.right, result);
    }

    // Iterative Approach:
    // Logic: Use stack to simulate recursion. Push right first so left is processed first.
    public void traverseIterative(TreeNode root, List<Integer> result){
        if(root == null){
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode temp = stack.pop();
            result.add(temp.val);

            if(temp.right != null) stack.push(temp.right);
            if(temp.left != null) stack.push(temp.left);
        }
    }
}

/*
### 📊 Time Complexity: For recursive approach:
- Each node in the binary tree is visited **exactly once**.
> **Time Complexity = O(n)**
Where `n` is the number of nodes in the tree.

### 🧠 **Space Complexity:**
There are **two things** to consider:\
1. **Recursive call stack**:
   - In the worst case (highly unbalanced tree like a linked list), the recursion depth could be **O(n)**.
   - In the best case (perfectly balanced tree), the recursion depth is **O(log n)**.
   - So, recursion stack space = **O(h)** where `h` is the height of the tree.

2. **Result list**:
   - You're storing each node’s data once in the list.
   - So, the result list takes **O(n)** space.

> **Space Complexity = O(n)** (for result list)
> **Auxiliary Space = O(h)** (for recursion stack)
*/