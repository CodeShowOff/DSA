public class PrimeFactorization {
    public static void main(String[] args) {
        int num=36;

        // To find prime factorization:
        for(int i=2; i<=num; i++){
            if(num%i==0){
                System.out.print(i+" ");
                num=num/i;
                i--;
            }
        }
        if(num>1)
            System.out.println(num);
    }
}
