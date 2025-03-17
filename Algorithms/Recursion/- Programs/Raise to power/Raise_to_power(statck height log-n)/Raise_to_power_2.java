public class Raise_to_power_2 {
    // stack height log-n
    static int power(int num, int pow){
        if(pow==1)
            return num;

        if(num==0) // if num is only 0 then its power will also be 0.
            return 0;

        // for even
        if(pow%2==0)    
            return power(num,pow/2) * power(num,pow/2);

        // for odd
        else   
            return power(num,pow/2) * power(num,pow/2) * num; 
            // note: this will run for one time only at starting when the 'pow' will be odd
            //       cause after that interger division of that odd number by 2 will give even number
            //       due to which afterwards 'if' condition will only work. so extra multiplication
            //       of num will be in first call only not everytime which will adjust the one extra 
            //       requirement of 'num' multiplication for odd cause even+1=odd.

    }

    public static void main(String[] args) {
        int result= power(2,5);
        System.out.println(result);
    }
}