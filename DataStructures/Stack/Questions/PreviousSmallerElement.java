package Questions;

import java.util.Stack;

public class PreviousSmallerElement {
    public int[] prevSmaller(int[] arr) {
        int[] pse = new int[arr.length];

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < arr.length; i++){
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }

            if(stack.isEmpty()){
                pse[i] = -1;
            }else{
                pse[i] = stack.peek();
            }

            stack.push(i);
        }
        return pse;
    }
}
