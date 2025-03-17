import java.util.Stack;

public class QueueUsingStack2 {
    // Method:2 (Not Optimised)
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> tempStore = new Stack<>();

    public void push(int num){
        stack.push(num);
    }

    public int pop(){
        while(!stack.isEmpty()){
            tempStore.push(stack.pop());
        }

        int num =  tempStore.pop();

        while(!tempStore.isEmpty()){
            stack.push(tempStore.pop());
        }

        return num;
    }

    public int top(){
        while(!stack.isEmpty()){
            tempStore.push(stack.pop());
        }

        int num =  tempStore.peek();

        while(!tempStore.isEmpty()){
            stack.push(tempStore.pop());
        }

        return num;
    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }
}
