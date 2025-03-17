public class StringToInteger {
    public static int myAtoi(String s) {
        long result=0;
        char sign='+';
        int flag=0;
        for (int i = 0; i < s.length(); i++) {

            if(flag==1 && s.charAt(i)==' ')
                break;

            if(s.charAt(i)==' '){
                continue;
            }
            if(s.charAt(i)== '-' || s.charAt(i)=='+'){
                if(flag==1)
                    break;
                sign=s.charAt(i);
                flag=1;
                continue;
            }
            if(s.charAt(i)<'0' || s.charAt(i)>'9')
                break;

            result = result*10 + (s.charAt(i)-'0');
            flag=1;

            if(result > 2147483647)
                return (sign=='+') ? 2147483647 : -2147483648;

        }

        return (sign=='+') ? (int)result : (int)-result;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("   +0 123"));
    }
}
