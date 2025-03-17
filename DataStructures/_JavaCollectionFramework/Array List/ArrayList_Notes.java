// To create an ArrayList we need to import:
import java.util.ArrayList;
// To use sort() method we need to import:
import java.util.Collections;

public class ArrayList_Notes {
    public static void main(String[] args) {
        
        // Syntax:
        // ArrayList<Type> arrayList= new ArrayList<>();

        // create Integer type arraylist:
        // ArrayList<Integer> integerList = new ArrayList<>();

        // create String type arraylist:
        // ArrayList<String> stringList = new ArrayList<>();


        // A general ArrayList for understanding and performing some operations:
        ArrayList<Integer> list = new ArrayList<>();

        // To add elements:
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        // To print ArrayList:
        System.out.println(list); // [1, 2, 3, 4, 5]


        // To add element at specified index:
        list.add(1,8);
        System.out.println(list); // [1, 8, 2, 3, 4, 5]


        // To access an element:
        int ele = list.get(1);
        System.out.println(ele); // 8


        // To change elements:
        list.set(1,9);
        System.out.println(list); // [1, 9, 2, 3, 4, 5]


        // To remove an element: using index:
        list.remove(1);
        System.out.println(list); // [1, 2, 3, 4, 5]


        list.add(2,15);
        System.out.println(list); // [1, 2, 15, 3, 4, 5]


        // To remove an element: using value:
        list.remove(Integer.valueOf(15));
        System.out.println(list); // [1, 2, 3, 4, 5]


        // To find size of ArrayList:
        int size = list.size();
        System.out.println(size); // 5


        // To iterate on ArrayList:
        for(int i=0; i<list.size(); i++) {
            System.out.print(list.get(i) + " "); // 1 2 3 4 5 
        }
        System.out.println();


        // Unsorting first to later sort the list:
        list.add(3,6);
        list.add(2,7);
        System.out.println(list); // [1, 2, 7, 3, 6, 4, 5]


        // To sort the list:
        Collections.sort(list);
        System.out.println(list); // [1, 2, 3, 4, 5, 6, 7]


        // To get the sub-list:
        System.out.println(list.subList(2, 4)); // [3, 4]

//      Other operations:
//      clone()	: Creates a new arraylist with the same element, size, and capacity.
//      contains() : Searches the arraylist for the specified element and returns a boolean result.
//      ensureCapacity() : Specifies the total element the arraylist can contain.
//      isEmpty() : Checks if the arraylist is empty.
//      indexOf() : Searches a specified element in an arraylist and returns the index of the element.
    }
}