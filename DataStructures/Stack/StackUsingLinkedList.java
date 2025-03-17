public class StackUsingLinkedList {
     static class Node {
         int data;
         Node next;
         Node(int data) {
             this.data = data;
             next = null;
         }
     }

    static class Queue{
        Node top;
        int size;

        public Queue(){
            this.top = null;
            this.size = 0;
        }

        public void push(int num){
            Node temp = new Node(num);
            temp.next = top;
            top = temp;
            size++;
        }

        public int pop(){
            Node temp = top;
            top = top.next;
            temp.next = null;
            size--;
            return temp.data;
        }

        public int size(){
            return size;
        }
    }

    public static void main(String[] args) {

    }
}
