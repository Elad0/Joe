public class Piece implements PieceInterface {

    private static final boolean WHITE = true;
    private static final boolean BLACK = false;

    private boolean color;

    public Piece(boolean color){
        this.color = color;
    }

    @Override
    public boolean getColor() {
        return false;
    }
}
