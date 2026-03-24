import java.util.Stack;

public class ReverseStringUsingStack {
    public static String reverseString(String str){
        Stack<Character> stack = new Stack<>();
        for(char ch: str.toCharArray()){
            stack.push(ch);
        }

        StringBuilder result = new StringBuilder();
        while(!stack.isEmpty()){
            result.append(stack.pop());
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String str = "Hello Baby";
        System.out.println(reverseString(str));
    }
}
