import java.util.HashMap;
// import java.util.Scanner;

public class MajorityElements {
    public static void main(String[] args) {
        
        int arr[]= {1,3,2,5,1,3,1,5,1,2};

        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if(freq.containsKey(arr[i])){
                freq.put(arr[i], freq.get(arr[i])+1);
            }else{
                freq.put(arr[i], 1);
            }
        }

        // System.out.println(freq);

        for (int i : freq.keySet()) {
            if(freq.get(i)>(arr.length/3)){
                System.out.print(i + " ");
            }
        }
    }
}