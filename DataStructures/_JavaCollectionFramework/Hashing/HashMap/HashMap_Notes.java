import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* 
1. put(K key, V value): Adds a key-value pair to the map. If the key already exists, the value is updated.

2. get(Object key): Retrieves the value associated with the specified key. Returns null if the key is not found.

3. containsKey(Object key): Checks if the map contains a specific key. Returns true if the key exists, otherwise false.

4. remove(Object key): Removes the key-value pair associated with the given key.

5. size(): Returns the number of key-value mappings in the map.

6. clear(): Removes all key-value pairs from the map.
*/
public interface HashMap_Notes {
    public static void main(String[] args) {
        
        // Creation
        HashMap<String, Integer> population = new HashMap<>();

        // Insertion key-value pairs
        population.put("India", 120);
        population.put("US", 30);
        population.put("China", 150);

        // Printing all the key and values
        System.out.println(population); // {China=150, US=30, India=120}

        System.out.println(population.keySet()); // [China, US, India]
        System.out.println(population.values()); // [150, 30, 120]


        // Since key already exist, updates its value
        population.put("China", 140);
        System.out.println(population); // {China=140, US=30, India=120}


        // Retrieve value for a key
        int indiaPopulation = population.get("India");
        System.out.println("India's Population: " + indiaPopulation); // India's Population: 120

        //Removing a key
        population.remove("China");
        System.out.println(population); // {US=30, India=120}


        // Searching for specific key
        if(population.containsKey("India")) {
            System.out.println("key is present");
        } else {
            System.out.println("key is not present");
        }


        // Iteration-1
        for( Map.Entry<String, Integer> entry : population.entrySet()) {
            System.out.println(entry.getKey() +" "+ entry.getValue());
        }

        // Iteration-1-a
        for(Map.Entry<String, Float> entry : population.entrySet()){
            System.out.println(entry);
        }

        // Iteration-1-b
        for(Map.Entry<String, Float> entry : population.entrySet()){
            String name = entry.getKey();
            Float marks = entry.getValue();
            System.out.println(name + " " + marks);
        }


        // Iteration-2
        Set<String> keys = population.keySet();
        for(String key : keys) {
            System.out.println(key+ " " + population.get(key));
        }

        // Iteration-2-a
        for(String key : population.keySet()) {
            System.out.println(key+ " " + population.get(key));
        }



        Set<String> name = student.keySet();
        Collection<Float> grade = student.values();
        /*
        Using a Set for keys and a Collection for values in a HashMap provides several advantages:
        1. Set for Keys:
            Uniqueness: A Set inherently ensures that all keys are unique. This is important in a HashMap, as each key should map to only one value.
            Efficient Lookup: Operations like checking if a key exists are efficient in a Set, which can improve performance in scenarios where you need to verify the presence of a key.
        2. Collection for Values:
            Flexibility: A Collection allows for more flexibility with the values. You can easily iterate through all the values without needing to pair them with keys.
            Diverse Operations: Using a Collection provides access to various methods for manipulation (like filtering, transforming, etc.) that can be useful when working with just the values.
         */

    }
}
