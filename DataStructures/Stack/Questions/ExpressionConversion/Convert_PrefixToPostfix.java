package Questions.ExpressionConversion;

import java.util.Stack;

public class Convert_PrefixToPostfix {
    public static String prefixToPostfix(String expression) {
        Stack<String> stack = new Stack<>();

        // Scan from right to left
        for (int i = expression.length() - 1; i >= 0; i--) {
            char ch = expression.charAt(i);

            // If operand, push to stack
            if (Character.isLetterOrDigit(ch)) {
                stack.push(Character.toString(ch));
            }
            // If operator, pop two operands and form postfix
            else {
                String operand1 = stack.pop();
                String operand2 = stack.pop();
                String postfix = operand1 + operand2 + ch;
                stack.push(postfix);
            }
        }

        return stack.pop();
    }


    public static void main(String[] args) {
        String prefix = "+-*+abcdf";
        String postfix = prefixToPostfix(prefix);
        System.out.println("Prefix: " + prefix);
        System.out.println("Postfix: " + postfix);
    }
}
