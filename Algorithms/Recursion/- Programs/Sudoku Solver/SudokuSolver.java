public class SudokuSolver {

    boolean isSafe(char[][] board, int row, int col){
        if(board[row][col]=='*')
            return true;
        return false;
    }
    
    boolean isValid(char[][] board, int row, int col, int i){
        // for horizontal and vertical:
        for (int j = 0; j < board.length; j++) {
            if(board[row][j]==((char)(i+'0')))
                return false;
            if(board[j][col]==((char)(i+'0')))
                return false;
        }
        // for grid:
        int r=row/3*3;
        int c=col/3*3;
        for (int j = r; j < r+3; j++) {
            for (int k = c; k < c+3; k++) {
                if(board[j][k]==((char)(i+'0')))
                    return false;
            }
        }
        return true;
    }

    void solver(char board[][], int row, int col){

        if(col>8){
            row+=1;
            col=0;
        }

        if(row>8){
            printSolution(board);
            return;
        }

        if(isSafe(board, row, col)){
            for (int i = 1; i <= 9; i++) {
                if(isValid(board, row, col, i)){
                    board[row][col]=(char)(i+'0');
                    solver(board, row, col+1);
                    board[row][col]='*';
                }
            }
        }else{
            solver(board, row, col+1);
        }
    }

    void printSolution(char[][] board){
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j]+" ");
                if(j==2 || j==5)
                    System.out.print(" ");
            }
            System.out.println();
            if(i==2 || i==5)
                System.out.println();
        }
    }

    public static void main(String[] args) {
        char board[][] = {{'*','1','*','*','*','*','*','5','7'},
                          {'*','2','*','*','*','*','4','*','*'},
                          {'9','*','5','*','1','2','*','*','8'},
                          {'*','*','*','*','*','6','*','*','*'},
                          {'*','*','7','*','*','8','*','*','3'},
                          {'4','*','*','*','*','5','6','*','*'},
                          {'3','*','6','*','*','9','*','4','*'},
                          {'*','8','2','*','*','*','*','*','*'},
                          {'*','*','*','*','8','*','*','*','*'}};
                          
        SudokuSolver obj = new SudokuSolver();
        obj.solver(board, 0, 0);
    }
}
