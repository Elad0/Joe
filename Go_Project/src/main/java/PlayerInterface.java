public interface PlayerInterface {

    /**
     * @return the color of the players pieces
     */
    boolean getColor();

    /**
     * add a piece to the board
     * @param row
     * @param column
     */
    void placePiece(int row, int column);

    /**
     * Get the name of the player
     * @return the name
     */
    String getName();

    /**
     * Get the age of the player
     * @return the age of the player
     */
    int getAge();

    /**
     *
     * @return the amount of pieces the player has left
     */
    int getPiecesLeft();

    /**
     * @return the amount of turns passed
     */
    int getTurnsPassed();

}
