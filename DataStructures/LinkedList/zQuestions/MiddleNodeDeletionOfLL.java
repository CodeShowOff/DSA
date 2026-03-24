public class MiddleNodeDeletionOfLL {
    static Node deleteMiddleNode(Node head){
        if(head == null || head.next == null){
            return head;
        }
        
        Node slow = head;
        Node fast = head;

        // Move 'fast' two nodes ahead for the initial position as we have to reach the node previous to the middle node via 'slow'.
        fast = fast.next.next;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node middleNode = slow;
        if (middleNode.next != null) {
            middleNode.next = middleNode.next.next;
        }

        return middleNode;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8};
        Node head = Node.ArrayToLinkedList(arr);
        Node.printLinkedList(head);
        
        deleteMiddleNode(head);
        Node.printLinkedList(head);
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
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
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