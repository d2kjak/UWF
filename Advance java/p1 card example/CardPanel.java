
  
  /**
    Programmer: John Coffey
    Purpose:A component to draw cards
  **/


import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

/*
   
*/
public class CardPanel extends JPanel implements ActionListener
{  

   private Image image;
   JButton b = new JButton("Next");
   private int x = 120; 
   private int y = 120;
   
   public CardPanel()
   {
     add(b);
     b.addActionListener(this);
     Toolkit toolkit = Toolkit.getDefaultToolkit();
     image = toolkit.getImage("card.png");
   }
   
   public void actionPerformed(ActionEvent e)
   {
   System.out.println("in al");
     Object source = e.getSource();
     if(source == b)
     {
       repaint();
     }
   }
   
   
   public void paintComponent(Graphics g)
   {  
     g.clearRect(0,0,1000,1000);
     g.drawString("here is the card", 100,90);
     g.drawImage(image,x,y,this);
     x+=10; y+=10;
     if(x>300)
       x = 120;
     if(y > 300)
       y = 120;
   }
}
