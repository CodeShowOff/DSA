
public class TotalMazePath {

    static int count=0;

    static void findPath(int row, int col, int indRow, int indCol){
        if(indRow==row-1 && indCol==col-1){
            count++;
            return;
        }

        if(indRow<row)
            findPath(row, col, indRow+1, indCol);

        if(indCol<col)
            findPath(row, col, indRow, indCol+1);
    }
    
    public static void main(String[] args) {
        int row=5;
        int col=5;
        findPath(row, col, 0, 0);
        System.out.println(count);
    }
}

