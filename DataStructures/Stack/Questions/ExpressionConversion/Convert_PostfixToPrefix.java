package Questions.ExpressionConversion;

import java.util.Stack;

public class Convert_PostfixToPrefix {

    public static String postfixToPrefix(String expression) {
        Stack<String> stack = new Stack<>();

        for (char ch : expression.toCharArray()) {
            // If operand, push to stack
            if (Character.isLetterOrDigit(ch)) {
                stack.push(Character.toString(ch));
            }
            // If operator, pop two operands and form prefix
            else {
                String right = stack.pop();
                String left = stack.pop();
                String prefix = ch + left + right;
                stack.push(prefix);
            }
        }

        return stack.pop();
    }

    public static void main(String[] args){
        String postfix = "ab+c*d-f+";
        String prefix = postfixToPrefix(postfix);
        System.out.println("Postfix: " + postfix);
        System.out.println("Prefix: " + prefix);
    }
}
