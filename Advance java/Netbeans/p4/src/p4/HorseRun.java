/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p4;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author djj5
 */
/******************************************************************************************************************
*This is my horse run that creates an array of horse to run using threads
*******************************************************************************************************************/
public class HorseRun extends JPanel{
    
    Horse[] h = new Horse[5];
    boolean racing = true;
    int threads = 5;
    Thread thread = new Thread();
    
    Lock sLock;
    //getting my jbuttons
    final JPanel j1 = new JPanel();
    final JButton bStart = new JButton("start");
    final JButton bRestart = new JButton("restart");
    final JButton bExit = new JButton("exit");
    
/******************************************************************************************************************
*setting up my horses and actionListeners for my buttons
*******************************************************************************************************************/    
    public HorseRun(){
        h[0] = new Horse("h1.jpg", 150,88, 1, this);
        h[1] = new Horse("h2.jpg", 150,88, 2, this);
        h[2] = new Horse("h3.jpg", 150,88, 3, this);
        h[3] = new Horse("h4.jpg", 150,88, 4, this);
        h[4] = new Horse("h5.jpg", 150,88, 5, this);
        sLock = new ReentrantLock();
        add(bStart);
        add(bRestart);
        add(bExit);
        ActionListener listen = new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e){
        JButton button = (JButton)e.getSource();
        //race when the race button is clicked
        if (button == bStart){
            race();
        }
        //go back to the starting line when restart is clicked
        if (button == bRestart){
            restart();
            
        }
        //exit indefinetly when exit is clicked
        if (button == bExit){
            System.exit(0);
        }
    }
};
        bStart.addActionListener(listen);
        bRestart.addActionListener(listen);
        bExit.addActionListener(listen);
        
    }
    
/******************************************************************************************************************
*This is my method to set a thread for each horse in the array
*******************************************************************************************************************/    
    public void race(){
        racing = true;
        int i;
        Thread[] t = new Thread[5];
        for(i=0; i<threads; i++){
            
            t[i] = new Thread(h[i]);
            t[i].start();
        }
    }
/******************************************************************************************************************
*My restart method that first set racing to false(stops) and reseting my x position for the pictures
*******************************************************************************************************************/   
    public void restart(){
        int i;
        racing = false;
        for(i=0; i<threads; i++){
            h[i].setXpos(10);
            repaint();
        }
        //race();
        
    }
   
/******************************************************************************************************************
*This is my paint component method to open my horse images
*******************************************************************************************************************/   
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Toolkit toolkit = Toolkit.getDefaultToolkit(); 
        for(int i=0; i<h.length; i++){
            Image img = toolkit.getImage(h[i].getImgName());
            g.drawImage(img,h[i].getXpos(), (i*100)+100,h[i].getXsize(),h[i].getYsize(),this);
        }
    }
    
  
    
    
}
