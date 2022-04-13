import java.util.Set;

public class Game implements GameInterface{
    @Override
    public Player play() {
        return null;
    }

    @Override
    public void setUp() {

    }

    @Override
    public boolean verify() {
        return false;
    }

    @Override
    public boolean turn(Board board) {
        return false;
    }

    @Override
    public Set<Board> getPastBoards() {
        return null;
    }
}
