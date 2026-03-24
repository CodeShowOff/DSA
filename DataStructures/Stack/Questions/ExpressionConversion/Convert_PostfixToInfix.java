package Questions.ExpressionConversion;

import java.util.Stack;

public class Convert_PostfixToInfix {

    public static String postfixToInfix(String expression){
        Stack<String> stack = new Stack<>();

        for (char ch : expression.toCharArray()) {
            // If operand, push to stack
            if (Character.isLetterOrDigit(ch)) {
                stack.push(Character.toString(ch));
            }
            // If operator, pop two operands and combine
            else {
                String right = stack.pop();
                String left = stack.pop();
                String subExpr = "(" + left + ch + right + ")";
                stack.push(subExpr);
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        String postfix = "ab+c*d-f+";
        String infix = postfixToInfix(postfix);
        System.out.println("Postfix: " + postfix);
        System.out.println("Infix: " + infix);
    }
}
