import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {

    // Worst approach:
    public int lengthOfLongestSubstring1(String s) {
        if(s.isEmpty() || s.length() == 1){
            return s.length();
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLen = 0;

        int i = 0;
        int j = 0;
        while(i < s.length() && j < s.length()){
            if(map.containsKey(s.charAt(j))){
                int location = map.get(s.charAt(j));
                i = location + 1;
                map = new HashMap<>();
                j = i;
            }else{
                map.put(s.charAt(j), j);
                j++;
                maxLen = Math.max(maxLen, j - i);
            }
        }

        return maxLen;
    }

    // A lil better approach than above:
    public static int lengthOfLongestSubstring2(String s) {
        int result=0;
        HashSet<Character> list = new HashSet<>();
        String sum="";
        for (int i = 0, start=0; i < s.length(); ) {
            if(!list.contains(s.charAt(i))){
                sum += s.charAt(i);
                list.add(s.charAt(i));
                i++;
            }else{
                start = i;
                i = start;
                sum="";
                list = new HashSet<>();
            }
            if(sum.length()>result){
                result=sum.length();
                System.out.println(sum);
            }
        }
        return result;
    }

    // Best approach (Sliding Window): TC:O(N) & SC:O(1)
    public int lengthOfLongestSubstring3(String s) {
        int strLen = s.length();
        int maxLen = 0;
        int[] lastSeen = new int[128];
        for (int i = 0; i < 128; i++) {
            lastSeen[i] = -1;
        }

        int start = 0;
        for (int end = 0; end < strLen; end++) {
            char currentChar = s.charAt(end);
            if (lastSeen[currentChar] >= start) {
                start = lastSeen[currentChar] + 1;
            }
            lastSeen[currentChar] = end;
            maxLen = Math.max(maxLen, end - start + 1);
        }
        return maxLen;
    }
}
