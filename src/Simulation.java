//completed
    //generate board
    //place num
    //remove the number
    //reset the board
    //solution
    //undo step
    //pencil feature

import java.util.Scanner;

//uncompleted
    //hint
    //simulation
public class Simulation {
    Simulation() throws Exception {
        simulate();
    }

    private void simulate() throws Exception {

        Scanner sc = new Scanner(System.in);

        System.out.println("SUDOKU GAME\n");
        System.out.println("Enter the Level (from 0 to 1) : ");
        float level = sc.nextFloat();

        Sudoku game;

        if(level > 0 && level < 1){
            game = new GenerateBoard(level);
        }
        else{
            throw new Exception("INVALID!!");
        }

        while(true){
            if(win(game)){
                System.out.println("\nCongratulations!!! you won!");
                break;
            }
            game.displayMain();
            System.out.println();

            //add or remove or addpencil or removepencil or solution or reset or undo
            System.out.println("Enter : ");
            String op = sc.next();

            if(op.equals("help")){
                help();
            }
            else if(op.equals("add") || op.equals("remove") || op.equals("addP") || op.equals("removeP")){
                System.out.println("Row : ");
                int row = sc.nextInt();
                System.out.println("Column : ");
                int col = sc.nextInt();

                if(op.equals("add") || op.equals("addP") || op.equals("removeP")) {
                    System.out.println("Number : ");
                    int num = sc.nextInt();
                    if(op.equals("add"))
                        game.placeNum(num, row, col);
                    else if(op.equals("addP"))
                        PencilBoard.insertPencilNum(num, row, col);
                    else
                        PencilBoard.removePencilNum(num,row, col);
                }
                else
                    game.removeNum(row, col);
            }
            else if(op.equals("undo")){
                game.undo();
            }
            else if(op.equals("reset")){
                game.reset();
            }
            else if(op.equals("sol") || op.equals("end")){
                if(op.equals("sol")) game.displaySol();
                System.out.println("\nENDING THE GAME !!");
                break;
            }
            else{
                System.out.println("INVALID OPERATION!! TRY AGAIN...\n");
                continue;
            }
        }
    }

    private boolean win(Sudoku game) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(game.board[i][j] == 0) return false;
            }
        }
        return true;
    }

    private void help() {
        System.out.println("\nHELP SECTION : \n");
        System.out.println("Enter 'add' to add the number in playing board.");
        System.out.println("Enter 'remove' to remove the number from playing board.");
        System.out.println("Enter 'undo' to undo from playing board.");
        System.out.println("Enter 'reset' to reset the playing board.");
        System.out.println("Enter 'addP' to add the number in pencil board.");
        System.out.println("Enter 'removeP' to remove the number from pencil board.");
        System.out.println("Enter 'sol' to get solution of the board.");
        System.out.println("Enter 'end' to end the game.");
        System.out.println();
    }
}
