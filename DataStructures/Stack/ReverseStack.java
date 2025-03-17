import java.util.Stack;

public class ReverseStack {
    public static void pushAtBottom(Stack<Integer> stack, int val){
        if(stack.isEmpty()){
            stack.push(val);
            return;
        }

        int top = stack.pop(); // remove the values
        pushAtBottom(stack, val);
        stack.push(top); // restore the values
    }

    public static void reverseStack(Stack<Integer> stack){
        if(stack.isEmpty()){
            return;
        }
        int top = stack.pop();
        reverseStack(stack);
        pushAtBottom(stack, top);
    }

    public static void main(String[] args) {

    }
}

/*
Given stack (Top to Bottom):
1 -> 2 -> 3 -> 4

reverseStack(stack) is called,
    removing 1 and calling reverseStack(stack).
    2 is removed, calling reverseStack(stack).
    3 is removed, calling reverseStack(stack).
    4 is removed, calling reverseStack(stack).
Now the stack is empty, so recursion unwinds.
    pushAtBottom(stack, 4) places 4 at the bottom.
    pushAtBottom(stack, 3) places 3 below 4.
    pushAtBottom(stack, 2) places 2 below 3.
    pushAtBottom(stack, 1) places 1 below 2.

Final Reversed Stack (Top to Bottom):
4 -> 3 -> 2 -> 1
*/
