/*
Problem:
Given a linked list of 'N' nodes, where each node has an integer value that 
can be 0, 1, or 2. You need to sort the linked list in non-decreasing order and 
then return the head of the sorted list.

Input: 1 -> 0 -> 2 -> 1 -> 0 -> 2 -> 1

Output: 0 -> 0 -> 1 -> 1 -> 1 -> 2 -> 2

Explanation: 
In this example, the original linked list contains two 0s, three 1s, and two 2s. 
The sorted linked list has all the 0s at the beginning, followed by all the 1s, 
and finally, all the 2s at the end.
 */
public class SortList {

    // Brute force -> O(2N): count no of 0, 1, and 2 using traversal. Then, replace the values using another traversal.
    
    // Optimised Solution: TC:O(N)
    static Node sortLL(Node head){
        if(head == null || head.next == null){
            return head;
        }

        Node zeros = new Node(-1); // Dummy node for zeroes
        Node ones = new Node(-1); // Dummy node for ones
        Node twos = new Node(-1); // Dummy node for twos
        // Memoisation:
        Node zerosHead = zeros;
        Node onesHead = ones;
        Node twosHead = twos;

        Node current = head;

        while (current != null) {
            switch (current.data) {
                case 0 -> {
                    zeros.next = current;
                    zeros = zeros.next;
                }
                case 1 -> {
                    ones.next = current;
                    ones = ones.next;
                }
                case 2 -> {
                    twos.next = current;
                    twos = twos.next;
                }
                default -> {
                }
            }
            current = current.next;
        }

        zeros.next = (onesHead.next != null) ? onesHead.next : twosHead.next; // if theres no ones then connect directly to twos head
        ones.next = twosHead.next;
        twos.next = null;

        head = zerosHead.next;

        return head;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,1,1,1,0,2,2,2,0,1,0,0,1,2};
        Node head = Node.ArrayToLinkedList(arr);

        head = sortLL(head);
        Node.printLinkedList(head);
    }
}

class Node{
    int data;
    Node next;

    // Constructor:
    Node(int data, Node next){
        this.data = data;
        this.next = next;
    }
    // Constructor:
    Node(int data){ 
        this.data = data;
        // if only data is provided that means, its the end of the LinkedList:
        this.next = null;
    }
    // Convert Array into LinkedList -> O(N)
    static Node ArrayToLinkedList(int arr[]){
        Node head = new Node(arr[0]);
        Node mover = head;
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp; 
        }

        return head;
    }
    // Traversal on a LinkedList -> O(N)
    static void printLinkedList(Node head){

        Node temp = head;
        while (temp.next != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println(temp.data);
    }
}