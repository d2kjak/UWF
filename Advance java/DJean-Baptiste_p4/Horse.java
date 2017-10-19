/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p4;

import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author djj5
 */
/******************************************************************************************************************
*This is my horse class
*******************************************************************************************************************/
public class Horse implements Runnable {
    String imgName;
    int xSize;
    int ySize;
    int horseID;
    int xPos=10;
    HorseRun hr;
    Random r = new Random();//my random variable to call later for increase the pixel by a random number when racing
    
/******************************************************************************************************************
*My constructor
*******************************************************************************************************************/   
    public Horse(String img, int x, int y, int id, HorseRun hr){
        imgName = img;
        xSize = x;
        ySize = y;
        horseID = id;
        this.hr = hr;
    }
    
   
/******************************************************************************************************************
*This is my run method for my class that implements runnable. This allows me to run my threads seperately
*******************************************************************************************************************/   
    public void run(){
        while(hr.racing){ //while racing is not false, move the picture pixel by pixel to race
            hr.sLock.lock();
                xPos += r.nextInt(12);
                hr.repaint();
            
            try{
                
                if(xPos>635){
                    hr.racing = false;
                    JOptionPane.showMessageDialog(new JFrame(), "Winner is horse number " + getHorseID());
                    
                }
                //unlocking the thread so each can run at seperate time
                hr.sLock.unlock();
                Thread.sleep(40);
            }
            catch (InterruptedException e) {
             System.out.println("Thread generates an error.");
            }
            
        }
    }

/******************************************************************************************************************
*My setters and getters for my class
*******************************************************************************************************************/
    public void setImgName(String imgName){
        this.imgName = imgName;
    }
    
    public String getImgName(){
        return imgName;
    }
    
    public void setXsize(int xSize){
        this.xSize = xSize;
    }
    
    public int getXsize(){
        return xSize;
    }
    
    public void setYsize(int ySize){
        this.ySize = ySize;
    }
    
    public int getYsize(){
        return ySize;
    }
    
    public void setHorseID(int horseID){
        this.horseID = horseID;
    }
    public int getHorseID(){
        return horseID;
    }
    
    public void setXpos(int xPos){
        this.xPos = xPos;
    }
    
    public int getXpos(){
        return xPos;
    }
    
    
    
}
