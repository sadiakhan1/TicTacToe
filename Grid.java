

    /**
     * Designs and constructs the grid 
     * @author Mitchell Schray
     * @author Zane Price
     * @author Sadia Khan
     * @author Tyler Pate
     */
public class Grid {
    
    /** The number needed to win */
    public static int MAX_SCORE = 4;

    /** The number of rows in the grid */
    public static int ROW = 8;

    /** The number of columns in the grid */
    public static int COLUMN = 9;

    /** String array that represents the grid based on the size of rows and columns */
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
        if (grid[7][column].equals("X") || grid[7][column].equals("O")) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * places a piece into the grid
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
     * @return a string containg the grid
     */
    public String toString() {
        String fullGrid = "";
        for (int i = ROW-1; i >= 0; i--){
            for(int j = 1; j < COLUMN; j++){
                fullGrid += "[" + grid[i][j] + "]";
            }
            fullGrid += "\n";
        }
        return fullGrid;
    }
    
    /**
     * checks if the coluimn is full
     */
    public static boolean isFull() {
        int s = 0;
        for(int i = 1; i < COLUMN; i++){
            if(isColumnFull(i)){
                s += 1;
            }
        }
        if(s == 8){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * returns a piece of the grid with its row and column
     * @return a string from the grid with row and column
     */
    public String getSquare(int row, int column) {
        return grid[row][column];
    }
    
}