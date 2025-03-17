import java.util.ArrayList;
// return the number of occurances as ArrayList.
public class find_occurances {

    static ArrayList<Integer> findOccurances(int[] arr, int Index, int Target, ArrayList<Integer> list){
        if(Index==arr.length){
            return list;
        }

        if(arr[Index]==Target)
            list.add(Index);
        
        return findOccurances(arr, Index+1, Target, list);
    }

    public static void main(String[] args) {
        int[] arr={1,2,3,4,3,5,3};
        ArrayList<Integer> result= findOccurances(arr, 0, 3, new ArrayList<>());
        // here, "new ArrayList<>()" is creating an empty ArrayList of Integer type. 
        // This empty list is then passed to the findOccurances method.
        System.out.println(result);
    }
}

