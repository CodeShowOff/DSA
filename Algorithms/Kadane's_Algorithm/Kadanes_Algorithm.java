public class Kadanes_Algorithm {
    public static void main(String[] args) {

        int[] myArray={-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int result;

        // Kadanes Algorithm
        // Complexity O(N):
        result= Kadanes_Algorithm_1.Algorithm_1(myArray);

        // Complexity O(N^2):
        // result= Kadanes_Algorithm_2.Algorithm_2(myArray);

        // Complexity O(N^3):
        // result= Kadanes_Algorithm_3.Algorithm_3(myArray);
        
        System.out.println(result);
    }
}

// Kadanes Algorithm
class Kadanes_Algorithm_1{
    static int Algorithm_1(int myArray[]){
        int sum=0;
        int maxi=myArray[0];
        for (int i = 0; i < myArray.length; i++) {
            sum+=myArray[i];
            
            if(sum>maxi)
                maxi=sum;

            if(sum<0)
                sum=0;
        }
        return maxi;
    }
}

class Kadanes_Algorithm_2{
    static int Algorithm_2(int myArray[]){
        int sum;
        int maxi=myArray[0];
        for (int i = 0; i < myArray.length; i++) {
            sum=0;
            for (int j=i; j < myArray.length; j++){
                sum+=myArray[j];
                if(maxi<sum)
                    maxi=sum;
            }
        }
        return maxi;
    }
}

class Kadanes_Algorithm_3{
    static int Algorithm_3(int myArray[]){
        int sum=0;
        int maxi=myArray[0];
        for (int i = 0; i < myArray.length; i++) {
            for (int j=i; j < myArray.length; j++){
                sum=0;
                for (int k = i; k <=j ; k++) {
                    // To print all the sub-array:
                    //System.out.print(myArray[k]+" "); --> Use applicable line brakes

                    sum+=myArray[k];
                }
                if(sum>maxi)
                    maxi=sum;
            }
        }
        return maxi;
    }
}
