import java.util.*;

/**
* operates the game by taking player input and checking for win conditions
* @author Mitchell Schray
* @author Zane Price
* @author Sadia Khan
* @author Tyler Pate
*/
public class ConnectFour {   
   
    /** The maximum number of pieces that can occupy the board */
    public static final int FULL_BOARD = 64;

    /**
    * Executes Connect four
    * Does the game loop, player turns, inputs, etc
    * @param args Command line arguments (are not used though)
    */
    public static void main(String[] args) {
        String playerOne;
        String playerTwo;
        int currentTurn;
        Player players = new Player();
        playerOne = players.getPlayerOne();
        playerTwo = players.getPlayerTwo();
        Grid grid = new Grid();
        Scanner scnr = new Scanner(System.in);
        
        System.out.print(grid);
        while(true) {
            int chosenColumn;
            boolean validMove = false;
            
            do {
                System.out.print("Player 1 (" + playerOne + ") Choose a column: ");
                if (scnr.hasNextInt()) {
                    chosenColumn = scnr.nextInt();
                    
                    if (chosenColumn >= 1 && chosenColumn <= Grid.COLUMN - 1) {
                        if (!grid.isColumnFull(chosenColumn)) {
                            validMove = true;
                        } else {
                            System.out.println("Column is full, choose again: ");
                        }
                    } else {
                        System.out.println ("Invalid column number(must be between 1 and " +
                    (Grid.COLUMN - 1) + ").");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a number.");
                    scnr.next();
                    chosenColumn = -1;
                }
            } while (!validMove);

            grid.placePiece(chosenColumn, playerOne);
            players.addPieceOne();
            int maxConnectedOne = Grid.getMaxConnected(playerOne);
            players.setMaxConOne(maxConnectedOne);
            System.out.print(grid);
            System.out.println("Player 1 total pieces: " + players.getPlayerOnePieces());
            System.out.println("Player 1 max connected: " + players.maxConOne()); 

            if(grid.checkIfWon(Player.PLAYER_ONE)){
                System.out.println("Player One Wins");
                break;
            }
            
            validMove = false;

            do {
                System.out.print("Player 2 (" + playerTwo + ") Choose a column: ");
                if (scnr.hasNextInt()) {
                    chosenColumn = scnr.nextInt();
                    
                    if (chosenColumn >= 1 && chosenColumn <= Grid.COLUMN - 1) {
                        if (!grid.isColumnFull(chosenColumn)) {
                            validMove = true;
                        } else {
                            System.out.println("Column is full, choose again: ");
                        }
                    } else {
                        System.out.println ("Invalid column number (must be between 1 and " +
                        (Grid.COLUMN - 1) + ").");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a number.");
                    scnr.next(); 
                    chosenColumn = -1; 
                }
            } while (!validMove);
            
            grid.placePiece(chosenColumn, playerTwo);
            players.addPieceTwo();
            
            int maxConnectedTwo = Grid.getMaxConnected(playerTwo);
            players.setMaxConTwo(maxConnectedTwo);
            System.out.print(grid);
            System.out.println("Player 2 total pieces: " + players.getPlayerTwoPieces());
            System.out.println("Player 2 max connected: " + players.maxConTwo());

            if(players.getPlayerTwoPieces() + players.getPlayerOnePieces() == FULL_BOARD){
                if(!grid.checkIfWon(playerOne) && !grid.checkIfWon(playerTwo)) {
                    System.out.println("Tie game");
                    break;
                }
            }
            if (grid.checkIfWon(Player.PLAYER_TWO)){
                System.out.println("Player Two wins");
                break;
            }
            
        }
    }
}