public class Board implements BoardInterface{

    private Piece[][] board;

    public Board(int row, int column){
        this.board = new Piece[row][column];
    }

    @Override
    public boolean placePiece(int row, int column, boolean color) {
        return false;
    }

    @Override
    public Piece[][] getCopyOfBoard() {

        return new Piece[0][];
    }

    @Override
    public void cleanBoard() {
        
    }
}
