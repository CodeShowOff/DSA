public class Subsequences {
    static void findSubsequences(String str,int Index, String subsequences){
        if(Index==str.length()){
            System.out.println(subsequences);
            return;
        }
        // to be in subsequence:
        findSubsequences(str, Index+1, subsequences+str.charAt(Index));

        // to not be in subsequence:
        findSubsequences(str, Index+1, subsequences+"_");
    }

    public static void main(String[] args) {
        findSubsequences("abc", 0, "");
    }
}