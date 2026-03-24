// FInd a,b,c such that a*b*c=num and a,b,c are all different and none can be 1.
public class Product_of_three_numbers {
    public static void main(String[] args) {
        int num=98;

        int a=1, b=1, c=1;

        for(int i=2; i*1<=num; i++){
            if(num%i==0){
                a=i; // this gives the smallest factor, a.
                break;
            }
        }

        num=num/a;

        for(int i=2; i*i<=num; i++){
            if(num%i == 0 && i != a){ // because 'b' cannot be equal to 'a'
                b=i; // this gives the another smallest factor b.
                break;
            }
        }

        c= num/b; // now the left factor will be num/(a*b) since a has been already divided so just divide by b.

        if(a!=b && b!= c && a!=c && c!= 1 && b!=1)
            System.out.println(a+" "+b+" "+c);
        else    
            System.out.println("Not Possible");

    }
    
}