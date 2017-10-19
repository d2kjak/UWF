/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p5;

/**
 *
 * @author djj5
 */
/******************************************************************************************************************
*This is my Tic Tac Toe class that sets the players and the board up
*******************************************************************************************************************/
public class TicTac {
    
    int [] board = new int[9]; 
    int player, move, winner = 0;
    boolean win = false;
/*
My constructor that simply initializes the board
*/    
    public TicTac(){
        initBoard();
        player = 0;
        move = 1;
    }
    
/*
My initialization my to set the board up, setting each values in the 2D array to zero
*/    
    public void initBoard(){
        int i;
        for(i=0; i<9; i++){
            board[i] = 0;
        }
    }

/*
My help method to check current position passed to it  
*/    
    /*public int checkPos(int x, int y){
        return board[x][y];
    }*/
    
    public boolean validMove(int pos){
        boolean tmp = false;
        if(pos <9 && pos !=-1){
            if(board[pos]==0){
                tmp = true;
            }
            else if(board[pos]!=0){
                tmp = false;
            }
            
        }
        return tmp;
    }
/*
    //getting row move and column move from each play to check if a player has won
*/ 
    public void move(int position, int p){
        boolean temp = validMove(position);
        if(temp){
            board[position] = p;
            checkWinner(p);
        }
    }
/*
My method to see if a player a won yet    
*/   
    public void checkWinner(int p){
        if(board[0] == p && board[1] == p && board[2] == p)
      {
         setWinner(p);
      }
        if(board[0] == p && board[3] == p && board[6] == p)
      {
         setWinner(p);
      }
        if(board[2] == p && board[4] == p && board[6] == p)
      {
         setWinner(p);
      }
        if(board[2] == p && board[5] == p && board[8] == p)
      {
         setWinner(p);
      }
      if(board[3] == p && board[4] == p && board[5] == p)
      {
         setWinner(p);
      }
      if(board[1] == p && board[4] == p && board[7] == p)
      {
         setWinner(p);
      }
      if(board[6] == p && board[7] == p && board[8] == p)
      {
         setWinner(player);
      }
      if(board[0] == p && board[4] == p && board[8] == p)
      {
         setWinner(p);
      }
    }


    public int boardPos(int a, int b) //given an x and y coordinate, returns the single board location number
   {
      if(a == 1)
      {
         if(b == 1)
            return 0;
         else if(b == 2)
            return 1;
         else if(b == 3)
            return 2;
         else 
            return -1;
      }
      else if (a == 2)
      {
         if(b == 1)
            return 3;
         else if(b == 2)
            return 4;
         else if(b == 3)
            return 5;
         else
            return -1;
      
      }
      else if (a == 3)
      {
         if(b == 1)
            return 6;
         else if(b == 2)
            return 7;
         else if(b == 3)
            return 8;
         else
            return -1;
      }
      else
      {
         return -1;
      } 
   }
   
    

    
/*
My setters and getters and extra method for the board tic tac toe game
*/    
    public void setBoard(int[] board){
        this.board = board;
    }
    public int[] getBoard(){
        return board;
    }
    public boolean wonYet(){
        return win;
    }
    public void setMove(int move){
        this.move = move;
    }
    public void changeMove(){
        if(move==1){
            move = 2;
        }
        else if(move==2){
            move = 1;
        }
    }
    public int getMove(){
        return move;
    }
    public void setWinner(int winnerr){
        winner = winnerr;
        win = true;
    }
    public int getWinner(){
        return winner;
    }
    public void addP(){
        player +=1;
    }
    public int playerPos(int currentPos){
        if(currentPos<9 && currentPos !=-1){
            return board[currentPos];
        }
        else{
            return -1;
        }
    }

    
/*
My toString method to verify a winner    
*/   
    public String toString(){
        return "Board:\n" 
                + "\n" + board[0] + "|" + board[1] + "|" + board[2] + "\n" 
                + "\n" + board[3] + "|" + board[4] + "|" + board[5] + "\n" 
                + "\n" + board[6] + "|" + board[7] + "|" + board[8] + "\n";
    }
    
}
