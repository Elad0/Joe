public interface RulesInterface {

    /**
     * Verify that the given board state is legal by passing it through methods in this class which correspond to each rule
     * @param board
     * @return whether the board state is legal
     */
    boolean verifyBoard(Board board);
}

/*
Rules of go

1. there are 2 players, black and white
2. 19 horizontal and 19 vertical lines make up the board --> 361 points
3. Black goes first
4.2 points are adjacent if there is a horizontal or vertical line between that that isuninterrrupted
5. black gets 181 pieces, white gets 180
6. pieces are coneccted if you can draw a path from one to the other through onky adjacent intersections
liberty of a stone is an empty intersection adjacent to that stone or adjacent to a stone which is connected to that stone.

Liberty is a piece that
When it is a player's turn they can pass or play

Step 1. Placing a stone of their color on an empty intersection
Step 2. Removing from the board any stones of their opponent's color that have no liberties.
Step 3.
Removing from the board any stones of their own color that have no liberties.


Step 1
A player places a stone on any empty intersection

Step 2
A player can capture an opponets piece if it has no liberties after step 1.

Step 3
(After playing their stone and capturing any opposing stones) a player removes from the board any stones of their own color that have no liberties.
 */