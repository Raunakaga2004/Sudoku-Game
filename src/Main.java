import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
//        GenerateBoard temp = new GenerateBoard(0.5F);
//

        Sudoku game = new GenerateBoard(0.5F);

        game.board[0][0]= 9;

        for(int[] i : game.boardsol){
            System.out.println(Arrays.toString(i));
        }
        System.out.println();
        for(int[] i : game.board){
            System.out.println(Arrays.toString(i));
        }
        System.out.println();
        for(int[] i : game.originalBoard){
            System.out.println(Arrays.toString(i));
        }
//        demoGame.display(demoGame.boardSolution);
    }
}
