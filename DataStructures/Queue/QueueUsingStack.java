import java.util.Stack;

public class QueueUsingStack {

    // Implementation:1
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> tempStore = new Stack<>();

    public void push(int num){
        int size = stack.size();
        for(int i = 1; i <= size; i++){
            tempStore.push(stack.pop());
        }

        stack.push(num);

        for(int i = 1; i <= size; i++){
            stack.push(tempStore.pop());
        }
    }

    public int pop(){
        return stack.pop();
    }

    public int top(){
        return stack.peek();
    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }
}
