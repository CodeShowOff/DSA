import java.util.Stack;

class Node{
    Node prev; // for previous node
    int data;
    Node next; // for next node

    Node(Node prev, int data, Node next){
        this.prev = prev;
        this.data = data;
        this.next = next;
    }

    Node(int data){
        this.prev = null;
        this.data = data;
        this.next = null;
    }
}

public class ReverseDoublyLinkedList {
    // Convert Array into DoublyLinkedList -> O(N)
    static Node convertArrToDLL(int[] arr){
        Node head = new Node(arr[0]);
        Node current = head;

        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            current.next = temp;
            temp.prev = current;
            current = temp;
        }
        return head;
    }

    // Traversal on a LinkedList -> O(N)
    static void printDLL(Node head){
        Node temp = head;
        // forward traverse:
        while (temp.next != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println(temp.data);

        // backward traverse:
        Node back = temp;
        while (back.prev != null) {
            System.out.print(back.data + " <- ");
            back = back.prev;
        }
        System.out.println(back.data);
    }

    // (Pending to study) reverse using stack data structure -> TC:O(2N) & SC:O(N)
    // stack data structure -> last in first out
    // not optimised
    static Node reverseDLL_usingStack(Node head){

        if (head == null || head.next == null) {
            return head; // Empty list or single-node list
        }

        Stack<Integer> stack = new Stack<>();

        // Push nodes onto the stack
        Node temp = head;
        while (temp != null) {
            stack.push(temp.data);
            temp = temp.next;
        }

        // Pop nodes from the stack and update values
        temp = head;
        while (temp != null) {
            temp.data = stack.pop();
            temp = temp.next;
        }

        return head;
    }

    // reverse using reversing the links of nodes -> TC:O(N) and SC:O(1)
    static Node reversDLL_usingLinks(Node head){

        Node current = head;
        Node temp = null;

        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;

            current = current.prev;
        }

        return temp.prev;
    }
    public static void main(String[] args) {
        int []arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        Node head = convertArrToDLL(arr);
        // printDLL(head);

        head = reverseDLL_usingStack(head);
        printDLL(head);

        head = reversDLL_usingLinks(head);
        printDLL(head);
    }
}
