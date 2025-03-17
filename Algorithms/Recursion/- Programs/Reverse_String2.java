public class Reverse_String2 {
    static void Reverse_String(String str, int index){
        if(index==-1)
            return;
        
        System.out.print(str.charAt(index));
        Reverse_String(str, index-1);
    } 
    public static void main(String[] args) {
        Reverse_String("abcde", "abcde".length()-1);
    }
}
