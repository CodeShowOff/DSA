public class First_and_Last_Occurance_of_an_element_in_a_string {

    static void countOccurance(String str, char Target, int Index, int First, int Last){
        if(Index>str.length()-1){
            System.out.println("First:"+First+" Last:"+Last);
            return;
        }

        if((str.charAt(Index))=='a'){
            if(First==-1)
                First=Index;
            else
                Last=Index;
        }
        countOccurance(str,Target, Index+1, First, Last);
    }

    public static void main(String[] args) {
        countOccurance("abaacdaefaah", 'a', 0, 0, 0);
    }
}
