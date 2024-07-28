public class PencilBoard extends Sudoku{
    static int[][][] pencilBoard = new int[9][9][9];

    //insert pencil num
    public static void insertPencilNum(int num, int row, int col) throws Exception{
        if(num <1 || num >9) throw new Exception("INVALID!");
        pencilBoard[row][col][num-1] = num;
    }

    //remove pencil num
    public static void removePencilNum(int num, int row, int col) throws Exception{
        if(num <1 || num >9) throw new Exception("INVALID!");
        pencilBoard[row][col][num-1] = 0;
    }

    //remove pencil num after the insertion
    public static void removeNumInPB(int num, int row, int col){
        //vertical
        for (int i = 0; i < 9; i++) {
            pencilBoard[i][col][num-1] = 0;
        }
        //horizonatal
        for (int j = 0; j < 9; j++) {
            pencilBoard[row][j][num-1] = 0;
        }
        //for box
        int startRow = (row/3) * 3; int endRow = startRow + 3;
        int startCol = (col/3) * 3; int endCol = startCol + 3;

        for (int i = startRow; i < endRow; i++) {
            for (int j = startCol; j < endCol; j++) {
                pencilBoard[i][j][num-1] = 0;
            }
        }
    }
}
