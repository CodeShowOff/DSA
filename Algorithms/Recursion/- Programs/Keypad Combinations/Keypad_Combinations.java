
import java.util.ArrayList;
import java.util.List;

// Approach-1:
public class Keypad_Combinations {

    static String keypad[]={".","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    static void printCombinations(String number, int Index, String combinations){
        if(Index==number.length()){
            System.out.println(combinations);
            return;
        }

        char currNum=number.charAt(Index);
        String letters=keypad[currNum-'0']; // currNum-'0' to get the corresponding characters of that digit
        
        for (int i = 0; i < letters.length(); i++) {
            printCombinations(number, Index+1, combinations + letters.charAt(i));
        }
    }

    public static void main(String[] args) {
        printCombinations("23", 0, "");
    }
}

// Approach-2 : Same as Approach-1 but more Optimised due to usage of StringBuilder:
class Solution {
    static String[] words = {".", " ", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> myList = new ArrayList<>();
        if (digits.isEmpty()) return myList;

        solve(digits, 0, new StringBuilder(), myList);
        return myList;
    }

    public void solve(String digits, int idx, StringBuilder comb, List<String> myList){
        if (idx == digits.length()) {
            myList.add(comb.toString());
            return;
        }

        String word = words[digits.charAt(idx) - '0'];
        
        for (int i = 0; i < word.length(); i++) {
            comb.append(word.charAt(i));   // Add character
            solve(digits, idx + 1, comb, myList);
            comb.deleteCharAt(comb.length() - 1);  // Backtrack
        }
    }
}
