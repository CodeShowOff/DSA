// Total permutations of a string of len 'n' is given by = n!

public class Permutation {

    static void printPermutations(String str, String Permutation){
        if(str.length() == 0){ // or if(Permutation.length()==3)
            System.out.println(Permutation);
            return;
        }  
        
        for (int i = 0; i < str.length(); i++) {
            char currentChar= str.charAt(i);
            String leftString= str.substring(0, i) + str.substring(i+1);
            printPermutations(leftString, Permutation+currentChar);
        }
    }

    public static void main(String[] args) {
        printPermutations("abc", "");
    }
    
}