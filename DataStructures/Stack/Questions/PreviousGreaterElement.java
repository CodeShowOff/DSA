package Questions;

import java.util.Stack;

public class PreviousGreaterElement {
    public int[] previousGreater(int[] nums){
        int[] pge = new int[nums.length];

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < nums.length; i++){
            while(!stack.isEmpty() && nums[stack.peek()] <= nums[i]){
                stack.pop();
            }

            if(stack.isEmpty()){
                pge[i] = -1;
            }else{
                pge[i] = stack.peek();
            }
            stack.push(i);
        }

        return pge;
    }
}
