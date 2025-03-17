public class Print_N_times{
    static void myfun(int count){
        // Halting Condition
        if(count==0)
            return;

        System.out.println("I am Spider-Man!");
        // calling itself
        myfun(--count);
    }
    public static void main(String[] args) {
        myfun(5);
    }
    
}
