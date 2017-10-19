/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p5;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author djj5
 */
/******************************************************************************************************************
*This is my Tic Tac Toe Client class that connects to the server. --I will be connecting 2 clients with it
*******************************************************************************************************************/
public class TicClient {
    
    
    public static void main(String[] args) throws IOException {
        final int cPort = 8888; //my port number for connection
        boolean testing = true;
        TicTac tic = new TicTac();
        Socket host = new Socket("localhost", cPort);
        InputStream inStream = host.getInputStream();
        OutputStream outStream = host.getOutputStream();
        Scanner in = new Scanner(inStream);
        Scanner scann = new Scanner(System.in);
        PrintWriter out = new PrintWriter(outStream);
        System.out.println("ok");
        
try{
        while(testing){
            String temp = "";
            System.out.println("Type in your move (player number, row, column):");
            //Scanner scann = new Scanner(System.in);
            String cmd = scann.nextLine();
            cmd+="\n";
            tic.toString();
            out.println(cmd);
            out.flush();
            if(in.hasNextLine()){
                temp = in.nextLine();
            }
            temp +="\n";
            System.out.println("\n"+temp+"\n");
            
            if(tic.wonYet()==true){
                testing = false;
            }
            

        }


        host.close();
 
    }
catch (Exception e) {
         System.out.println("Error");
      }
    }
    
    
}
