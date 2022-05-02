public interface BoardInterface {

    /**
     * add a Piece to the board at the row, column
     * @param row
     * @param column
     * @return
     */
    //boolean placePiece(int row, int column, Piece piece);

    /**
     * returns a copy of the board state to be logged in the game's
     * pst board states
     * @return a copy of the board
     */
    Piece[][] getCopyOfBoard();

    /**
     * Capture any pieces which need to be captured
     */
    void cleanBoard();
}
