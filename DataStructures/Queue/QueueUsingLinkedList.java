import java.util.NoSuchElementException;

public class QueueUsingLinkedList {
    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    static class Queue{
        Node start;
        Node end;
        int size;

        public Queue(){
            this.start = null;
            this.end = null;
            this.size = 0;
        }

        public void push(int num){
            Node temp = new Node(num);
            if(start == null){
                end = temp;
                start = temp;
            } else {
                end.next = temp;
                end = end.next;
            }
            size++;
        }

        public int pop(){
            if(start == null) throw new NoSuchElementException("Queue is empty");
            Node temp = start;
            start = start.next;
            temp.next = null;
            size--;
            if (size == 0) end = null;  // Update end to null when queue becomes empty
            return temp.data;
        }

        public int top(){
            if(start == null) throw new NoSuchElementException("Queue is empty");
            return start.data;
        }

        public int size(){
            return size;
        }
    }

    public static void main(String[] args) {

    }
}
