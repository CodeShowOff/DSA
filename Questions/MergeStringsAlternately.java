public class MergeStringsAlternately {

    // Solution-1;
    public String mergeAlternately(String word1, String word2) {
        String result = "";
        int i = 0;
        int j = 0;
        while(i < word1.length() && j < word2.length()){


            result += word1.charAt(i);

            result += word2.charAt(j);


            i++;
            j++;
        }
        while( i < word1.length()){
            result += word1.charAt(i);
            i++;
        }
        while( j < word2.length()){
            result += word2.charAt(j);
            j++;
        }

        return result;
    }

    // Solution-2 : Optimized:
    public String mergeAlternately2(String word1, String word2) {
        /*
        Algo:
        - use two pointers start from first char in both input strings
        - merge and store char by char into a new string
        */

        StringBuilder mergedStr = new StringBuilder();
        int len1 = word1.length();
        int len2 = word2.length();

        int i=0;
        int j=0;

        while (i < len1 || j < len2){
            if (i < len1){
                mergedStr.append(word1.charAt(i));
                i++;
            }
            if (j < len2){
                mergedStr.append(word2.charAt(j));
                j++;
            }
        }
        return mergedStr.toString();


    }
}