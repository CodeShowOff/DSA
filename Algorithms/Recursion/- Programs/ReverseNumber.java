public class ReverseNumber {
    static int reverseNum(int num, int reversed){
        if(num==0)
            return reversed;

        return reverseNum(num/10, reversed*10+num%10);
    }
    public static void main(String[] args) {
        System.out.println(reverseNum(12345,0));
    }
}
