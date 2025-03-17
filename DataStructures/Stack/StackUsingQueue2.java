import java.util.LinkedList;
import java.util.Queue;

// Implemented the first method using two Queues:
public class StackUsingQueue2 {

    Queue<Integer> q1;
    Queue<Integer> q2;

    public StackUsingQueue2() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(int x) {
        q2.offer(x); // Add new element to q2

        // Move all elements from q1 to q2
        while (!q1.isEmpty()) {
            q2.offer(q1.poll());
        }

        // Swap q1 and q2 so q1 always holds the correct stack order
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    public int pop() {
        return q1.poll(); // Directly remove top element
    }

    public int top() {
        return q1.peek(); // Directly get top element
    }

    public boolean empty() {
        return q1.isEmpty();
    }
}
