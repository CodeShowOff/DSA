package Questions.ExpressionConversion;

import java.util.Stack;

public class Convert_InfixToPrefix {
    /*
        Steps:
            1. Reverse the infix expression
            2. Swap '(' with ')' and vice versa
            3. Convert to postfix
            4. Reverse the result to get prefix
    */
    public static String InfixToPrefix(String expression) {
        // Step 1: Reverse the expression
        String reversedExpression = reverse(expression);

        // Step 2: Swap brackets
        reversedExpression = swapBrackets(reversedExpression);

        // Step 3: Convert to postfix
        String postfix = infixToPostfix(reversedExpression);

        // Step 4: Reverse postfix to get prefix
        return reverse(postfix);
    }

    static String reverse(String str) {
        char[] chrArr = str.toCharArray();
        int i = 0;
        int j = chrArr.length - 1;
        while (i < j) {
            char temp = chrArr[i];
            chrArr[i] = chrArr[j];
            chrArr[j] = temp;
            i++;
            j--;
        }
        return new String(chrArr);
    }

    static String swapBrackets(String expr) {
        StringBuilder result = new StringBuilder();
        for (char ch : expr.toCharArray()) {
            if (ch == '(')
                result.append(')');
            else if (ch == ')')
                result.append('(');
            else
                result.append(ch);
        }
        return result.toString();
    }

    static int precedence(char ch) {
        return switch (ch) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            case '^' -> 3;
            default -> -1;
        };
    }

    static String infixToPostfix(String expression) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char ch : expression.toCharArray()) {
            // Operand
            if (Character.isLetterOrDigit(ch)) {
                result.append(ch);
            }
            // Left Parenthesis
            else if (ch == '(') {
                stack.push(ch);
            }
            // Right Parenthesis
            else if (ch == ')') {
                while (stack.peek() != '(') {
                    result.append(stack.pop());
                }
                stack.pop(); // Remove '(' from stack
            }
            // Operator
            else {
                if(ch == '^') {
                    while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(ch)) {
                        result.append(stack.pop());
                    }
                    stack.push(ch);
                }
                else {
                    while (!stack.isEmpty() && precedence(stack.peek()) > precedence(ch)) {
                        result.append(stack.pop());
                    }
                    stack.push(ch);
                }
            }
        }

        // Pop remaining operators
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }

    // Example usage
    public static void main(String[] args) {
        String infix = "(a+b)*c-d+f";
        String prefix = InfixToPrefix(infix);
        System.out.println("Infix: " + infix);
        System.out.println("Prefix: " + prefix);
    }
}
