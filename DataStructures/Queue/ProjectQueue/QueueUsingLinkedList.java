package ProjectQueue;

public class QueueUsingLinkedList<T> implements Queue<T>{
    private static class Node<T>{
        T data;
        Node next;
        Node prev;

        Node(T data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    Node front;
    Node rear;

    @Override
    public void offer(T data) {

    }

    @Override
    public T poll() {
        return null;
    }

    @Override
    public T peek() {
        return null;
    }

    @Override
    public int isEmpty() {
        return 0;
    }
}
