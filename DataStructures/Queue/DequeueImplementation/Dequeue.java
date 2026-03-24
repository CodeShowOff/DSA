package DequeueImplementation;

public interface Dequeue {
    void offerFirst(int val);
    void offerLast(int val);
    int pollFirst();
    int pollLast();
    int peekFirst();
    int peekLast();
    boolean isEmpty();
    boolean isFull();
}
