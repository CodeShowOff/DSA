// Approach : we'll loop from 1 to num(smallest one) and if any number divides both completely we'll take 
// the number in a variable and proceed for funther check.  

public class GCD_1 {
    public static void main(String[] args) {
        int num1=24;
        int num2=18;

        if(num1>num2){ // making num1 as smaller
            int temp=num2;
            num2=num1;
            num1=temp;
        }
        int result=-1;
        for(int i=1; i<= num1; i++){
            if(num1%i==0 && num2%i==0)
                result=i;
        }

        System.out.println(result);
    }
}
