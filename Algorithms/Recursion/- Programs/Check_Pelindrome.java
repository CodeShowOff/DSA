public class Check_Pelindrome {
    static String reverseString(String str) {
        if (str.length()==1)
            return str;
        //Calling Function Recursively
        return reverseString(str.substring(1)) + str.charAt(0);
    }

    public static void main(String[] args) {
        String str = "madam";
        String reversed = reverseString(str);
        boolean isPelindrome = str.equals(reversed);
        System.out.println(isPelindrome);
    }
}