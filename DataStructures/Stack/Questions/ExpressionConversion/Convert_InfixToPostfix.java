package Questions.ExpressionConversion;
import java.util.Stack;

public class Convert_InfixToPostfix {

    private static int precedence(char ch) {
        return switch (ch) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            case '^' -> 3; // Exponentiation has the highest precedence
            default -> -1;
        };
    }

    public static String infixToPostfix(String expression) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            // If the character is an operand (letter or digit), add it to output
            if (Character.isLetterOrDigit(ch)) {
                result.append(ch);
            }
            // If the character is '(', push to stack
            else if (ch == '(') {
                stack.push(ch);
            }
            // If the character is ')', pop until '(' is found
            else if (ch == ')') {
                while (stack.peek() != '(') {
                    result.append(stack.pop());
                }
                stack.pop(); // Remove '(' from stack
            }
            // If the character is an operator
            else {
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(ch)) {
                    result.append(stack.pop());
                }
                stack.push(ch);
            }
        }

        // Pop all remaining operators in stack
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String infix = "a+b*(c^d-e)";
        System.out.println("Infix: " + infix);
        System.out.println("Postfix: " + infixToPostfix(infix));
    }

}

/*
### **Algorithm for Infix to Postfix Conversion (Shunting Yard Algorithm)**

1. **Initialize:**
   - Create an empty **stack** (to hold operators and parentheses).
   - Create an empty **output string** (to store the final postfix expression).

2. **Process each character in the infix expression:**
   - **If the character is an operand (A-Z, 0-9):**
     - Add it directly to the **output**.
   - **If the character is an operator (+, -, *, /, ^):**
     - While there’s an operator on top of the stack with **higher or equal precedence**,
       - Pop it from the stack and add it to the **output**.
     - Push the current operator onto the **stack**.
   - **If the character is `(` (opening parenthesis):**
     - Push it onto the **stack**.
   - **If the character is `)` (closing parenthesis):**
     - Pop operators from the stack and add them to the **output** until `(` is found.
     - Remove `(` from the stack (but don’t add it to the output).

3. **After reading the expression:**
   - Pop all remaining operators from the **stack** and add them to the **output**.

*/
