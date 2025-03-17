public class Sum_of_factors {
    public static void main(String[] args) {
        int num=32;
        int sum=0;

        // finding sum till sqrt(num) only:
        for(int i=1; i*i<=num; i++){
            if(num%i==0){
                sum+=i;

                // this condition is for numbers after sqrt(num) because 'num' will have factors ahead also.
                // condition : if i=3, then 3*12=36 so 12*3=36 also: so we already added 3 and to add this 12 also at same time:
                if(num/i != i) // it will be false when i=6, because 6*6  comes only once, so no need to count that.
                    sum+=num/i; // if i=3, then above 3 is already added but we need to add 12 also because 3*12=36
                                // so "num/i" i.e. 36/3=12. so "sum+=num/i" will add 12 also and so on for other factors.
            }
                
        }

        System.out.println(sum);
    }
}
