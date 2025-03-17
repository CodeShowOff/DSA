package _NeedOptimisation;

import java.util.ArrayList;

public class MergeKSortedLists {
    Node mergeKLists(ArrayList<Node> myList) {
        Node head = myList.getFirst();
        for (int i = 1; i < myList.size(); i++) {
            Node curr = myList.get(i);
            if (curr == null) {
                continue;
            }
            head = mergeTwo(head, curr);
        }
        return head;
    }

    Node mergeTwo(Node head1, Node head2) {
        Node head = new Node(-1);
        Node temp = head;

        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                temp.next = head1;
                head1 = head1.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next;
        }

        if (head1 != null) {
            temp.next = head1;
        } else if (head2 != null) {
            temp.next = head2;
        }
        return head.next;
    }
}
class Node {
    int data;
    Node next = null;
    Node bottom = null;
    Node(){

    }
    Node(int data){
        this.data = data;
    }
}