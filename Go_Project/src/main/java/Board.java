import java.util.Arrays;

public class Board implements BoardInterface{

    private Piece[][] board;
    private final int boardSize = 19;

    public Board(){  //Possible board sizes 5x5 9x9 13x13 17x17
//        setBoardSize(boardSize);
        this.board = new Piece[this.boardSize][this.boardSize];
    }
    /*
    private void setBoardSize(int boardSize){
        if (boardSize != 5 && boardSize != 9 && boardSize != 13 && boardSize != 17 && boardSize != 19){
            throw new IllegalArgumentException("Board must be 5x5, 9x9, 13x13, 17x17 or 19x19");
        }
        this.boardSize = boardSize;
    }*/
    
    @Override
    public boolean placePiece(int row, int column, Piece piece) {
        //this.board[row][column] = piece;
        piece.setLocation(row, column);

        //verify the board here and return false if not valid
    //logic to check if there are no liberties left

        return piece.getColor();
    }

    @Override
    public Piece[][] getCopyOfBoard() {
        Piece[][] clone= new Piece[this.boardSize][this.boardSize];

        for(int i = 0; i < this.board.length; i++) {
            clone[i] = this.board[i].clone();
        }
     return clone;
    }

    public boolean isAdjacent(int row1, int column1, int row2, int column2){
        if(row1==0 || row1==this.boardSize-1){
            if(row2==0)
        }

        if(row1==row2+1 &&  row2+1<boardSize){
                return true;
            }


        }
    }
    
    
    
    @Override
    public void cleanBoard() {
        
    }
}
