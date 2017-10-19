/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p5;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author djj5
 */
/******************************************************************************************************************
*My Tic Tac Toe Server class
*******************************************************************************************************************/
public class TicServer {

    /**
     * @param args the command line arguments
     */
    //new instance of my Tic Tac class to create a board
    static TicTac board = new TicTac();
/******************************************************************************************************************
*My main that will allow me to run a connection for my clients to connect to through port 8888
*******************************************************************************************************************/
    public static void main(String[] args) throws IOException {
        final int sPort = 8888; //my port number for connection
        ServerSocket ss = new ServerSocket(sPort);
        System.out.println("Connecting........");
        
        Socket s1 = ss.accept();
        System.out.println("\nPlayer 1 connected Connected!\n");
        
        Socket s2 = ss.accept();
        System.out.println("\nPlayer 2 connected Connected!\n");
        try{
            while (true){

                //setting up player 1 and player 2
                Game player1 = new Game(s1, 1, board);
                Game player2 = new Game(s2, 2, board);

                Thread t1 = new Thread(player1);
                Thread t2 = new Thread(player2);

                t1.start();
                t2.start();
            }
        }
        finally{
            ss.close();
        }
        
        
    }
    
}
