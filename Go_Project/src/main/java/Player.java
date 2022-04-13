public class Player implements PlayerInterface{
    private String name;
    private int age;
    private boolean color;  //True for white, False for black
    private int piecesLeft;
    private int turnsPassed=0;

    public Player(String name, int age, boolean color){
        this.name=name;
        this.age=age;
        this.color=color;
        if(!color){
            this.piecesLeft=181;
        }
        else {
            this.piecesLeft = 180;
        }
    }
    @Override
    public boolean getColor(){
        return this.color;
    }

    @Override
    public String getName(){
        return this.name;
    }
    @Override
    public int getAge(){
        return this.age;
    }

    @Override
    //decrement pieces left by 1
    public void placePiece(int row, int column){
        //logic to place a piece on the board
    }

    @Override
    public int getPiecesLeft(){
        return this.piecesLeft;
    }
    @Override
    public int getTurnsPassed(){
        return this.turnsPassed;
    }



}
