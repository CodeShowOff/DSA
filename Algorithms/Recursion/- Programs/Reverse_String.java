public class Reverse_String {
    static String reverseString(String str) {
        if (str.length()==1)
            return str;
            
        //Calling Function Recursively
        return reverseString(str.substring(1)) + str.charAt(0);
    }

    public static void main(String[] args) {
        String str = "madaad";
        String reversed = reverseString(str);
        System.out.println("The reversed string is: " + reversed);
    }
}

// Here’s how the recursion works with an example string “madaad”:

// reverseString(“madaad”) returns reverseString(“adaad”) + ‘m’
// reverseString(“adaad”) returns reverseString(“daad”) + ‘a’
// reverseString(“daad”) returns reverseString(“aad”) + ‘d’
// reverseString(“aad”) returns reverseString(“ad”) + ‘a’
// reverseString(“ad”) returns reverseString(“d”) + ‘a’
// reverseString(“d”) returns “d”
// So, reverseString(“madaad”) ultimately returns “d” + ‘a’ + ‘a’ + ‘d’ + ‘a’ + ‘m’ = “daadam”.