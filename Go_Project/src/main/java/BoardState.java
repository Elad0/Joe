import java.util.HashSet;

public class BoardState implements RulesInterface{
    
    
    @Override
    public boolean verifyBoard(Board board) {
        return false;
    }

    public boolean verifyPlay(Piece newPiece, Piece[][] currentBoard){
        // catch if newPiece is null
        if (spotIsTaken(newPiece.getRow(), newPiece.getColumn(), currentBoard)){
            //invalid move - throw exception?
            return false;
        }
        placePiece(newPiece, currentBoard);
        eliminatePiecesIfNecessary(newPiece, currentBoard);
        return true;
    }

    private boolean hasLiberties(Piece[][] currentBoard, Piece piece, HashSet<Piece> checkedPieces){
        int row = piece.getRow();
        int column = piece.getColumn();
        if (checkRight(currentBoard, piece, checkedPieces, row, column)){
            return true;
        }
        if (checkLeft(currentBoard, piece, checkedPieces, row, column)){
            return true;
        }
        if (checkTop(currentBoard, piece, checkedPieces, row, column)){
            return true;
        }
        if (checkBottom(currentBoard, piece, checkedPieces, row, column)){
            return true;
        }
        return false;
    }
    
    private boolean checkRight(Piece[][] boardCopy, Piece piece,HashSet<Piece> checkedPieces, int row, int column){
        if(column<18){ //logic to check right
            //might need to do column--
            if (boardCopy[row][column+1] == null){
                //String coordinate = row+ " " + (column+1);
                //liberties.add(coordinate);
                return true;
            }
            if(boardCopy[row][column+1].isSameColor(piece)){
                if(!checkedPieces.contains(boardCopy[row][column+1])){ // if we haven't checked the next piece
                    hasLiberties(boardCopy, boardCopy[row][column+1], checkedPieces); //recursive call on right
                }
            }
        }
        return false;
    }

    private boolean checkLeft(Piece[][] boardCopy, Piece piece,HashSet<Piece> checkedPieces, int row, int column){
        if(column > 0){ //logic to check left
            //might need to do column--
            if (boardCopy[row][column-1] == null){
                //String coordinate = (row)+ " " + (column-1);
                //liberties.add(coordinate);
                return true;
            }
            if(boardCopy[row][column-1].isSameColor(piece)){
                if(!checkedPieces.contains(boardCopy[row][column-1])){
                    hasLiberties(boardCopy, boardCopy[row][column-1], checkedPieces);
                }
            }
        }
        return false;
    }

    private boolean checkTop(Piece[][] boardCopy, Piece piece,HashSet<Piece> checkedPieces, int row, int column){
        if(row>0){ //logic to check right
            //might need to do column--
            if (boardCopy[row-1][column] == null){
                //String coordinate = (row-1)+ " " + (column);
                //liberties.add(coordinate);
                return true;
            }
            if(boardCopy[row-1][column].isSameColor(piece)){
                if(!checkedPieces.contains(boardCopy[row-1][column])){
                    hasLiberties(boardCopy, boardCopy[row-1][column], checkedPieces);
                }
            }
        }
        return false;
    }

    private boolean checkBottom(Piece[][] boardCopy, Piece piece,HashSet<Piece> checkedPieces, int row, int column){
        if(row<18){ //logic to check right
            //might need to do column--
            if (boardCopy[row+1][column] == null){
                //String coordinate = (row+1)+ " " + (column);
                //liberties.add(coordinate);
                return true;
            }
            if(boardCopy[row+1][column].isSameColor(piece)){
                if(!checkedPieces.contains(boardCopy[row+1][column])){
                    hasLiberties(boardCopy, boardCopy[row+1][column], checkedPieces);
                }
            }
        }
        return false;
    }

    private boolean spotIsTaken(int row, int column, Piece[][] currentBoard){
        if (currentBoard[row][column] != null){
            return true;
        }
        return false;
    }
    private void placePiece(Piece newPiece, Piece[][] currentBoard){
        currentBoard[newPiece.getRow()][newPiece.getColumn()] = newPiece;
    }
    private void eliminatePiecesIfNecessary(Piece newPiece, Piece[][] currentBoard){
        HashSet<Piece> checkedOpposingPieces = new HashSet<Piece>();
        if (hasLiberties(currentBoard, newPiece, checkedOpposingPieces)){
            return;
        }
        removeEliminatedPieces(checkedOpposingPieces, currentBoard);
    }
    private void removeEliminatedPieces(HashSet<Piece> piecesToBeRemoved, Piece[][] currentBoard){
        for (Piece p : piecesToBeRemoved){
            currentBoard[p.getRow()][p.getColumn()] = null;
        }
    }
}
