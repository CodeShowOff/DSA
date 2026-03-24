public class LinkedListMiddle{

    // Bruteforce approach: TC:O(len + len/2) & SC:O(1)
    static Node middleNode(Node head){
        if(head == null || head.next == null){
            return head;
        }

        // first we'll find the length of the List:
        Node temp = head;
        int len = 0;

        while(temp != null) {
            len++;
            temp = temp.next;
        }

        int middleNode = len/2 + 1;
        temp = head;

        while(temp != null) {
            middleNode--;
            if(middleNode == 0){
                break;
            }
            temp = temp.next;
        }

        return temp;
    }

    // Tortoise and Hare Approach (Optimised): TC:O(len/2) & SC:O(1)
    /*
        The Tortoise and Hare algorithm works because the fast-moving hare reaches the end of the list in exactly the 
        same time it takes for the slow-moving tortoise to reach the middle. When the hare reaches the end, the tortoise 
        is guaranteed to be at the middle of the list.
    */
    static Node middleNode2(Node head){
        if(head == null || head.next == null){
            return head;
        }
        
        Node slow = head; // -> Tortoise
        Node fast = head; // -> Hare (rabbit)

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node middleNode = slow;
        return middleNode;
    }
    // Explanation:
    /*
        If there are 2 persons P1 and P2:
        P1 is travelling with speed 'x' &
        P2 is travelling with speed 'x/2' 
        then the distance covered by P1 is 'd' and P2 is 'd/2';
     */
    public static void main(String[] args){
        int arr[] = {1,2,3,4,5,6};
        Node head = Node.ArrayToLinkedList(arr);

        // Node midNode = middleNode(head);
        // System.out.println(midNode.data);

        Node midNode2 = middleNode2(head);
        System.out.println(midNode2.data);
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