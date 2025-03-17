public class Combinations{

    static void printCombinations(String str, int index, String Combination){
        if(index==str.length()){
            System.out.println(Combination);
            return;
        }  
        
        for (int i = 0; i < str.length(); i++) {
            printCombinations(str, index+1, Combination+str.charAt(i));
        }
    }
    public static void main(String[] args) {
        printCombinations("abc", 0, "");
    }
}