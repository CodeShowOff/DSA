package com.Codes.LinkedList;

public class AddFirstInCircularLinkedList {
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static Node addFirst(Node head, int value) {
        Node newNode = new Node(value);

        // Case 1: If the list is empty, create a self-loop and return newNode as the head
        if (head == null) {
            newNode.next = newNode;
            return newNode;
        }

        // Case 2: Traverse to the last node (whose next is head)
        Node temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }

        // Insert the new node at the beginning
        newNode.next = head;
        temp.next = newNode;  // Last node should now point to new node

        return newNode;  // Update head to new node
    }

}
