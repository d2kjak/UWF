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
        System.out.println("hi");
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
        String temp = "";

        while(testing){
            System.out.println("Type a command:");
            //Scanner scann = new Scanner(System.in);
            String cmd = scann.nextLine();
            out.println(cmd);
            out.flush();
            if(in.hasNextLine()){
                temp = in.nextLine();
            }
            //temp +="\n";
            System.out.println("\n"+temp+"\n");

        }


        host.close();


        //catch exception if there is an error
        
        
    }
    
    
}
