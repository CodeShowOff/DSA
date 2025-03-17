/*
We need to find that one place in each column where queens can survive because there can be only one
queen in each column or row so for every queen there need to be different columns as size of board and no of 
queens are similar i.e. 'n'.
 */
public class nQueens {

    // To find the valid positions:
    boolean isValid(int row, int col, char[][] board){
        // for horizontal:
        for (int i = 0; i < board.length; i++) {
            if(board[row][i]=='Q')
                return false;
        }

        // for vertical:
        for (int i = 0; i < board.length; i++) {
            if(board[i][col]=='Q')
                return false;
        }

        // for upper left corner:
        int r= row;
        for (int i = col; i>=0 && r>=0 ; i--, r--) {
            if(board[r][i]=='Q')
                return false;
        }

        // for lower right corner:
        r= row;
        for (int i = col; i < board.length && r < board.length ; i++, r++) {
            if(board[r][i]=='Q')
                return false;
        }

        // for upper right corner:
        r= row;
        for (int i = col; i < board.length && r>=0; i++, r--) {
            if(board[r][i]=='Q')
                return false;
        }

        // for lower left corner:
        r= row;
        for (int i = col; i>=0 && r<board.length ; i--, r++) {
            if(board[r][i]=='Q')
                return false;
        }


        return true;
    }
    
    // To find the position of all Queens:
    void findPositions(char[][] board, int col ){
        if(col==board.length){
            displayBoard(board);
            System.out.println();
            return;
        }
        for (int row = 0; row < board.length; row++) {
            if(isValid(row, col, board)){
                board[row][col]='Q';
                findPositions(board, col+1);
                board[row][col]='*';
            }     
        }
    }

    // To solve the problem:
    void solveQueens(int n){
        char board[][] = new char[n][n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j]='*';
            }
        }
        findPositions(board, 0);
    }

    // To display board:
    void displayBoard(char[][] board){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        nQueens obj = new nQueens();
        obj.solveQueens(4);
    }
}
