import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        GenerateBoard temp = new GenerateBoard(0.5F);
        for(int[] i : temp.boardsol){
            System.out.println(Arrays.toString(i));
        }
        System.out.println();
        for(int[] i : temp.board){
            System.out.println(Arrays.toString(i));
        }
//        demoGame.display(demoGame.boardSolution);
    }
}
