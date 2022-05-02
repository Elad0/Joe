import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;


public class Game implements GameInterface{
private int skippedTurns=0;
private Player p1;
private Player p2;
private HashSet<Board> pastBoards;
private Board gameBoard;

public Game(){
    this.p1=null;
    this.p2=null;
    this.pastBoards= new HashSet<Board>();
    this.gameBoard=new Board();
}
    public Player play() {
        boolean gameOver=false;
;
        Scanner kbReader= new Scanner(System.in);
        setUp();
        while(gameOver==false){

            System.out.println("Input -1 to skip your turn, any other number to continue- Warning skipping consectively results in a loss and if 2 players skip consecutively the game ends");
           try{int decision= kbReader.nextInt();}
           catch(Exception e){
               System.out.println("That was not a number. Please input a number");
               continue; //If the player did not have a valid choice simply prompt them to choose again
           }



        }
    }

    private void setUp(){
        System.out.println("The youngest player goes first");
        Scanner kbReader= new Scanner(System.in);

        System.out.println("Enter the youngest player's name followed by their age");
        String nameP1=kbReader.nextLine();
        int age1=kbReader.nextInt();

        System.out.println("Enter the other player's name followed by their age");

        String nameP2=kbReader.nextLine();
        int age2=kbReader.nextInt();

        this.p1= new Player(nameP1, age1, false);
        this.p2= new Player(nameP2, age2, true);
    }

    private void placePiece(Player player) { //prompt the user to place a piece on the board
    Scanner kbReader= new Scanner(System.in);
    System.out.println("What row would you like to place a piece on?, the row must be from 1-19");
    String rowS= kbReader.nextLine();
    
    if(!isValidRoworColumn(rowS)) {  //Code incase the user inputs a nonvalid number
        while (!isValidRoworColumn(rowS)) {
            System.out.println("Please enter a Valid Row Number");  
            rowS = kbReader.nextLine();
        }
    }
    System.out.println("What column would you like to place a piece at? the column must be from 1-19");
        String columnS= kbReader.nextLine();
        if(!isValidRoworColumn(columnS)) {  //Code incase the user inputs a nonvalid number
            while (!isValidRoworColumn(columnS)) {
                System.out.println("Please enter a Valid Column Number");
                columnS = kbReader.nextLine();
            }
        }
        int verifiedrow=Integer.parseInt(rowS);
        int verifiedColumn=Integer.parseInt(columnS);
        
    //logic to place a piece
        // 
        
        //if the board is valid make this.gameboard=tempelse reprompt the user to place a piece
        
    }

    @Override
    public boolean verify() {
        return false;
    }

    @Override
    public boolean turn(Board board, int i) {   //make a turn and return true if valid else false
        if(i==-1){
            this.skippedTurns=this.skippedTurns++;
            return true;
        }
        this.skippedTurns=this.skippedTurns--;
    }

    private boolean isValidRoworColumn(String k) {
        try {
            Integer.parseInt(k);
            if (isValidRowCol(Integer.parseInt(k))) {
                return true;
            }
            return false;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    private boolean isValidRowCol(int k){
        if(k>=1 && k<=19){
            return true;
        }
            return false;
    }
    @Override
    public Set<Board> getPastBoards() {
        return null;
    }

    public static void main(String args[]){
        play();
    }
}
