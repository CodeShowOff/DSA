public class Print_1_to_N {
    static void print_1toN(int n){
        if(n==0)
            return;
        print_1toN(n-1);
        System.out.print(n+" ");
    }
    public static void main(String[] args) {
        print_1toN(10);
    }
}
