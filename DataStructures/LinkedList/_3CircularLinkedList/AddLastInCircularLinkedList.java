package com.Codes.LinkedList;

public class AddLastInCircularLinkedList {
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static Node addLast(Node head, int value) {
        Node newNode = new Node(value);

        // Case 1: If the list is empty
        if (head == null) {
            newNode.next = newNode;  // Point to itself (circular)
            return newNode;  // New node becomes the head
        }

        // Case 2: Traverse to the last node
        Node temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }

        // Insert the new node at the end
        temp.next = newNode;
        newNode.next = head;  // Maintain circular property

        return head;  // Return head (unchanged)
    }
}
