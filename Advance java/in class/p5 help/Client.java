/**
  Student Name: Alberto Medeiros
  File Name: Client.java
  Programming Project 5
  The client class, handles sending and receiving commands/messages to and from the server.
*/
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

   public static void main(String[] args) throws IOException {
      final int SBAP_PORT = 8888;
      int playerID;
      boolean ranOnce = true;
   
      System.out.println("Attempting to connect to host.");
      try {
         Socket host = new Socket("localhost", SBAP_PORT);
         InputStream instream = host.getInputStream();
         OutputStream outstream = host.getOutputStream();
         Scanner in = new Scanner(instream);
         PrintWriter out = new PrintWriter(outstream);
         boolean running = true;
         Scanner keyInput = new Scanner(System.in);
         String command;
         String response = null;
      
         System.out.println("Succesfully connected to the host.");
         System.out.println("Awaiting player assignment.." );
         playerID = in.nextInt();   //awaits for server to assign Player ID
         System.out.println("You are player: " + playerID);
      
         while (running) {
            System.out.println("Type a command:");
            command = keyInput.nextLine();
            System.out.println("Sending Command: " + command);
            out.println(command);
            out.flush();
            boolean reading = true;
            if (ranOnce) //Gets rid of an unecesarry line that occurs once, for reasons unknown to me.
            {
               String temp = in.nextLine();
               ranOnce = false;
            }
            while (reading) {
               response = in.nextLine();
            
               if (response.equalsIgnoreCase("end")) { //if receives the "end" message, terminates listening from the server
                  reading = false;
               } 
               else if (response.equalsIgnoreCase("close")) {
                  System.out.println("Game Over.");
                  System.exit(0);
               }
               else {
                  System.out.println("[Server]:" + response);
               }
            }
         }
      
         host.close();
      } 
      catch (Exception e) {
         System.out.println("Failure connecting to the host.");
      }
   }
}
