import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;


public class Sudoku{
    int[][] boardsol = new int[9][9]; //this board is filled completely with numbers
    int[][] board = new int[9][9]; //this board has some unfilled spaces
    Stack<int[]> steps = new Stack<>(); //store steps in form of int[] = {Row , Column}

    final int[][] originalBoard = new int[9][9];

    Sudoku() {}

    //place the number
    public void placeNum(int num, int row, int col) throws Exception{
        if(board[row][col] == 0 && num > 0 && num <= 9){
            if(isValid(num, row, col, board)){
                board[row][col] = num;
                steps.push(new int[] {row,col});
                PencilBoard.removeNumInPB(num, row, col);
            }
        }
        else{
            throw new Exception("Invalid!!");
        }
    }

    //remove the number
    public void removeNum(int row, int col) throws Exception{
        if(originalBoard[row][col] == 0){
            board[row][col] = 0;
        }
        else{
            throw new Exception("Invalid!!");
        }
    }

    //reset the board
    public void reset(){
        //deep copy the original board to board
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = originalBoard[i][j];
            }
        }
    }

    //undo
    public void undo() throws Exception{
        if(steps.isEmpty()) throw new Exception("Invalid!!");
        removeNum(steps.peek()[0], steps.peek()[1]);
        steps.pop();
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

    //display solution
    public void displaySol(){
        System.out.println("\nSolution : ");
        for(int[] i : boardsol){
            System.out.println(Arrays.toString(i));
        }
    }

    //hint

    //display board and pencil board
    public void displayMain(){
        for(int i = 0; i<9 ; i++){
            System.out.print(Arrays.toString(board[i]) + "\t\t");
            for (int j = 0; j < 9; j++) {
                System.out.print("[ ");
                for (int k = 0; k < 9; k++) {
                    if(PencilBoard.pencilBoard[i][j][k] == 0) continue;
                    else
                        System.out.print(PencilBoard.pencilBoard[i][j][k] + ",");
                }
                System.out.print("]");
            }
            System.out.println();
        }
    }

    //display board
}
