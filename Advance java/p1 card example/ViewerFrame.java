
  
  /**
    Programmer: John Coffey
    Purpose:A simple GUI program demo
  **/
  
import javax.swing.*;
import java.awt.*;

public class ViewerFrame extends JFrame
{
   public ViewerFrame()
   {
     CardPanel p = new CardPanel();
     add(p);
   }

   public static void main(String[] args)
   {
     ViewerFrame v = new ViewerFrame();
     v.setSize(400,400);
     v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     v.setVisible(true);
   }
}
