/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p5;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author djj5
 */
/******************************************************************************************************************
*This is my Game class to implement my Tic Tac Toe game
*******************************************************************************************************************/
public class Game implements Runnable{
    private TicTac board;
    private Socket pConnect;
    private Scanner scan;
    private PrintWriter pWriter;
    private int p;
    private int x, y, pos;

/*

*/  
    //my constructor method
    public Game(Socket connection, int playerNum, TicTac b){
        pConnect = connection;
        p = playerNum;
        board = b; 
    }

    
/*

*/ 
    //my run method to have each player be independent
    public void run(){
        
        try{
            try{
                scan = new Scanner(pConnect.getInputStream());
                pWriter = new PrintWriter(pConnect.getOutputStream());
            }
            finally{
                pConnect.close();
            }
        }
        catch (IOException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error");
        }
    }
    
    
    //My method to execute each move
    public void execute(String cmd){
        String[] input = cmd.split(" ");
        
        if(input[0]=="choose"){
            try{
                x = Integer.parseInt(input[1]);
                y = Integer.parseInt(input[2]);
                pos = board.boardPos(x, y);
                if(board.validMove(pos)){
                    board.move(pos, p);
                    System.out.println(p+" move to "+x+", "+y+"\n");
                    board.changeMove();
                    System.out.println("Your move now player "+ board.getMove()+"\n");
                    pWriter.println(board.toString());
                    pWriter.flush();
                }
                else{
                    System.out.println("Invalid move at "+ x + ", "+y);
                    pWriter.println(board.toString());
                    pWriter.println("----------------------------");
                    pWriter.flush();
                }
            }
            catch (Exception e) {
               pWriter.println("Error");
               pWriter.flush();
            }
        }
        else{
            pWriter.println("Wrong input");
            pWriter.println("-------------------");
            pWriter.flush();
        }
        
    }
    
    
    
    //My method for when the game is playing to follow through and occasion check if there is a winner and manage turns for each players
    public void play(){
        pWriter.println(p);
        pWriter.flush();
        
        String cmd;
        
        while(!board.wonYet()){
            if(!scan.hasNextLine()){
                return;
            }
            
            if(board.getMove() == p){
                if(board.getWinner() == 0){
                    cmd = scan.nextLine();
                    System.out.println("player "+p+"moved"+cmd);
                    if(cmd == "quit"){
                        done();
                    }
                    else{
                        execute(cmd);
                    }
                }
                else if(board.getWinner() > 0 && board.getWinner() != p){
                    pWriter.println("Player "+ board.getWinner()+" won, and you lose");
                    pWriter.println(board.toString());
                    pWriter.println("--------------");
                    pWriter.flush();
                }
                else if(board.getWinner() == p){
                    pWriter.println("You won!");
                    pWriter.println(board.toString());
                    pWriter.flush();
                }
            }
            else if(board.getMove() != p){
                cmd = scan.nextLine();
                pWriter.println("Hold on, there was a confusion");
                pWriter.flush();
                if(cmd == "quit"){
                    done();
                }
                else{
                    pWriter.println("Please wait");
                    pWriter.println(board.toString());
                    pWriter.flush();
                }
            }
            
            
        }
        pWriter.println("Player "+ board.getWinner()+"\n");
        pWriter.flush();
        
    }
    
    //My method to check if a player is quitting and to declare the other player as winner
    public void done(){
        if(p == 1){
            board.setWinner(2);
        }
        else{
            board.setWinner(1);
        }
        pWriter.println("Player "+ board.getWinner()+" won \n");
        pWriter.flush();
    }
    
}
