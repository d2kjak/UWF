/**
  Student Name: Alberto Medeiros
  File Name: Game.java
  Programming Project 5
  This is the Game class, it handles the tic tac toe game board, player's turn, and if the game has been won.
*/
public class Game
{
   private int[] board = new int[9]; //Array of ints representing each spot on the board
   private int players;
   private int turn;   //keeps track of which players turn it is
   private int winner = 0; //set to 1 or 2 based on which player wins
   private boolean hasSomeoneWon = false; //boolean value representing if someone has won the game
   
   public Game() //Creates a default game instance, with 0 players until a player is added, and initializes the board.
   {
      players = 0;
      turn = 1;
      for(int i = 0; i < 9; i++)  //initializes the board to all 0
      {
         board[i] = 0;
      }
   }
   
   public boolean canPlaceShape(int location) //returns true if there is not a 1 or 2 at the current location given
   {
      boolean temp = false;
      if(location != -1 && location <= 8)  //only checks if it's a valic location to begin with
      {
         if(board[location] != 0)    //if there is anything besides a 0 in that location of the board, returns false.
         {
            temp = false;
         }   
         
         else if(board[location] == 0)   //if there is a 0 in that location of the board, returns true.
         {
            temp = true;
         }
         return temp;
      }
      else
         return false;
   }
   
   public void placeShape(int location, int player) //places the players ID at location on the board
   {
      if(canPlaceShape(location))
      {
         board[location] = player;
         checkWinConditions(player);
      }
   }
   
   public void checkWinConditions(int player) //checks the board for if a player has won
   {
      if(board[0] == player && board[1] == player && board[2] == player)
      {
         setWinner(player);
      } 
      if(board[3] == player && board[4] == player && board[5] == player)
      {
         setWinner(player);
      }
      if(board[6] == player && board[7] == player && board[8] == player)
      {
         setWinner(player);
      }
      if(board[0] == player && board[3] == player && board[6] == player)
      {
         setWinner(player);
      }
      if(board[1] == player && board[4] == player && board[7] == player)
      {
         setWinner(player);
      }
      if(board[2] == player && board[5] == player && board[8] == player)
      {
         setWinner(player);
      }
      if(board[0] == player && board[4] == player && board[8] == player)
      {
         setWinner(player);
      }
      if(board[2] == player && board[4] == player && board[6] == player)
      {
         setWinner(player);
      }
   }
   
   public boolean hasSomeoneWon() //returns the value of hasSomeoneWon
   {
      return hasSomeoneWon;
   }
   
   public void changeTurns() //changes the turn of which player is going
   {
      if(turn == 1)
         turn = 2;
      else if(turn == 2)
         turn = 1;
   }
   
   public int getTurn() //returns which player's turn it is
   {
      return turn;
   }
   
   public int getPlayerAt(int boardLocation) //returns the player ID placed at the given board location
   {
      if(boardLocation != -1 && boardLocation <= 8)
         return board[boardLocation];
      else
         return -1;
   }
   
   public void addPlayer() //adds a player to the board
   {
      players = players + 1;
   }
   
   public void setWinner(int inputPlayer) //sets the winning player
   {
      winner = inputPlayer;
      hasSomeoneWon = true;
   }
   
   public int getWinner() //returns the winning player
   {
      return winner;
   }
   
   public int arrayToLoc(int one, int two) //given an x and y coordinate, returns the single board location number
   {
      if(one == 1)
      {
         if(two == 1)
            return 0;
         else if(two == 2)
            return 1;
         else if(two == 3)
            return 2;
         else 
            return -1;
      }
      else if (one == 2)
      {
         if(two == 1)
            return 3;
         else if(two == 2)
            return 4;
         else if(two == 3)
            return 5;
         else
            return -1;
      
      }
      else if (one == 3)
      {
         if(two == 1)
            return 6;
         else if(two == 2)
            return 7;
         else if(two == 3)
            return 8;
         else
            return -1;
      }
      else
      {
         return -1;
      } 
   }
   
   public String displayBoard() //returns a string displaying the board and all of its values
   {
      String GameBoard = board[0] + "|" + board[1] + "|" + board[2] + "\n" + "------\n" + board[3] + "|" + board[4] + "|" + board[5] + "\n" + "------\n" + board[6] + "|" + board[7] + "|" + board[8];
      return "Current Game Board Status \n" + GameBoard;
   }

}
