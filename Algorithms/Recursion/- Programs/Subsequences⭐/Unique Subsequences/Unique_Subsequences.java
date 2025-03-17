import java.util.HashSet;

public class Unique_Subsequences {
    //    ex- "aaa"  
    //    its subsequences will be:
    //         aaa
    //         aa_
    //         a_a
    //         a__
    //         _aa
    //         _a_
    //         __a
    //         ___
    //    so its uinque subsequences will be:
    //         aaa
    //         aa
    //         a
    //         _

    static void findSubsequences(String str,int Index, String subsequences, HashSet<String> set){
        if(Index==str.length()){
            if(set.contains(subsequences))
                return;

            System.out.println(subsequences);
            set.add(subsequences);
            return;
        }
        // to be in subsequence:
        findSubsequences(str, Index+1, subsequences+str.charAt(Index), set);

        // to not be in subsequence:
        findSubsequences(str, Index+1, subsequences+"", set);
    }

    public static void main(String[] args) {
        // we need hashset to store only unique elements
        HashSet<String> set = new HashSet<>();
        findSubsequences("aaa", 0, "", set);
    }
} 