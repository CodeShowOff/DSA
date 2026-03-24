/*
Problem:
Given the heads of two non-empty linked lists representing two non-negative integers. 
The digits are stored in reverse order, and each of their nodes contains a single digit. 
Add the two numbers and return the sum as a linked list.

num1  = 243, num2 = 564

l1 = [2,4,3]
l2 = [5,6,4]

Result: sum = 807; L = [7,0,8]

Explanation: Since the digits are stored in reverse order, reverse the numbers 
first to get the or original number and then add them as → 342 + 465 = 807. 
Refer to the image below.
 */
public class AddTwoNumList{
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

    // Solution:
    // Note that we use a dummy head to simplify the code. Without a dummy head, you would have to write extra conditional statements to initialize the head's value.
    static Node addTwoLL(Node head1, Node head2){

        Node result = new Node(-1); // Dummy head for simplicity
        Node current = result;

        Node temp1 = head1;
        Node temp2 = head2;

        int carry = 0;
        int sum;

        while (temp1 != null || temp2 != null) {
            // to add carry from previous sum:
            sum = carry;

            if(temp1 != null){
                sum += temp1.data;
            }
            if(temp2 != null){
                sum += temp2.data;
            }

            Node tempSum = new Node(sum % 10);
            carry = sum/10;
            current.next = tempSum;
            current = current.next;

            if(temp1 != null){
                temp1 = temp1.next;
            }
            if(temp2 != null){
                temp2 = temp2.next;
            }
        }
        if(carry > 0){
            Node tempNode = new Node(carry);
            current.next = tempNode;
        }

        //now remove dummy node:
        Node temp = result;
        result = result.next;
        temp.next = null;

        return result;
    }

    public static void main(String[] args) {
        // Note digits are stored in reverse order:

        int arr1[] = {3,5};
        int arr2[] = {4,5,9,9};
        //      its- 9954 + 53 = 10007

        Node head1 = ArrayToLinkedList(arr1);
        Node head2 = ArrayToLinkedList(arr2);

        Node result = addTwoLL(head1, head2);
        printLinkedList(result);

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
}

