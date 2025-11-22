

/**
 * stores the information of the player of their piece type, win count, and pieces placed
 * @author Mitchell Schray
 * @author Zane Price
 * @author Sadia Khan
 * @author Tyler Pate
 */
public class Player {
    
    /** Represents the piece for player one */
    public static final String PLAYER_ONE = "X";

    /** Represents the piece for player two */
    public static final String PLAYER_TWO = "O";

    //instance variables

    /** String that represents player one */
    private String playerOne;

    /** String that represents player two */
    private String playerTwo;

    /** Number of pieces placed by player two */
    private int playerTwoPieces;

    /** Number of pieces placed by player one */
    private int playerOnePieces;

    
    //constructors

    /**
     * Creates player
     */
    public Player() {
        this.playerOne = PLAYER_ONE;
        this.playerTwo = PLAYER_TWO;
    } 

    //methods

    /**
     * Tells the piece of player one
     * @return the string of player one
     */
    public String getPlayerOne(){
        return playerOne;
    }

    /**
     * Tells the piece of player two
     * @return the string of player two
     */
    public String getPlayerTwo(){
        return playerTwo;
    }

    /**
     * Tells the number of pieces placed by player two
     * @return the integer of pieces placed by player two
     */
    public int getPlayerTwoPieces() {
        return playerTwoPieces;
    }

    /**
     * Tells the number of pieces placed by player one
     * @return the integer of pieces placed by player one
     */
    public int getPlayerOnePieces() {
        return playerOnePieces;
    }

    /**
     * Adds 1 piece to the total pieces of player one
     */
    public void addPieceOne(){
        this.playerOnePieces += 1;
    }

    /**
     * Adds 1 piece to the total pieces of player two
     */
    public void addPieceTwo(){
        this.playerTwoPieces += 1;
    }
}
