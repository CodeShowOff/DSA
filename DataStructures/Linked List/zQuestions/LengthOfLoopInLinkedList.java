import java.util.HashMap;

public class LengthOfLoopInLinkedList {

    // Hashing Approach : TC:O(N) & SC:O(N)
    static int findLoopLength(Node head){
        if(head == null || head.next == null){ 
            return 0; // because there should be atleast one node to be a loop;
        }

        Node temp = head;
        int lengthCounter = 0;
        HashMap<Node, Integer> myMap = new HashMap<>();
        int length = 0;

        while(temp != null){
            if(myMap.containsKey(temp)){
                length = ++lengthCounter - myMap.get(temp);
                break;
            }else{
                myMap.put(temp, ++lengthCounter);
            }
            temp = temp.next;
        }
        return  length;
    }

    // Tortoise & Hare Algorithm (Optimised) : TC:O(N)(average case) & SC:O(1)
    static Node findLoopNode(Node head){
        if(head == null || head.next == null){ 
            return null; // because there should be atleast one node to be a loop;
        }

        Node loopNode = null;
        Node fast = head;
        Node slow = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                loopNode = slow;
                break;
            }
        }
        return loopNode;
    }// now from this we'll get the node which will be the part of the loop;
    // Method to find Length:
    static int findLoopLength2(Node head) {
        Node loopNode = findLoopNode(head);
        if (loopNode == null) {
            return 0; // No loop
        }

        int count = 1;
        Node temp = loopNode.next;
        while (temp != loopNode) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] elements = {1, 2, 3, 4, 5, 6};
        int loopIndex = 2; // Loop starts at the node with value 3
        Node head = Node.createLoopedList(elements, loopIndex);

        int length1 = findLoopLength(head); // Using Hashing Approach
        int length2 = findLoopLength2(head); // Using Tortoise & Hare Approach

        System.out.println("Loop Length (Hashing Approach): " + length1);
        System.out.println("Loop Length (Tortoise & Hare Approach): " + length2);
    }
}

class Node{
    int data;
    Node next;

    // Constructor:
    public Node(int data, Node next){
        this.data = data;
        this.next = next;
    }
    // Constructor:
    public Node(int data){ 
        this.data = data;
        // if only data is provided that means, its the end of the LinkedList:
        this.next = null;
    }
    // Convert Array into LinkedList -> O(N)
    public static Node ArrayToLinkedList(int arr[]){
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
    public static void printLinkedList(Node head){

        Node temp = head;
        while (temp.next != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println(temp.data);
    }
    // Reverse the list:
    static Node reverseList(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
    // Method to create a linked list with a loop
    public static Node createLoopedList(int[] arr, int loopIndex) {
        if (arr.length == 0) return null;

        Node head = new Node(arr[0]);
        Node current = head;
        Node loopNode = null;

        for (int i = 1; i < arr.length; i++) {
            current.next = new Node(arr[i]);
            current = current.next;

            if (i == loopIndex) {
                loopNode = current; // Mark the node where the loop will start
            }
        }

        if (loopIndex >= 0 && loopNode != null) {
            current.next = loopNode; // Create the loop
        }

        return head;
    }
    // method to print the looped linked list (stops after 20 nodes to avoid infinite loops)
    public static void printLoopedList(Node head) {
        Node current = head;
        int count = 0;

        while (current != null && count < 20) { // Limit to 20 nodes for safety
            System.out.print(current.data + " -> ");
            current = current.next;
            count++;
        }

        if (count == 20) {
            System.out.println("... (loop detected or too long to display)");
        } else {
            System.out.println("null");
        }
    }
}