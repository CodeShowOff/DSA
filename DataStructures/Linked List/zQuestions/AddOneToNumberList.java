/*
You are given a linked list where each element in the list is a node and have an integer data. 
You need to add 1 to the number formed by concatinating all the list node numbers together and 
return the head of the modified linked list. 

Note: The head represents the first element of the given array.
 */
public class AddOneToNumberList {

    // Brute-force Approach: TC:O(3N) & SC:O(1)
    static Node addOneToNumberList(Node head){
        // first reverse the list, so that the last digit comes first for traversal in List:
        Node revHead = Node.reverseList(head);
        Node mover = revHead;

        int carry = 1; // as we have to add one to List 

        while(mover != null){
            // optimisation: if carry equals to 0 then it doesn't require to be check further
            if(carry == 0){
                break;
            }
            int sum = mover.data + carry;
            mover.data = sum % 10;
            carry = sum/10;

            mover = mover.next;
        }
        if(carry != 0){
            head = Node.reverseList(revHead);
            Node temp = new Node(carry);
            temp.next = head;
            head = temp;
            return head;
        }

        // re reverse the List to its original form:
        head = Node.reverseList(revHead);
        return head;
    }

    // Optimised Approach using recursion: TC:(N) & SC:O(N)
    static Node addOneToNumberList2(Node head){
        int carry = propagateCarry(head);

        // If there is a carry remaining, add a new node at the beginning
        if(carry != 0){
            Node newHead = new Node(carry);
            newHead.next = head;
            return newHead;
        }

        return head;
    }
    static int propagateCarry(Node head){
        if(head == null){
            return 1;
        }

        int carry = propagateCarry(head.next);
        int sum = head.data + carry;
        head.data = sum % 10;
        return sum / 10;
    }

    public static void main(String[] args) {
        int arr[] = {9,9,8};
        Node head = Node.ArrayToLinkedList(arr);

        head = addOneToNumberList2(head);
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
}