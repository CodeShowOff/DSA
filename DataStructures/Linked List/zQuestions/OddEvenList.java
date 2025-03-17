import java.util.ArrayList;
import java.util.List;
/*
Problem:
Given a LinkedList of integers. Modify the LinkedList in such a way that in Modified 
LinkedList all the even indices appear before all the odd indices in LinkedList.

Also, note that the order of even and odd indices should remain the same. 
 */

public class OddEvenList {
    // To convert : [2,3,1,4,5,6]  ->  [2,1,5,3,4,6]
    // odd index first then even index.

    // Brute force -> TC:O(2N) & SC:O(N)
    static Node OddEven(Node head){
        if (head == null || head.next == null || head.next.next == null) {
            return head; // No need to rearrange for small lists
        }

        // Traverse the list and store data in an ArrayList
        List<Integer> dataList = new ArrayList<>();

        // first storing odd places:
        Node current = head;  // since the head position is odd position
        while (current != null && current.next != null) {
            dataList.add(current.data);
            current = current.next.next; // for traversing odd places only
        }
        if(current != null){ // edge case: if the current.next == null i.e. at last node then the loop will break out but the data of that node wont be inserted into dataList.
            dataList.add(current.data);
        }
        
        // then storing even places:
        current = head.next;  // to start from even position
        while (current != null && current.next != null) {
            dataList.add(current.data);
            current = current.next.next; // for traversing even places only
        }
        if(current != null){ // edge case: if the current.next == null i.e. at last node then the loop will break out but the data of that node wont be inserted into dataList.
            dataList.add(current.data);
        }

        // Step 2: Replace data at odd and even indices
        current = head;
        int i = 0;
        while(current != null) {
            current.data = dataList.get(i++);
            current = current.next;
        }
        return head;
    }

    // Optimised Solution -> TC:O(N) & SC:O(1)   [Note: while loop is running for O(N/2) but we are doing two operations inside it so actually its : O(N/2)*2 which is slightly faster than O(N) so we can just say its ~ O(N)]
    static Node OddEven2(Node head){

        if(head == null || head.next == null){
            return head;
        }

        Node odd = head;
        Node even = head.next;
        Node evenHead = even; // memoize for connecting odd and even node at last

        while (even != null && even.next != null) { // because 'even' will always be ahead of 'odd' since both are forwardind simultaneously

            odd.next = odd.next.next; // first odd then even other wise the link will be lost
            even.next = even.next.next; 

            odd = odd.next;
            even = even.next;
        }

        odd.next = evenHead; // connecting even to odd

        return head;
    }
    public static void main(String[] args) {
        int arr[] = {2,3,1,4,5,6};
        Node head = Node.ArrayToLinkedList(arr);

        head = OddEven(head);
        Node.printLinkedList(head);

        head = OddEven2(head);
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