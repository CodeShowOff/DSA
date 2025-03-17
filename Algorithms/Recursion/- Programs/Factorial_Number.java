public class Factorial_Number {
    static int factorial(int num){
        if(num==1 || num==0)
            return 1;
        return num * factorial(num-1);
    }
    public static void main(String[] args) {
        int result=factorial(5);
        System.out.println(result);
    }
    
}

