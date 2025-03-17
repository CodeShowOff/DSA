import java.util.HashMap;
public class ItineraryFromTickets {
    public static void main(String[] args) {
        HashMap<String, String> tickets = new HashMap<>();
        tickets.put("Chennai", "Banglore");
        tickets.put("Mumbai", "Delhi");
        tickets.put("Goa", "Chennai");
        tickets.put("Delhi", "Goa");


        // Finding the start point: 
        // First Creating reverse of ticket map:
        HashMap<String, String> reverseMap = new HashMap<>();
        for (String key : tickets.keySet()) {
            reverseMap.put(tickets.get(key), key);
        }
        // Now finding the start point:
        String start=null;
        for (String key : tickets.keySet()) {
            if( ! reverseMap.containsKey(key)){
                start=key;
                break;
            }
        }

        // now printing the route:
        while (tickets.containsKey(start)) {
            System.out.print(start + " -> ");
            start=tickets.get(start);
        }
        System.out.println(start);

    }
}
/*
Explanation:
Your Java code is an implementation of finding the itinerary from a set of tickets. Let's break down the logic step by step:

1. **Ticket Mapping:**
    - You've created a `HashMap` called `tickets` to store the source and destination cities.
    - Each entry in the `tickets` map represents a ticket from one city to another. For example:
        - `"Chennai" -> "Bangalore"`
        - `"Mumbai" -> "Delhi"`
        - `"Goa" -> "Chennai"`
        - `"Delhi" -> "Goa"`

2. **Finding the Start Point:**
    - To find the start point, you create a reverse map called `reverseMap`.
    - In this reverse map, the keys are the destinations (values from the original `tickets` map), and the values are the corresponding sources (keys from the original `tickets` map).
    - You iterate through the original `tickets` map and populate the `reverseMap`.
    - The start point will be the city that doesn't appear as a destination in the `reverseMap`.

3. **Printing the Route:**
    - Once you have the start point, you print the route by following the connections from one city to another.
    - You use a `while` loop:
        - Print the current city.
        - Update the current city to the next destination using `tickets.get(start)`.
        - Repeat until there's no more destination for the current city.
    - Finally, print the last city in the route.

Your code should produce output like this (assuming the provided ticket data):

```
Mumbai -> Delhi -> Goa -> Chennai -> Bangalore
```

Great job! If you have any further questions or need additional clarification, feel free to ask! 😊
 */