
public class PerfectSquareRoot {

    // Brute force method: time complexity : O(sqrt(N))
    static void findSqrt_1(int num){
        for (int i = 0; i < num/2 ; i++) {
            // if no perfect square root found
            if( i*i > num){
                System.out.println("Not a perfect square.");
                break;
            }

            if(i*i==num){
                System.out.println(i);
                break;
            }
        }
    }

    // Brute force with more optimization by binary search : time complexity: O(log N)
    static void findSqrt_2(int num){
        int start=1;
        int end=num;
        while(start<=end){
            int mid= start + (end-start)/2; 
            if(mid*mid==num){
                System.out.println(mid);
                return;
            }
            if(mid*mid>num){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
    }
    public static void main(String[] args) {
        findSqrt_1(36);
        findSqrt_2(36);
    }
}
