package Questions.ExpressionConversion;

import java.util.Stack;

public class Convert_PrefixToInfix {

    public static String prefixToInfix(String expression) {
        Stack<String> stack = new Stack<>();

        // Scan from right to left
        for (int i = expression.length() - 1; i >= 0; i--) {
            char ch = expression.charAt(i);

            // If operand, push to stack
            if (Character.isLetterOrDigit(ch)) {
                stack.push(Character.toString(ch));
            }
            // If operator, pop two operands, form expression, push back
            else {
                String left = stack.pop();
                String right = stack.pop();
                String subExpr = "(" + left + ch + right + ")";
                stack.push(subExpr);
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        String prefix = "+-*+abcdf";
        String infix = prefixToInfix(prefix);
        System.out.println("Prefix: " + prefix);
        System.out.println("Infix: " + infix);
    }
}
