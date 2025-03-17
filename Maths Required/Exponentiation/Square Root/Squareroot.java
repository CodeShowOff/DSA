// find imperfect square root i.e. with decimal precision;
public class Squareroot {
    static double findSQRT(int num, int precision){
        double root = 0.0d;

        // binary search to find integer place:
        int start = 1;
        int end = num;
        while(start<=end){
            int mid= start + (end-start)/2; 

            if(mid*mid==num){ // its a perfect square return this mid.
                return mid;
            }

            if(start==mid){
                root=mid;
            }

            if(mid*mid>num){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }

        // to find the decimal place:
        double decimalPlace=0.1d;

        for(int i=1; i<= precision; i++){

            while(root*root <= num){
                root += decimalPlace;
            }
            root -= decimalPlace; // because one extra incremnt has been done
            decimalPlace=decimalPlace/10; // i.e. 0.1/10 = 0.01
        }
        
        return root;
    }

    public static void main(String[] args) {
        double result= findSQRT(36, 3);
        System.out.printf("%.3f",result);
    }
}
