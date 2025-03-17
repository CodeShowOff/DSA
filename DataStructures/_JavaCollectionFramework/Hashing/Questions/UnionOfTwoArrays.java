import java.util.HashSet;

public class UnionOfTwoArrays {
    public static void main(String[] args) {
        int arr1[]={7,3,9};
        int arr2[]={6,3,9,2,9,4};

        HashSet<Integer> mySet = new HashSet<>();
        for (int i = 0; i < arr1.length; i++) {
            mySet.add(arr1[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            mySet.add(arr2[i]);
        }

        System.out.println(mySet);
    }
    
}