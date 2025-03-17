import java.util.*;

public class ReverseList {
    // Iterative method:
    // Brute-force approach: TC:O(2N) & SC:O(N)
    static Node reverseList(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node mover = head;

        Stack<Integer> stack = new Stack<>();
        while(mover != null){
            stack.add(mover.data);
            mover = mover.next;
        }

        mover = head;
        while(mover != null){
            mover.data = stack.pop();
            mover = mover.next;
        }

        return head;
    }

    // Optimised method by me: TC:O(N) & SC:O(1) 
    static Node reverseList2(Node head){
        if(head == null || head.next == null){
            return head;
        }

        Node mover = head;
        Node prev = null;  // -> to keep in mind about the next node address

        while(mover != null){
            Node next = mover.next;
            mover.next = prev;
            prev = mover;
            mover = next; 
        }
        return prev;
    }

    // Recursive method:
    static Node reverseList3(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node newHead = reverseList3(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};
        Node head = Node.ArrayToLinkedList(arr);

        head = reverseList3(head);
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