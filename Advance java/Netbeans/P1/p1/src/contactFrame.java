/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *This is my ContactFrame Class
 * @author djj5 / Delikarl Jean-Baptiste
 * Project 1
 */
import javax.swing.*;
import java.awt.*;

//This is my frame class that extends JFrame and hold my main method

public class contactFrame extends JFrame
{
   //adding my panel to my frame
   public contactFrame()
   {
     contactPanel cp = new contactPanel();
     add(cp);
   }

   //this is my main method
   public static void main(String[] args)
   {
     contactFrame cf = new contactFrame();
     cf.setSize(600,600);
     cf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     cf.setVisible(true);
   }
}