import java.util.*;
/**
 * operates the game by taking player input and checking for win conditions
 * @author Mitchell Schray
 * @author Zane Price
 * @author Sadia Khan
 * @author Tyler Pate
 */
public class ConnectFour{   
   /**
     * Operates the game by taking input from two players
     * @params args command line arguments (not used)
     */
   public static void main(String[] args) {
        /** Represents player one  */
        String playerOne;

        /** Represents player two */
        String playerTwo;

        /** Number that represents the current amount of turns in an ongoing game */
        int currentTurn;
        
        
        Player players = new Player();
        playerOne = players.getPlayerOne();
        playerTwo = players.getPlayerTwo();
        Grid grid = new Grid();
        Scanner scnr = new Scanner(System.in);
        
        while(true) {
            System.out.print(grid);
            System.out.print("Player 1 (X) Choose a column: ");
            int chosenColumn = scnr.nextInt();
            if(chosenColumn < 1){
                System.out.println("Invalid column");
                System.out.print("Player 1 (X) Choose a column: ");
                chosenColumn = scnr.nextInt();
            }
            if(grid.isColumnFull(chosenColumn)){
            	while (grid.isColumnFull(chosenColumn)){
            		System.out.println("Column is full, choose again: ");
            		chosenColumn = scnr.nextInt();
            	}
            }
            grid.placePiece(chosenColumn,playerOne);
            players.addPieceOne();
            System.out.print(grid);
            System.out.println("Player 1 total pieces; " + players.getPlayerOnePieces());
            System.out.print("Player 2 (O) Choose a column: ");
            chosenColumn = scnr.nextInt();
            if(chosenColumn < 1){
                System.out.println("Invalid column");
                System.out.print("Player 2 (O) Choose a column: ");
                chosenColumn = scnr.nextInt();
            }
             if(grid.isColumnFull(chosenColumn)){
            	while (grid.isColumnFull(chosenColumn)){
            		System.out.println("Column is full, choose again: ");
            		chosenColumn = scnr.nextInt();
            	}
            }
            grid.placePiece(chosenColumn,playerTwo);
            players.addPieceTwo();
            System.out.print(grid);
            System.out.println("Player 2 total pieces; " + players.getPlayerTwoPieces());
            
        }
        
        
    }

}