

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

    /** The maimum connected pieces for player one */
    private int maxConOne;

    /** The maimum connected pieces for player two */
    private int maxConTwo;

    
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
    public String getPlayerOne() {
        return playerOne;
    }

    /**
     * Tells the piece of player two
     * @return the string of player two
     */
    public String getPlayerTwo() {
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
    public void addPieceOne() {
        this.playerOnePieces += 1;
    }

    /**
     * Adds 1 piece to the total pieces of player two
     */
    public void addPieceTwo() {
        this.playerTwoPieces += 1;
    }
    
    /**
     * Tells the max number of connected pieces for player one
     * @return the integer of max connected pieces
     */
    public int maxConOne() {
        return maxConOne;
    }

    /**
     * Tells the max number of connected pieces for player two
     * @return the integer of max connected pieces
     */
    public int maxConTwo() {
        return maxConTwo;
    }

    /**
     * Updates the max number of connected pieces for player one
     * @param maxConnected the new max connected piece count
     */
    public void setMaxConOne(int maxConnected) {
        this.maxConOne = maxConnected;
    }

    /**
     * Updates the max number of connected pieces for player two
     * @param maxConnected the new max connected piece count
     */
    public void setMaxConTwo(int maxConnected) {
        this.maxConTwo = maxConnected;
    }
}

