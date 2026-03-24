public class RemoveDuplicatesFromSortedDLL {
    public static Node removeDuplicates(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node mover = head;
        while (mover != null) {
            Node temp = mover;

            // Skip over duplicate nodes
            while (temp.next != null && temp.data == temp.next.data) {
                temp = temp.next;
            }

            // Link the current node to the next distinct node
            mover.next = temp.next;

            // Update the `prev` pointer of the next node if it exists
            if (temp.next != null) {
                temp.next.prev = mover;
            }

            // Move to the next distinct node
            mover = mover.next;
        }

        return head;
    }

    public static void main(String[] args) {
        // Create a doubly linked list with duplicates: 1 <-> 1 <-> 2 <-> 3 <-> 3
        Node head = new Node(1);
        head.next = new Node(1, null, head);
        head.next.next = new Node(2, null, head.next);
        head.next.next.next = new Node(3, null, head.next.next);
        head.next.next.next.next = new Node(3, null, head.next.next.next);

        System.out.println("Original List:");
        printList(head);

        // Remove duplicates
        head = removeDuplicates(head);

        System.out.println("List After Removing Duplicates:");
        printList(head);
    }

    // Utility method to print the doubly linked list
    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

// Node class for doubly linked list
class Node {
    int data;
    Node next;
    Node prev;

    // Constructor for a node with data, next, and prev
    public Node(int data, Node next, Node prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }

    // Constructor for a standalone node with only data
    public Node(int data) {
        this(data, null, null);
    }
}
