public class Print_N_to_1 {
    static void print_nto1(int n){
        if(n==0)
            return;
        System.out.print(n+" ");
        print_nto1(n-1);
    }
    public static void main(String[] args) {
        int n=10;
        print_nto1(n);
    }
}
