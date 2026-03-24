import java.util.Stack;

public class PelindromeList {
    // brute-force approach : TC:O(2N) & SC:O(N)
    static boolean isPelindrome(Node head){
        if(head == null){
            return false;
        }
        if(head.next == null){
            return true;
        }

        Stack<Integer> stack = new Stack<>();
        Node mover = head;
        while(mover != null){
            stack.add(mover.data);
            mover = mover.next;
        }

        mover = head;
        while(mover != null){
            if(mover.data != stack.pop()){
                return false;
            }
            mover = mover.next;
        }
        return true;
    }

    // optimised method: TC:O(2N) & SC:(1)
    // The previous approach uses O(N) additional space, which can be avoided by reversing 
    // only half of the linked list and comparing the first and second halves. If they match,
    // then return true else return false.
    static boolean isPelindrome2(Node head){
        if(head == null){
            return false;
        }
        if(head.next == null){
            return true;
        }
        // now for the middle of the list, we will use Tortoise and Hare Algorithm:
        Node slow = head;
        Node fast = head;       
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        // now the slow pointer is always at the middle node of the list,
        // in case of odd no of nodes it's on middle and in case of even no of nodes it's on the 
        // first middle

        // now we have to reverse the list from the node next to middle node
        // and then we'll get two list as:
        Node revHead = reverseList(slow.next);
        Node firstList = head;
        Node secondList = revHead;

        while(secondList != null){
            if(firstList.data != secondList.data){
                reverseList(slow.next);
                return false;
            }
            firstList = firstList.next;
            secondList = secondList.next;
        }

        // finally, reverse the reversed list to get the original list:
        reverseList(slow.next);
        return true;
    }
    static Node reverseList(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        int arr[] = {2,4,3,4,2};
        Node head = Node.ArrayToLinkedList(arr);

        Boolean check = isPelindrome2(head);
        System.out.println(check);
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