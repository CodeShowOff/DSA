class TotalMazePath2{
    static int findPath(int row, int col, int indRow, int indCol){
        if(indRow==row || indCol==col)
            return 0;

        if(indRow==row-1 && indCol==col-1)
            return 1;

        
        int downPaths=findPath(row, col, indRow+1, indCol);

        int rightPaths=findPath(row, col, indRow, indCol+1);

        return downPaths+rightPaths;
    }
    
    public static void main(String[] args) {
        int row=5;
        int col=5;
        int result= findPath(row, col, 0, 0);
        System.out.println(result);
    }
}