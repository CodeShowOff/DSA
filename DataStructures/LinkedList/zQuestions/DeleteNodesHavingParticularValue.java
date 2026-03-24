/*
You are given the head_ref of a doubly Linked List and a Key. Your task is to delete all occurrences of the given key 
if it is present and return the new DLL.

Input:
2<->2<->10<->8<->4<->2<->5<->2
2
Output: 
10<->8<->4<->5

Explanation: 
All Occurences of 2 have been deleted.
*/
public class DeleteNodesHavingParticularValue {
    static Node deleteNodesHavingParticularValue(Node head, int key){ 
        Node mover = head;
        while(mover != null){
            if(mover.data == key){
                // if its head node then we need to update the head:
                if(mover == head){
                    head = mover.next;
                }

                if(mover.prev != null) mover.prev.next = mover.next;
                if(mover.next != null) mover.next.prev = mover.prev;
                
                Node temp = mover;
                mover = mover.next;

                temp.next = null;
                temp.prev = null;
            }
            else{
                mover = mover.next;
            }
        }
        return head;
    }  

    public static void main(String[] args) {
        
    }
}
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
