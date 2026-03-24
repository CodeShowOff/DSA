package com.Codes.LinkedList;

public class LinkedList {

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
        public Node(int data, Node next){
            this.data = data;
            this.next = next;
        }
    }

    Node head;

    public void insertLast(int data) {
        if (head == null) {
            head = new Node(data);
            return;
        }

        Node temp = head;
        while (temp.next != null)
            temp = temp.next;
        temp.next = new Node(data);
        return;

    }

    public void insertFirst(int data) {
        if (head == null) {
            head = new Node(data);
            return;
        }

        Node p = new Node(data);
        p.next = head;
        head = p;
        return;
    }


    public void deleteLast() {
        if(head == null) return;
        if(head.next == null) {head = null; return;}

        Node pre = null;
        Node curr = head;
        while (curr.next != null) {
            pre = curr;
            curr = curr.next;
        }

        pre.next = null;
        return;
    }
    public void deleteFirst() {
        if(head == null) return;
        head = head.next;
        return;
    }


    public void deleteValue(int val) {
        if(head == null) {
            System.out.println("Empty List");
            return;
        }

        if(head.data == val) {
            head = head.next;
            return;
        }

        Node pre = null;
        Node curr = head;

        while (curr.next != null) {
            if(curr.data == val) break;
            pre = curr;
            curr = curr.next;
        }

        if(curr.next == null) {
            if(curr.data == val) {
                pre.next = null;
                return;
            }
            else {
                System.out.println("data not found");
            }
        }

        pre.next = curr.next;
        return;
    }

    public void print() {
        System.out.println();
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;

        }
    }

    public static void main(String[] args) {
        LinkedList ls = new LinkedList();
        ls.insertLast(10);
        ls.insertLast(20);
        ls.insertLast(30);
        ls.insertFirst(555);
        ls.print();
        ls.deleteValue(555);
        ls.print();
    }

}
