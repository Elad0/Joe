import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;


public class Game implements GameInterface{
private int skippedTurns=0;
private Player p1;
private Player p2;
private HashSet<Board> pastBoards;
private Board gameBoard;
private boolean playerTurn;
private BoardState boardState;

public Game(){
    this.p1=null;
    this.p2=null;
    this.pastBoards= new HashSet<Board>();
    this.gameBoard=new Board();
    this.playerTurn=true;
    this.boardState=new BoardState();
    
    this.setUp();
}
    public Player play() {
    	int decision=0;
        boolean gameOver=false;

        Scanner kbReader= new Scanner(System.in);
        setUp();
        while(gameOver==false){

            System.out.println(" Player "+ this.choosePlayer().getName()+"'s turn"+"Input -1 to skip your turn, any other number to continue- Warning skipping consectively results in a loss and if 2 players skip consecutively the game ends");
           try{ decision= kbReader.nextInt();}
           catch(Exception e){
               System.out.println("That was not a number. Please input a number");
               continue; //If the player did not have a valid choice simply prompt them to choose again
           }
           
          while( turn(this.gameBoard, decision)==false) {
        	  System.out.println("That was not a valid move,- LOGIC FOR THE REASON WHY IT WAS INVALID- SIMILAR BOARD, PIECE THERE ETCETERA CAN REMOVE THIS PART IF TOO CHALLENGING");
        	  turn(this.gameBoard, decision);
          }
   
         
if(this.skippedTurns==2) {
	gameOver=true;
}
 
//turn ends so swap players;
this.playerTurn=!this.playerTurn;
this.pastBoards.add(this.gameBoard);//add current board to past boards;
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

    private boolean placePiece(Player player, Board board) { //prompt the user to place a piece on the board
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
        
       boolean valid= this.boardState.spotIsTaken(verifiedrow, verifiedColumn, board.getCopyOfBoard());
       
       if(valid) {
    	   if (this.pastBoards.contains(this.gameBoard)) {
    		   return false;
			
		}
    	   
    	   
    	   return true;
       }
       
       else {
    	   return false;
       }
        // 
        
        //if the board is valid make this.gameboard=tempelse reprompt the user to place a piece
        
    }

    @Override
    public boolean verify() {
        return false;
    }

    public boolean turn(Board board, int i) {   //make a turn and return true if valid else false //boolean to distinguish who it is// true for p1, false for p2
    	
        if(i==-1){
            this.skippedTurns=this.skippedTurns++;
            return true;
        }
        this.skippedTurns=this.skippedTurns--;
        
      //place piece on a location on copy of the board and verify the move
    if(!this.placePiece(choosePlayer(),this.gameBoard)) { //the location chosen was not valid, try again
    	return false;
    }
    
    if(this.pastBoards.contains(this.gameBoard)) {
    	return false;
    }
    
        
        //if turn is invalid return false and prompt the player to go again
        
        
        
        
        
        
        
    }

    
private Player choosePlayer() {	//method which implements the logic of who's turn it is
	if(this.playerTurn) {
		return this.p1;
	}
	
	else {
		return this.p2;
	}
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
    	return Collections.unmodifiableSet(this.pastBoards);
     
    }

 
}
