package ProjectStack.com.StackImplementation;

class StackUsingLinkedList<T> implements Stack<T> {

    private static class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<T> top;
    int size = 0;

    public StackUsingLinkedList() {
        this.top = null;
    }

    @Override
    public void push(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = top;
        top = newNode;
        size++;
    }

    @Override
    public T pop() {
        if (empty()) {
            throw new RuntimeException("Stack Underflow: Cannot pop from an empty stack");
        }
        T data = top.data;
        top = top.next;
        size--;
        return data;
    }

    @Override
    public T peek() {
        if (empty()) {
            throw new RuntimeException("Stack is empty: Cannot peek");
        }
        return top.data;
    }

    @Override
    public boolean empty() {
        return top == null;
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return size;
    }

    @Override
    public void display() {
        System.out.println();
        Node<T> temp = top;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}