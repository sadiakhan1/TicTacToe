/**
     * Designs and constructs the grid 
     * @author Mitchell Schray
     * @author Zane Price
     * @author Sadia Khan
     * @author Tyler Pate
     */
public class Grid {
    
    /** The number needed to win */
    public static final int WIN_CONDITION = 4;

    /** The number of rows in the grid */
    public static final int ROW = 8;

    /** The number of columns in the grid */
    public static final int COLUMN = 9;

    /** String array that represents the grid based 
     * on the size of rows and columns */
    private static String[][] grid = new String[ROW][COLUMN];


    /**
    * Creates and initializes the grid
    */
    public Grid() {
        for (int i = 0; i < ROW; i++){
            for(int j = 0; j < COLUMN; j++){
                grid[i][j] = " ";
            }
        }
    }
    
    /**
     * Checks if a column is full of pieces or not
     * @param column the column index to be checked
     * @return true if the column is full, false otherwise
     */
    public static boolean isColumnFull(int column){
        if (grid[ROW - 1][column].equals("X") || grid[ROW - 1][column].equals("O")) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
    * Places a piece into the grid
    * @param column the column index of where it is supposed to be placed
    * @param piece the piece ("X" or "O")
    * @return the row index of where the piece the placed
    */
    public int placePiece(int column, String piece) {
        int row = -1;
        if (!isColumnFull(column)) {
            for (int i = 0; i < ROW; i++) {
                if (grid[i][column].equals(" ")) {
                    grid[i][column] = piece;
                    row = i;
                    break;
                }
            }
        }
        return row;
    }

    /**
    * returns a string of the grid 
    * @return a string containg the grid
    */
    public String toString() {
        String fullGrid = "";
        for (int i = ROW - 1; i >= 0; i--){
            for(int j = 1; j < COLUMN; j++){
                fullGrid += "[" + grid[i][j] + "]";
            }
            fullGrid += "\n";
        }
        return fullGrid;
    }
    
    /**
     * checks if the coluimn is full
     * @return true if all columns are full; false if not
     */
    public static boolean isFull() {
        int s = 0;
        for (int i = 1; i < COLUMN; i++){
            if(isColumnFull(i)){
                s += 1;
            }
        }
        if (s == COLUMN - 1){
            return true;
        }
        else {
            return false;
        }
    }

    /**
    * returns a piece of the grid with its row and column
    * @param row the integer for the row's index
    * @param column the integer for the column's index
    * @return a string from the grid with row and column
    */
    public String getSquare(int row, int column) {
        return grid[row][column];
    }
    
    /**
     * finds the maximum number of connected
     * pieces (horizontal, vertical, or diagonal) for a player.
     * @param piece The player's piece ("X" or "O").
     * @return The maximum number of connected pieces.
     */
    public static int getMaxConnected(String piece) {
        int maxHori = getMaxHori(piece);
        int maxVert = getMaxVertical(piece);
        int maxDiag = getMaxDiag(piece);
        
        return Math.max(maxHori,
            Math.max(maxVert, maxDiag));  
    }

    /**
    * Finds the maximum number of connected horizontal pieces.
    * @param piece the player's piece
    * @return the maximum horizontal count
    */
    public static int getMaxHori(String piece) {
        int maxOverall = 0;
        //increments through each piece in the grid
        for (int i = 0; i < ROW; i++){
            for(int j = 1; j < COLUMN; j++){
                int maxConnected = 0;
                int countDistance = 0;
                //checks each piece to the right of the current piece at index grid[i][j]
                //until it reaches a non-matching piece
                while (j + countDistance < COLUMN) {
                    if (grid[i][j + countDistance].equals(piece)) {
                        maxConnected += 1;
                    }
                    else {
                        break;
                    }
                    countDistance++;
                }
                if (maxConnected > maxOverall) {
                    maxOverall = maxConnected;
                }
            }
        }
        return maxOverall;
    }
    
   /**
     * Finds the maximum number of connected vertical pieces.
     * @param piece the player's piece
     * @return the maximum vertical count
     */
    public static int getMaxVertical(String piece) { 
        int maxOverall = 0;
        for(int j = 1; j < COLUMN; j++){
            int count = 0;
            for(int c = 0; c < ROW; c++){
                if(grid[c][j].equals(piece)){
                    count += 1;
                } else {
                    if(count > maxOverall){
                        maxOverall = count;
                    }
                    count = 0; 
                }
            }
            if(count > maxOverall){
                maxOverall = count;
            }
        } 
        return maxOverall;
    }
    
    /**
     * Finds the maximum number of connected diagonal pieces.
     * @param piece player's piece
     * @return the maximum diagonal count
     */
    public static int getMaxDiag(String piece) {
        int maxOverall = 0;
        //increments through each piece in the grid
        for (int i = 0; i < ROW; i++){
            for(int j = 1; j < COLUMN; j++){
                int maxConnected = 0;
                int countDistance = 0;
                //checks each piece to the up-right of the current piece at index grid[i][j]
                //until it reaches a non-matching piece
                while (j + countDistance < COLUMN && i + countDistance < ROW) {
                    if (grid[i + countDistance][j + countDistance].equals(piece)) {
                        maxConnected += 1;
                    }
                    else {
                        break;
                    }
                    countDistance++;
                }
                if (maxConnected > maxOverall) {
                    maxOverall = maxConnected;
                }
                
                maxConnected = 0;
                countDistance = 0;
                while (j - countDistance >= 1 && i + countDistance < ROW) {
                    if (grid[i + countDistance][j - countDistance].equals(piece)) {
                        maxConnected += 1;
                    }
                    else {
                        break;
                    }
                    countDistance++;
                }
                if (maxConnected > maxOverall) {
                    maxOverall = maxConnected;
                }
            }
        }
        return maxOverall;
    }
    
    /**
     * Checks if a person won through having 4
     * matching pieces horizontally, vertically, or diagonally
     * @param piece the player's piece
     * @return true if a player won, false if no one won
     */
    public static boolean checkIfWon(String piece) {
        return getMaxConnected(piece) >= WIN_CONDITION;  
    }
}