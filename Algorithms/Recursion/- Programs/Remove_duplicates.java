public class Remove_duplicates {
    static boolean check[]=new boolean[26];

    static void removeDupli(String str, int Index, String newString){
        if(Index==str.length()){
            System.out.println(newString);
            return;
        }

        int checkIndex=str.charAt(Index)-'a';

        if(check[checkIndex]==true)
            removeDupli(str, Index+1, newString);
        else{
            check[checkIndex]=true;
            newString+=str.charAt(Index);
            removeDupli(str, Index+1, newString);
        }
    }
    
    public static void main(String[] args) {
        removeDupli("abbccda", 0, "");
    }
}
