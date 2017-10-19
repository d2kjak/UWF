/**
  Student Name: Alberto Medeiros
  File Name: GameController.java
  Programming Project 5
  This is the GameController class. It is a runnable that executes the game logic by reading from and writing to the client
*/
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class GameController implements Runnable {

   private Socket connection;
   private Scanner in;
   private PrintWriter out;
   private Game ticGame;
   private int player;

   public GameController(Socket playerConnection, int playerID, Game inputGame) { //creates a GameController instance, using the given Socket, the player's ID, and the Game object
      connection = playerConnection;
      player = playerID;
      ticGame = inputGame;
   }

   public void run() { //run method, creates input and output stream readers/writers, and executes runGame()
      try {
         try {
            in = new Scanner(connection.getInputStream());
            out = new PrintWriter(connection.getOutputStream());
            runGame();
         } 
         finally {
            connection.close();
         }
      } 
      catch (IOException e) {
         e.printStackTrace();
      }
   }
   public void runGame() throws IOException {
      out.println(player); //sends the player his initial ID
      out.flush();
      String command;
   
      while (!ticGame.hasSomeoneWon()) { //only runs while someone hasn't won
         if (!in.hasNextLine()) { //if nothing is being received, do nothing
            return;
         }
      
         if (ticGame.getTurn() == player) { //executes commands only if it is the current player's turn to move
            if (ticGame.getWinner() == 0) {
               command = in.nextLine();
               System.out.println("Player " + player + " has sent: " + command);
               if (command.equalsIgnoreCase("quit")) {
                  quitGame();
               } 
               else {
                  doCommand(command);
               }
            } 
            else if (ticGame.getWinner() == player) {
               out.println("Congratulations, you have won!");
               out.println("close");
               out.flush();
            } 
            else if (ticGame.getWinner() > 0 && ticGame.getWinner() != player) {
               out.println("Player " + ticGame.getWinner() + " has won. Sorry");
               out.println(ticGame.displayBoard());
               out.println("close");
               out.flush();
            }
         
         } 
         else if (ticGame.getTurn() != player) { //executes responses for when it is not the player's turn to move
            if (ticGame.getWinner() == 0) {
               command = in.nextLine();
               System.out.println("Player " + player + " has sent: " + command + ", but it is not their turn.");
               if (command.equalsIgnoreCase("quit")) {
                  quitGame();
               } 
               else {
                  out.println("It is currently not your turn. Please Wait.");
                  out.println(ticGame.displayBoard());
                  out.println("end");
                  out.flush();
               }
            } 
            else if (ticGame.getWinner() == player) {
               out.println("Congratulations, you have won!");
               out.println("close");
               out.flush();
            } 
            else if (ticGame.getWinner() > 0 && ticGame.getWinner() != player) {
               out.println("Player " + ticGame.getWinner() + " has won. Sorry");
               out.println(ticGame.displayBoard());
               out.println("close");
               out.flush();
            }
         }
      }
      out.println("Player " + ticGame.getWinner() + " has won.");
      out.println("close");
      out.flush();
   }

   public void doCommand(String input) { //executes the command given by the player
      String[] commands = input.split(" ");
      {
         if (commands[0].equalsIgnoreCase("choose")) {
            try {
               //int a = Integer.parseInt(commands[1]); //player, irrelevant really
               int b = Integer.parseInt(commands[1]);
               int c = Integer.parseInt(commands[2]);
               int position = ticGame.arrayToLoc(b, c);
               if (ticGame.canPlaceShape(position)) {
                  ticGame.placeShape(position, player);
                  System.out.println("PLACED POINT AT " + b + ", " + c);
                  ticGame.changeTurns();
                  System.out.println("CHANGED TURNS. IT IS NOW PLAYER " + ticGame.getTurn() + "'S TURN.");
                  out.println("PLACED POINT AT " + b + ", " + c);
                  out.println(ticGame.displayBoard());
                  out.println("end");
                  out.flush();
               
               } 
               else {
                  System.out.println("Could not place a point at board location " + b + "," + c);
                  out.println("Location " + b + ", " + c + " has already been taken by player " + ticGame.getPlayerAt(position) + ", try again.");
                  out.println(ticGame.displayBoard());
                  out.println("end");
                  out.flush();
               }
            } 
            catch (Exception e) {
               out.println("Invalid command.");
               out.println("end");
               out.flush();
            }
         } 
         else if (commands[0].equalsIgnoreCase("view")){
            out.println(ticGame.displayBoard());
            out.println("end");
            out.flush();
         } 
         else {
            out.println("Invalid command");
            out.println("end");
            out.flush();
         }
      }
   }

   public void quitGame() { //sets a winner and quits the game
      if (player == 1) {
         ticGame.setWinner(2);
      } 
      else if (player == 2) {
         ticGame.setWinner(1);
      }
      out.println("You have quit the game. Player " + ticGame.getWinner() + " has won.");
      out.println("close");
      out.flush();
   }
}
