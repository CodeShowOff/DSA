public class QueueUsingArray {
    // Circular Queue:
    static class Queue {
        int[] queueArr;
        int start, end, currSize, maxSize;

        public Queue() {
            this(100);
        }

        public Queue(int maxSize) {
            this.maxSize = maxSize;
            queueArr = new int[maxSize];
            start = -1;
            end = -1;
            currSize = 0;
        }

        public void push(int newElement) {
            if (currSize == maxSize) {
                System.out.println("Queue is full\nExiting...");
                System.exit(1);
            }
            if (end == -1) {
                start = 0;
                end = 0;
            }
            else end = (end + 1) % maxSize;

            queueArr[end] = newElement;
            currSize++;
        }

        public int pop() {
            if (start == -1) {
                System.out.println("Queue Empty\nExiting...");
                System.exit(1);
            }
            int popped = queueArr[start];
            if (currSize == 1) {
                start = -1;
                end = -1;
            }
            else start = (start + 1) % maxSize;

            currSize--;
            return popped;
        }

        public int top() {
            if (start == -1) {
                System.out.println("Queue is Empty");
                System.exit(1);
            }
            return queueArr[start];
        }

        public int size() {
            return currSize;
        }
    }

    public static void main(String[] args) {
        Queue myQueue = new Queue();

        myQueue.push(10);
        myQueue.push(11);
        myQueue.push(12);
        System.out.println(myQueue.pop());
        System.out.println(myQueue.size());
    }
}

