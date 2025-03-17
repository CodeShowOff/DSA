import java.util.HashSet;

public class LinkedListLoop {

    // Bruteforce Approach: For each node traverse the entire list, if you get on the same node it is the start point of the loop;
    
    // Approach 2: Hashing : TC:O(N) & SC:O(N)
    // Note: It will return the head of the loop i.e. the node where loop is starting;
    static Node findLoop(Node head){
        if(head == null || head.next == null){ 
            return null; // because there should be atleast one node to be a loop;
        }

        Node temp = head;
        HashSet<Node> mySet = new HashSet<>();
        while(temp != null){
            if(mySet.contains(temp)){
                break;
            }else{
                mySet.add(temp);
            }
            temp = temp.next;
        }

        Node loopStart = temp;
        return loopStart;
    }

    // Approach 3: Tortoise & Hare Algorithm (Optimised) : TC:O(N) 'actually not precise' & SC:O(1)
    /*
        `fast` or `fast.next` reaches the end of the linked list (i.e., becomes null). In this case, there is no loop in the linked list ie. the linked list is linear, and the algorithm terminates by returning false.
        `fast` and `slow` pointers meet at the same node. This indicates the presence of a loop in the linked list, and the algorithm terminates by returning `true`.

        The relative speed between them causes the gap to decrease by one node in each iteration (fast gains two nodes while slow gains one node). 
        This continuous reduction ensures that the difference between their positions decreases steadily. Mathematically, if the fast pointer gains 
        ground twice as fast as the slow pointer, the difference in their positions reduces by one node after each step. Consequently, this reduction
        in the distance between them continues until the difference becomes zero.
    */
    // Note: It may not return the head of the loop, it will return a node that will be part of the loop;
    static Node findLoop2(Node head){
        if(head == null || head.next == null){ 
            return null; // because there should be atleast one node to be a loop;
        }

        Node loopNode = null;
        Node fast = head;
        Node slow = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){ // The reason why slow == fast if loop exists is relative length;
                loopNode = slow;
                break;
            }
        }
        return loopNode;
    }

    public static void main(String[] args) {
        int[] elements = {1, 2, 3, 4, 5, 6, 7};
        int loopIndex = 2; // Loop starts at the node with value 3
        Node head = Node.createLoopedList(elements, loopIndex);

        Node loopNode = findLoop(head);
        Node loopNode2 = findLoop2(head);

        System.out.println(loopNode.data);
        System.out.println(loopNode2.data);
        // Note: both may give different answer as the second method is not returning the starting point of the loop;
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