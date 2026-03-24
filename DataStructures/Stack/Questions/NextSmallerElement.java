package Questions;

import java.util.Stack;

public class NextSmallerElement {
    public int[] nextSmaller(int[] arr){
        int[] nse = new int[arr.length];

        Stack<Integer> stack = new Stack<>();

        for(int i = arr.length - 1; i >= 0; i--){
            while(!stack.isEmpty() && arr[stack.peek()] > arr[i]){
                stack.pop();
            }

            if(stack.isEmpty()){
                nse[i] = arr.length;
            }else{
                nse[i] = stack.peek();
            }

            stack.push(i);
        }
        return nse;
    }
}
