/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author djj5
 */
import javax.swing.*;
import java.awt.*;

public class contactFrame extends JFrame
{
   public contactFrame()
   {
     contactPanel cp = new contactPanel();
     add(cp);
   }

   public static void main(String[] args)
   {
     contactFrame cf = new contactFrame();
     cf.setSize(600,600);
     cf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     cf.setVisible(true);
   }
}