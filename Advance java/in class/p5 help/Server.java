/**
  Student Name: Alberto Medeiros
  File Name: Server.java
  Programming Project 5
  The server class, accepts two client sockets and creates two threads of GameController
*/

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
   public static void main(String[] args) throws IOException
   {  
      final int SBAP_PORT = 8888;
      ServerSocket server = new ServerSocket(SBAP_PORT);
      Game tictac = new Game();
      System.out.println("Waiting for players to connect.");
      
   
      Socket one = server.accept();
      System.out.println("Player 1 has connected.");
      tictac.addPlayer();
         
      Socket two = server.accept();
      System.out.println("Player 2 has connected.");
      tictac.addPlayer();
         
         //GameController theGame = new GameController(one, two, tictac);
      GameController oneCont = new GameController(one,1,tictac);
      GameController twoCont = new GameController(two,2,tictac);
      Thread a = new Thread(oneCont);
      Thread b = new Thread(twoCont);
      a.start();
      b.start();
         
         
         //Thread t = new Thread(theGame);
         //t.start();
   }

    
}
