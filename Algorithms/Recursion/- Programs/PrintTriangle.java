
public class PrintTriangle {
// * * * *
// * * * 
// * * 
// *
    static void printPattern1(int row, int col){
        if(row==0)
            return;
        
        if(col<row){
            System.out.print("* ");
            printPattern1(row, col+1);
        }
        else{
            System.out.println();
            printPattern1(row-1, 0);
        }

    }

//  *
//  * *
//  * * *
//  * * * *
    static void printPattern2(int row, int col){
        if (row==0)
            return;

        if(col<row){
            printPattern2(row, col+1);
            System.out.print("* ");
        }
        else{
            printPattern2(row-1, 0);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        printPattern1(4,0);
        printPattern2(4, 0);
    }
} 
