import java.util.LinkedList;
import java.util.Queue;

// Optimised for better push operations:
public class StackUsingQueue3 {
    Queue<Integer> q1;
    Queue<Integer> q2;

    public StackUsingQueue3() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(int x) {
        q1.offer(x);
    }

    public int pop() {
        while (q1.size() > 1) {
            q2.offer(q1.poll());
        }
        int topElement = q1.poll(); // Get last remaining element

        // Swap queues
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return topElement;
    }

    public int top() {
        while (q1.size() > 1) {
            q2.offer(q1.poll());
        }
        int topElement = q1.peek(); // Peek instead of poll

        q2.offer(q1.poll()); // Move it to q2 to maintain order

        // Swap queues
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return topElement;
    }

    public boolean empty() {
        return q1.isEmpty();
    }
}
