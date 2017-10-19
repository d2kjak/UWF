/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p4;

import javax.swing.JFrame;

/**
 *
 * @author djj5
 */

/******************************************************************************************************************
*This is my HorseFrame class that hold my main method to implement my horse race gui
*******************************************************************************************************************/
public class HorseFrame {
    
        public static void main(String[] args){
        HorseRun hr = new HorseRun();
        //creating a new frame to implement my horse race
        JFrame jf = new JFrame();
        jf.add(hr);
        jf.setSize(800, 800);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }
    
}
