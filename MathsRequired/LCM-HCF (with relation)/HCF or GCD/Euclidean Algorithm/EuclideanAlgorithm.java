// still this code isnt much optimised...
public class EuclideanAlgorithm {
    // recursive method:
    static int findGCD(int num1, int num2){
        if(num1==num2)
            return num1;
        
            if(num1>num2) num1=num1-num2;
            else num2=num2-num1;
            
        return findGCD(num1, num2);
    }

    // direct method:
    static int findGCD2(int num1, int num2){

        while (num1 >0 && num2>0){
            if(num1>num2) num1=num1-num2;
            else num2=num2-num1;
        }
        
        if(num1>0) return num1; // if not this then down one.
        return num2;
    }

    public static void main(String[] args) {
        int num1=52;
        int num2=10;

        int result= findGCD(num1, num2);
        System.out.println(result);

        int result2= findGCD2(num1, num2);
        System.out.println(result2);
    }
}
