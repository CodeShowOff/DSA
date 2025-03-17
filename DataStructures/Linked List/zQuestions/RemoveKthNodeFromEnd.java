public class RemoveKthNodeFromEnd {
    
    // Brute-Force Approach : TC: O(len) + O(len - k)  -> ~ O(2*len)
    static Node removeKthNodeFromEnd(Node head, int k){
        if(head == null || head.next == null){
            return null;
        }

        Node current = head;
        int lenLL = 0;
        // find the length of the linkedlist:
        while(current != null){
            lenLL++;
            current = current.next;
        }
        // if the head node is to be removed: i.e. length == k
        if(lenLL == k){
            return head.next;
        }

        // to reach one node before the target node
        int target = lenLL - k;
        current = head;
        while(current != null){
            if(--target == 0){
                current.next = current.next.next;
            }
            current = current.next;
        }

        return head;
    }

    // Optimised Approach by Me: Improve it
    static Node removeKthNodeFromEnd2(Node head, int k){
        if(head == null || head.next == null){
            return null;
        }

        Node target = head;
        Node mover = head;
        while(mover != null){
            if(k >= 0){
                k--;
            }else{
                target = target.next;
            }
            mover = mover.next;
        }
        if(k == 0 && target == head){
            return head.next;
        }
        target.next = target.next.next;

        return head;
    }

    // Optimised Approach by Striver: TC:O(len) & SC:O(1)
    /* 
    Approach :
    To enhance efficiency, we will involve two pointers, a fast pointer and a slow pointer. The fast-moving pointer will 
    initially be exactly N nodes ahead of the slow-moving pointer. After which, both of them will move one step at a time simultaneously. 
    When the fast pointer reaches the last node, i.e., the L-th node, the slow is guaranteed to be at the (L-N)-th node i.e. the target node, 
    where L is the total length of the linked list.
    */ 
    static Node removeKthNodeFromEnd3(Node head, int k){
        if(head == null || head.next == null){
            return null;
        }

        Node current = head;
        Node late = head;

        for(int i = 0; i < k; i++){
            current = current.next;
        }
        // if the k is equal to the length of list: remove head
        if(current == null){
            return head.next;
        }
        // now if here, then it confirms that k is not equal to the length of the list i.e. we have to remove middle node or last node:
        while(current.next != null){
            late = late.next;
            current = current.next;
        }
        late.next = late.next.next;
        return head;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4};
        Node head = Node.ArrayToLinkedList(arr);

        head = removeKthNodeFromEnd2(head, 3);
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