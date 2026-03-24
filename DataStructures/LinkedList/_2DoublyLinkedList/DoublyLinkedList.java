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
public class DoublyLinkedList {

    // Convert Array into DoublyLinkedList -> O(N)
    static Node convertArrToDLL(int[] arr){
        if(arr.length == 0){
            System.out.println("The provided array is empty.");
            return null;
        }

        Node head = new Node(arr[0]);
        Node mover = head;

        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            mover.next = temp;
            temp.prev = mover;
            mover = temp; // or mover = mover.next;
        }
        return head;
    }

    // Traversal on a LinkedList -> O(N)
    static void printDLL(Node head){
        if(head == null){
            System.out.println("null");
            return;
        }

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

    // deletion of head -> O(1)
    static Node removeHead(Node head){
        if(head == null || head.next == null){
            return null;
        }

        Node temp = head; // to store original head
        head = head.next; // updating head
        head.prev = null; // removing the previous pointer of updated head
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
        temp.next.prev = null;
        temp.next = null;

        return head;
    }

    // deletion of k-th element -> O(K) 
    // Method 1:
    static Node removeKthElement(Node head, int k){
        if(head == null){
            return head;
        }
        if(k == 1 || head.next == null){ // at first node
            return removeHead(head);
        }

        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            if(count == k){
                if(temp.next == null){ // at last node
                    removeTail(head);
                    break;
                }
                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;
                // now remove the useless node:
                temp.next = null;
                temp.prev = null;
                break;
            }
            temp = temp.next;
        }
        if(temp == null){
            System.out.println("Invalid position.");
        }
        return head;
    }

    // Method 2:
    static Node removeKthElement2(Node head, int k){
        if(head == null){
            return head;
        }

        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            if(count == k){
                break;
            }
            temp = temp.next;
        } // now after the loop the temp will be at the position which is to be removed.

        // if the provided position is invalid then:
        if(temp == null){
            System.out.println("Invalid position.");
        }
        // if the position is first:
        else if(temp.prev == null){
            return removeHead(head);
        }
        // if the position is last:
        else if(temp.next == null){
            return removeTail(head);
        }
        // if the position is somewhere in middle:
        else{
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;

            // now remove the useless node:
            temp.prev = null;
            temp.next = null;
        }
        return head;
    }

    // deletion of given node -> O(1)
    static void removeNode(Node temp){
        if(temp.prev == null){ // head node
            System.out.println("Not Possible."); // removing head node is'nt a good practice
            return;
        }
        else if(temp.next == null){ // last node
            temp.prev.next = null;
            temp.prev = null;
            return;
        }
        // now its sure that it has next and previous node:
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
        temp.next = null;
        temp.prev = null;
    }

    // Insertion of an element before head -> O(1)
    static Node insertBeforeHead(Node head, int value){
        Node newHead = new Node(value);
        newHead.next = head;
        head.prev = newHead;

        return newHead;
    }

    // Insertion of an element before Tail -> O(N)
    static Node insertBeforeTail(Node head, int value){
        if( head.next == null){
            return insertBeforeHead(head, value);
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        // now, temp is pointing to the last element.
        Node newNode = new Node(value);
        newNode.prev = temp.prev;
        newNode.next = temp;
        temp.prev.next = newNode;
        temp.prev = newNode;

        return head;
    }

    // insertion of an element before k-th position -> O(K)
    static Node insertBeforeKthElement(Node head, int value, int k){
        if( k == 1){
            return insertBeforeHead(head, value);
        }

        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            if(count == k){
                Node newEle = new Node(value);
                newEle.prev = temp.prev;
                newEle.next = temp;

                temp.prev.next = newEle;
                temp.prev = newEle;

                break;
            }
            temp = temp.next;
        }

        return head;
    }

    // insertion of an element before given node -> O(1)
    static void insertBeforeNode(Node temp, int value){

        Node newEle = new Node(value);
        newEle.next = temp;
        newEle.prev = temp.prev;

        temp.prev.next = newEle;
        temp.prev = newEle;
    }

    public static void main(String[] args) {
        int []arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        Node head = convertArrToDLL(arr);
        printDLL(head);

        head = removeHead(head);
        printDLL(head);

        head = removeTail(head);
        printDLL(head);

        head = removeKthElement(head, 9);
        printDLL(head);

        head = removeKthElement2(head, 4);
        printDLL(head);
        
        removeNode(head.next.next);
        printDLL(head);

        head = insertBeforeHead(head, 999);
        printDLL(head);

        head = insertBeforeTail(head, 999);
        printDLL(head);

        head = insertBeforeKthElement(head, 999, 3);
        printDLL(head);

        insertBeforeNode(head.next.next.next, 999);
        printDLL(head);
    }
}
