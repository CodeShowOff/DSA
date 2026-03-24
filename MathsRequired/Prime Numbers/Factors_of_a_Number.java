import java.util.ArrayList;

public class Factors_of_a_Number {
    public static void main(String[] args) {
        findFactors(20);
    }

    static void findFactors(int num){
        ArrayList<Integer> list = new ArrayList<>();

        for(int i=1; i*i <= num; i++){
            if(num%i==0){
                System.out.print(i+" ");
                // storing the another half in ArrayList:
                list.add(num/i);
            }
        }
        // printing the ArrayList in reverse:
        for (int i = list.size()-1; i >= 0; i--) {
            System.out.print(list.get(i)+" ");  
        }
    }
}
