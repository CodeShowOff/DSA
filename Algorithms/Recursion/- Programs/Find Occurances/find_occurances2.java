import java.util.ArrayList;
// return the number of occurances as ArrayList but without passing the ArrayList as argument
public class find_occurances2{

    static ArrayList<Integer> findOccurrences(int[] arr, int index, int target) {
        ArrayList<Integer> list = new ArrayList<>();
        
        // Base case: if index is out of bounds, return empty list
        if (index == arr.length) {
            return list;
        }
        
        // If the current element matches the target, add the index to the list
        if (arr[index] == target) {
            list.add(index);
        }
        
        // Recursive call for the next element
        ArrayList<Integer> resultList = findOccurrences(arr, index + 1, target);
        
        // Merge current list with result from recursive call
        list.addAll(resultList);
        
        return list;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 3, 5, 3};
        ArrayList<Integer> result = findOccurrences(arr, 0, 3);
        System.out.println(result);
    }
}

// In this version:

// The findOccurrences method creates a new ArrayList<Integer> at each call.
// It checks if the current element matches the target and adds its index to the list if it does.
// It then makes a recursive call to itself with the next index.
// The result of this recursive call is another list which is merged with the current list using addAll.
// The merged list is returned up the call stack.
// The base case returns an empty list when the index is beyond the array length.
// This approach ensures that each recursive call has its own list that it works with and 
// merges results as the recursion unwinds.