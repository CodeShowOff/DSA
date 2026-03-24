import java.util.HashSet;
/*
Intersection Point: The intersection point of two linked lists is defined as the first common node where 
the two lists converge. The method correctly identifies this by leveraging the HashSet to detect the first common node.
 */
public class IntersectionPointOfLists {
    // Approach-1: Brute-force: cheching for each Node 

    // Approach-2: Hashing: TC:O(m+n) where where 𝑚 is the number of nodes in List1 and 𝑛 is the number of nodes in List2
    //                       SC:O(m)
    static Node findIntersectionPoint(Node head1, Node head2){

        // Storing the Node of List1 in HashSet:
        HashSet<Node> mySet = new HashSet<>();

        Node temp = head1;
        while(temp != null){
            mySet.add(temp);
            temp = temp.next;
        }

        // now checking if any Node in List2 already exists in mySet, if yes then that is my Intersection point:
        temp = head2;
        while(temp != null){
            if(mySet.contains(temp)){
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    // Approach-3 (Optimised): Two Pointer: TC:O(m + n) & SC:O(1)
    static Node findIntersectionPoint2(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        // Step 1: Get the lengths of both lists
        int length1 = getLength(head1);
        int length2 = getLength(head2);

        // Step 2: Align the starting points
        if (length1 > length2) {
            head1 = moveForward(head1, length1 - length2);
        } else {
            head2 = moveForward(head2, length2 - length1);
        }
    
        // Step 3: Traverse both lists simultaneously
        while (head1 != null && head2 != null) {
            if (head1 == head2) {
                return head1; // Intersection point found
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        return null; // No intersection
    }
    static int getLength(Node head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    } 
    static Node moveForward(Node head, int steps) {
        while (steps > 0 && head != null) {
            head = head.next;
            steps--;
        }
        return head;
    }
    
    // Approach-4 (Optimised): TC:O(2*max(length of list1,length of list2)) & SC:O(1)
    /*
    The difference of length method requires various steps to work on it. Using the same concept of difference of length, a different 
    approach can be implemented. The process is as follows:-
        Take two dummy nodes for each list. Point each to the head of the lists.
        Iterate over them. If anyone becomes null, point them to the head of the opposite lists and continue iterating until they collide.
    */
    static Node findIntersectionPoint3(Node head1,Node head2) {
        Node d1 = head1;
        Node d2 = head2;
        // if d1 == d2 then either they are at same node or they both reached the null:
        while(d1 != d2) {
            d1 = d1 == null ? head2 : d1.next;
            d2 = d2 == null ? head1 : d2.next;
        }
        // so returning d1 or d2 perfectly handles it:
        // in case of same node it will send return the node address 
        // and in case of both null it will still return the null.
        return d1;
    }
    
   
    public static void main(String[] args) {
        
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