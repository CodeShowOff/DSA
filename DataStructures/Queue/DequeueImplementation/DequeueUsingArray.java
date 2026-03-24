package DequeueImplementation;

public class DequeueUsingArray implements Dequeue{
    int[] dequeueArr;
    int front;
    int rear;
    int size;
    int capacity;

    public DequeueUsingArray(int capacity){
        dequeueArr = new int[capacity];
        front = -1;
        rear = -1;
        size = 0;
        this.capacity = capacity;
    }

    @Override
    public void offerFirst(int val) {

    }

    @Override
    public void offerLast(int val) {

    }

    @Override
    public int pollFirst() {
        return 0;
    }

    @Override
    public int pollLast() {
        if(isEmpty()){
            throw new RuntimeException("Dequeue is empty...");
        }
        int data = dequeueArr[rear];

        if(front == rear){
            front = rear = -1;
        }
        else if(rear == 0){

        }
        size--;
        return data;
    }

    @Override
    public int peekFirst() {
        if(isEmpty()){
            throw new RuntimeException("Dequeue is empty...");
        }
        return dequeueArr[front];
    }

    @Override
    public int peekLast() {
        if(isEmpty()){
            throw new RuntimeException("Dequeue is empty...");
        }
        return dequeueArr[rear];
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public boolean isFull() {
        return this.size == this.capacity;
    }
}
