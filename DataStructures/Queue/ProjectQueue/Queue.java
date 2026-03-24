package ProjectQueue;

public interface Queue<T>{
    void offer(T data);
    T poll();
    T peek();
    int isEmpty();
}
