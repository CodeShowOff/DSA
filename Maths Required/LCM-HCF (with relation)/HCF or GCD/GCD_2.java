// checking from back:
public class GCD_2 {
    public static void main(String[] args) {
        int num1=24;
        int num2=18;

        if(num1>num2){ // making num1 as smaller
            int temp=num2;
            num2=num1;
            num1=temp;
        }
        int result=-1;
        for(int i=num1; i>= 1; i--){
            if(num1%i==0 && num2%i==0){
                result=i; 
                break; // because we'll get the largest number in first time only.
            }
        }
        System.out.println(result);
    }
}

