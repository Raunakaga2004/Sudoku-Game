import java.util.HashSet;

class GenerateBoard extends Sudoku{
    GenerateBoard(float level){
        super();
        super.boardsol = genBoard(0,0,super.boardsol, new HashSet<Integer>());
        super.board = genPlayingBoard(super.board,level);

        //deep copy of board to original board
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                originalBoard[i][j] = board[i][j];
            }
        }
    }

    //generates a filled board which follows the sudoku rules
    protected int[][] genBoard(int r, int c, int[][] board, HashSet<Integer> hash) {
        //base condition
        if(r >= board.length){
            return board;
        }
        //switch to next row
        if(c >= board.length){
            return genBoard(r+1, 0, board, new HashSet<Integer>());
        }

        //if checked all possibility means size = 9
        while(hash.size() < 9){
            int randomNum = random();
            if(hash.contains(randomNum)) continue; //if already checked this number then change this number 
            else{
                hash.add(randomNum); //if this number is not checked before 

                //if valid place number
                if(isValid(randomNum, r, c, board)){
                    board[r][c] = randomNum;
                    int[][] temp = genBoard(r,c+1,board,new HashSet<>());
                    if(temp != null){ //if not null means it is the board which has been generated 
                        return temp;
                    }
                    else{
                        //backtrack
                        board[r][c] = 0;
                    }
                }
            }
        }

        // if valid place random number
        // if not valid and place every number then backtrack
        // keep track of tried numbers with Hashset
        return null;
    }

    //generates a board with empty spaces
        //by using probability choose that whether the number should be 0 or not.
    protected int[][] genPlayingBoard(int[][] board, float level) {
        //deep copy the boardsol to board
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(Math.random() > level){
                    board[i][j] = super.boardsol[i][j];
                }
            }
        }
        //iterate through every element
        //the more level the more the chance of setting the element 0;

        return board;
    }


    //generates random integer value from 1 to 9
        //static because it does not depend on any object
    public static int random(){
        int randomNum = (int) (Math.random() * 10); //Math.random() generates the number between 0 and 1 with huge float value
        if(randomNum == 0) return random(); //if num is 0 then return
        return randomNum;
    }
}
