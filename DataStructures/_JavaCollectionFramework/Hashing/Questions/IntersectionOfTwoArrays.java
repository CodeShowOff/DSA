import java.util.HashSet;

public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        int arr1[]={7,3,9,4};
        int arr2[]={6,3,9,2,9,4};

        HashSet<Integer> mySet = new HashSet<>();
        for (int i = 0; i < arr1.length; i++) {
            mySet.add(arr1[i]);
        }

        // System.out.println(mySet);

        for (int i = 0; i < arr2.length; i++) {
            if(mySet.contains(arr2[i])){
                System.out.print(arr2[i] +" ");
                mySet.remove(arr2[i]);
            }
        }
    }
}