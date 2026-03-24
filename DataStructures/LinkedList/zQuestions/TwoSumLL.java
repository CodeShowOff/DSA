import java.util.*;
/*
Given a sorted doubly linked list of positive distinct elements, the task is to find pairs in a doubly-linked list 
whose sum is equal to the given value x in sorted order.
*/
public class TwoSumLL {

    // [Naive Approach] Using Hashing – O(nlogn) Time and O(n) Space
    static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, Node head) {

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        HashSet<Integer> visited = new HashSet<>();
        Node currNode = head;

        // Traverse the doubly linked list
        while (currNode != null) {
            int x = target - currNode.data;

            // Check if the target exists in the visited set
            if (visited.contains(x)) {
              
                // Pair found, add it to the answer
                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(x);
                pair.add(currNode.data);
                ans.add(pair);
            }

            // Add the current node's value to the visited
            // set
            visited.add(currNode.data);
            currNode = currNode.next;
        }

        // Sort the pairs by the first element of the pair
        Collections.sort(ans, (a, b) -> a.get(0).compareTo(b.get(0)));

        return ans;
    }

    // [Optimised Approach] Using Two Pointer Technique – O(n) Time and O(1) Space
    static ArrayList<ArrayList<Integer>> findPairsWithGivenSum2(int target, Node head) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        // Set two pointers, first to the beginning of DLL
        // and second to the end of DLL.
        Node first = head;
        Node second = head;

        // Move second to the end of the DLL
        while (second.next != null)
            second = second.next;

        // Iterate through the list using two pointers to
        // find pairs
        while (first != second && second.next != first) {

            // If the sum of the two nodes is equal to
            // target, add the pair
            if ((first.data + second.data) == target) {
                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(first.data);
                pair.add(second.data);
                res.add(pair);

                // Move first in forward direction
                first = first.next;

                // Move second in backward direction
                second = second.prev;
            }
            else {
                if ((first.data + second.data) < target)
                    first = first.next;
                else
                    second = second.prev;
            }
        }

        return res;
    }
    public static void main(String[] args) {
        
    }
}

// Java program to find a pair with given sum x
// using map

class Node {
    int data;
    Node next, prev;

    Node(int value) {
        data = value;
        next = prev = null;
    }
}