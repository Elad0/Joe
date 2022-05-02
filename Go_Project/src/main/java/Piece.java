import java.util.HashMap;

public class Piece implements PieceInterface {

    private static final boolean WHITE = true;
    private static final boolean BLACK = false;
    private int row;
    private int column;
    private HashMap adjacents;

    private boolean color;

    public Piece(boolean color){
        this.color = color;
        setAdjacents();

    }

    @Override
    public boolean getColor() {
        return color;
    }

    public boolean isSameColor(Piece other){
        if (other == null){
            throw new IllegalArgumentException();
        }
        if (other.getColor() == this.color){
            return true;
        }
        return false;
    }

    
    public void setLocation(int row, int column){
        this.row=row;
        this.column=column;

    }
    public int getRow(){
        return this.row;
    }
    public int getColumn(){
        return this.column;
    }


    private HashMap<Integer, Integer> setAdjacents(){
        if (this.row != 0){
            adjacents.put(row - 1, column);
        }
        if (this.row != 18){
            adjacents.put(row + 1, column);
        }
        if (this.column != 0) {
            adjacents.put(row, column - 1);
        }
        if (this.column != 18) {
            adjacents.put(row, column + 1);
        }
        return adjacents;
    }

    public boolean isAdjacent(int rowtoCheck, int columntoCheck){
        if(rowtoCheck==this.row && this.column==columntoCheck-1){
            if(this.column!=0){
                return true;
            }
        }
        if(rowtoCheck==this.row && this.column==columntoCheck+1){
            if(this.column!=18){
                return true;
            }
        }

        if(rowtoCheck==this.row-1 && this.column==columntoCheck){
            if(this.row!=0){
                return true;
            }
        }

        if(rowtoCheck==this.row+1 && this.column==columntoCheck){
            if(this.row!=18){
                return true;
            }
        }
        return false;

    }

    }



