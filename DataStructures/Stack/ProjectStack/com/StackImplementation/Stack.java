package ProjectStack.com.StackImplementation;

public interface Stack<T> {

    void push(T val);

    T pop();

    T peek();

    int size();

    boolean empty();

    void display();
}
