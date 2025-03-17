import java.util.Stack;

public class PushAtTheBottomOfStack {
    public static void pushAtBottom(Stack<Integer> stack, int val){
        if(stack.isEmpty()){
            stack.push(val);
        }

        int currVal = stack.pop();
        pushAtBottom(stack, val);
        stack.push(currVal); // restore the values
    }
}
