// Class that will create a LinkedList:
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
}

public class LinkedList {

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
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Length of the Linked List -> O(N)
    static int findLength(Node head){
        int count = 0;

        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    // Searching an Element -> O(N)
    static boolean ifPresent(Node head, int ele){

        Node temp = head;
        while (temp != null) {
            if(temp.data == ele){
                return true;
            }
            temp = temp.next;
        }

        return false;
    }

    // deletion of head -> O(1)
    static Node removeHead(Node head){
        if(head == null || head.next == null){
            return null;
        }

        Node temp = head; // to store original head
        head = head.next; // updating head
        temp.next = null; // removing the next pointer of original head
        
        // We dont need to delete the previous head manually, 
        // the Java Garbage collection  will take care of it.

        return head;
    }

    // deletion of tail -> O(N)
    static Node removeTail(Node head){
        if(head == null || head.next == null){
            return null;
        }

        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;

        return head;
    }

    // deletion of k-th element -> O(K)
    static Node removeKthElement(Node head, int k){
        if(head == null){
            return head;
        }
        if(k == 1){
            return removeHead(head);
        }
        int count = 0;
        Node temp = head;
        Node previous = null;

        while (temp != null) {
            count++;
            if(count == k){
                if (temp.next == null) { // at last node
                    removeTail(head);
                    break;
                }
                previous.next = previous.next.next;
                break;
            }
            previous = temp;
            temp = temp.next;
        }

        return head;
    }

    // deletion of element -> O(N)
    static Node removeElemrnt(Node head, int ele){
        if(head == null){
            return head;
        }
        if(head.data == ele){
            return removeHead(head);
        }

        Node temp = head;
        Node previous = null;
        while (temp != null) {
            if(temp.data == ele){
                previous.next = previous.next.next;
                break;
            }
            previous = temp;
            temp = temp.next;
        }

        return head;
    }

    // insertion of an element at head -> O(1)
    static Node insertElementAtHead(Node head, int value){
        Node temp = new Node(value, head);
        return temp; // return temp as new head
    }

    // insertion of an element at tail -> O(1)
    static Node insertElementAtTail(Node head, int value){
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        Node last = new Node(value);
        temp.next = last;

        return head;
    }

    // insertion of an element at k-th position -> O(K)
    static Node insertElementAtK(Node head, int value, int k){
        if(head == null){
            if(k==1){
                return insertElementAtHead(head, value);
            }else{
                System.out.println("Not Possible.");
                return head;
            }
        }
        if(k == 1){
            return insertElementAtHead(head, value);
        }
        if(k > findLength(head)+1){
            System.out.println("Not Possible.");
            return head;
        }

        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            if(count == k-1){
                Node newEle = new Node(value, temp.next);
                temp.next = newEle;
                break;
            }
            temp = temp.next;
        }

        return head;
    }

    // insertion before an element -> O(N)
    static Node insertElement(Node head, int value, int before){
        if(head == null){
            System.out.println("Not Possible.");
            return null;
        }
        if(head.data == before){
            return insertElementAtHead(head, value);
        }

        boolean found = false;
        Node temp = head;
        while (temp.next != null) {
            if(temp.next.data == before){
                Node newEle = new Node(value, temp.next);
                temp.next = newEle;
                found = true;
                break;
            }
            temp = temp.next;
        }

        if(found == false){
            System.out.println("Not Possible.");
        }

        return head;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Node head = ArrayToLinkedList(arr);

        printLinkedList(head);

        // Length:
        int length = findLength(head);
        System.out.println("Length: " + length);

        // Searching:
        boolean check = ifPresent(head, 4);
        System.out.println("Present: " + check);

        // Deletion of head:
        head = removeHead(head);
        printLinkedList(head);

        // Deletion  of tail:
        head = removeTail(head);
        printLinkedList(head);

        // deletion of k-th element:
        head = removeKthElement(head, 3);
        printLinkedList(head);

        // deletion of element:
        head = removeElemrnt(head, 7);
        printLinkedList(head);

        // insertion of an element at head:
        head = insertElementAtHead(head, 1);
        printLinkedList(head);

        // insertion of an element at tail:
        head = insertElementAtTail(head, 9);
        printLinkedList(head);

        // insertion of an element at k-th position:
        head = insertElementAtK(head, 4, 4);
        printLinkedList(head);

        // insertion of an element at k-th position:
        head = insertElement(head, 7, 8);
        printLinkedList(head);
    }
}