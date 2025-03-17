public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        solver(board, 0, 0);
    }
    public boolean isSafe(char[][] board, int row, int col){
        if(board[row][col]=='.')
            return true;
        return false;
    }

    public boolean isValid(char[][] board, int row, int col, int i){
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

    public boolean solver(char board[][], int row, int col){

        if(col>8){
            row+=1;
            col=0;
        }

        if(row>8){
            return true;
        }

        if(isSafe(board, row, col)){
            for (int i = 1; i <= 9; i++) {
                if(isValid(board, row, col, i)){
                    board[row][col]=(char)(i+'0');
                    if(solver(board, row, col+1))
                        return true;
                    else
                        board[row][col]='.';
                }
            }
        }else{
            return solver(board, row, col+1);
        }
        return false;
    }

}
