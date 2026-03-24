package Questions;

import java.util.Stack;

public class NextGreaterElement {
    public int[] nextGreater(int[] nums){
        int[] nge = new int[nums.length];
        Stack<Integer> stack = new Stack<>();

        for(int i = nums.length - 1; i >= 0; i--){
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i]){
                stack.pop();
            }

            if(stack.isEmpty()){
                nge[i] = nums.length;
            }else{
                nge[i] = stack.peek();
            }
            stack.push(i);
        }

        return nge;
    }
}
