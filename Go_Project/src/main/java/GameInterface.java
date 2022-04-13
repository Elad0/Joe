import java.util.*;
public interface GameInterface {

    /**
     * Play the game
     * @return the player who won
     *Game ends if player runs out of pieces
     * */
    Player play();

    /**
     * Set up the game meaning create the 2 players and decide who goes first
     *
     */
    void setUp();

    /**
     * Verify the board by calling rules on the board
     * Call Rules on the board
     * @return whether the board is valid
     */
    boolean verify();

    /**
     * make a turn on the given board and verify that it is a valid board
     * @param board
     * Add the board to the set of past boards
     * @return whether the move is valid
     */
    boolean turn(Board board);

    /**
     * @return a set of the past boards
     */
    Set<Board> getPastBoards();



}
