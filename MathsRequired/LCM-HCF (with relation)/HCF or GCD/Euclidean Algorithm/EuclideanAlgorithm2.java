public class EuclideanAlgorithm2 {
    // More optimised method:
    static int findGCD(int num1, int num2){
        
        while (num1 >0 && num2>0){
            if(num1>num2) 
                num1=num1%num2;
            else 
                num2=num2%num1;
        }
        
        if(num1>0) return num1; // if not this then down one.
        return num2;
    }
    public static void main(String[] args) {
        
        int num1=24;
        int num2=18;

        int result=findGCD(num1, num2);
        System.out.println(result);
    }
}
