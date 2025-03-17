import java.util.HashSet;
import java.util.Iterator;

// Remember that a HashSet:
// Stores unique elements (no duplicates).
// Does not guarantee order (elements are not stored in the order they were added).
// Provides efficient add, remove, and contains operations.

public class HashSet_Notes {
    public static void main(String[] args) {

        // Create a HashSet of integers
        HashSet<Integer> numbersSet = new HashSet<>();

        // Add elements to the HashSet
        numbersSet.add(10);
        numbersSet.add(20);
        numbersSet.add(30);
        numbersSet.add(40);
        numbersSet.add(10); // This wont be added cause its dublicate.

        // Print the HashSet (order may vary)
        System.out.println(numbersSet); // [20, 40, 10, 30] -> unordered



        // Check if an element exists in the HashSet
        int target = 20;
        if (numbersSet.contains(target)) {
            System.out.println(target + " exists in the HashSet.");
        } else {
            System.out.println(target + " does not exist in the HashSet.");
        }


        // Remove an element from the HashSet
        numbersSet.remove(30);
        System.out.println(numbersSet); // [20, 40, 10]


        // Changing an element (remove and add)
        int newNum = 50;
        numbersSet.remove(20);
        numbersSet.add(newNum);
        System.out.println(numbersSet); // [50, 40, 10]



//      Iterate through the HashSet using an Iterator 
//      Since, HashSet has no index concept we use these functions:
//          1. hasNext : returns boolean if there's more elements in the set
//          2. next : gives next element

        Iterator<Integer> iterator = numbersSet.iterator();
        while (iterator.hasNext()) {
            int current = iterator.next();
            System.out.print(current +" "); // 50 40 10
        }
        System.out.println();

//      or we can use this for loop to iterate:
        for(int i : numbersSet){
            System.out.print(i +" ");
        }


        // Size of the HashSet
        System.out.println("Size of the HashSet: " + numbersSet.size());


        // Clear all elements from the HashSet
        numbersSet.clear();
        System.out.println("HashSet after clearing: " + numbersSet);
    }
}