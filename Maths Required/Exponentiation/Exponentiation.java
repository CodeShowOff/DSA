// Time Complexity : O(n) ; where n is pow
public class Exponentiation {
    public static void main(String[] args) {
        int num=2;
        int pow=8;

        int result=1;

        while(pow>0){
            result *= num;
            pow--;
        }

        System.out.println(result);
    }
}