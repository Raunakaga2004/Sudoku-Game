import java.util.Arrays;
import java.util.HashSet;


public class Sudoku{
    int[][] boardsol = new int[9][9]; //this board is filled completely with numbers
    int[][] board = new int[9][9]; //this board has some unfilled spaces

    final int[][] originalBoard = new int[9][9];

    Sudoku() {}

    //place the number
    public void placeNum(int num, int row, int col) throws Exception{
        if(board[row][col] == 0 && num > 0 && num <= 9){
            if(isValid(num, row, col, board)){
                board[row][col] = num;
            }
        }
        else{
            throw new Exception("Invalid!!");
        }
    }

    //temporary function
    public void display(int[][] board){
        for (int i = 0; i < board.length; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
    }

    //to check if the num is valid for that place according to board in argument
        //static because it does not depend on any object
        //protected so that subclasses can access
    protected static boolean isValid(int num, int row, int col, int[][] board) {
        //check for vertical row
        for (int i = 0; i < 9 ; i++) {
            if(num == board[i][col]) return false;
        }

        //check for horizontal row
        for (int j = 0; j < 9 ; j++) {
            if(num == board[row][j]) return false;
        }

        //check for boxes
        int startRow = (row/3) * 3; int endRow = startRow + 3;
        int startCol = (col/3) * 3; int endCol = startCol + 3;

        for (int i = startRow; i < endRow; i++) {
            for (int j = startCol; j < endCol; j++) {
                if(board[i][j] == num) return false;
            }
        }

        return true;
    }
}
