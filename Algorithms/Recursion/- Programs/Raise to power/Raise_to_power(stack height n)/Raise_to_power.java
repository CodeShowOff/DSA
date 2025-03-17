public class Raise_to_power{
    static int power(int num, int pow){
        if(pow==1) // or 'if (pow==0) return 1;'
            return num;

        if(num==0) // if num is only 0 then its power will also be 0.
            return 0;
            
        return num * power(num,pow-1);
    }

    public static void main(String[] args) {
        int result= power(2,8);
        System.out.println(result);
    }
}