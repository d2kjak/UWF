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
import java.awt.event.*;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

public class contactPanel extends JPanel implements ActionListener 
{
    
        ContactsArrayList contacts;
        private Image image1;
        private Image image2;
        private Image image3;
        private Image image4;
        private Image image5;
        private Image image6;
        private int x = 80;
        private int y = 80;
        int count = 0;
        
        JPanel cPanel = new JPanel();
        JButton next = new JButton("Next");


        public contactPanel()
        {
            super();
            contacts = new ContactsArrayList();
            add(next);
            next.addActionListener(this);
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            image1 = toolkit.getImage("mick.jpg");
            image2 = toolkit.getImage("keith.jpg");
            image3 = toolkit.getImage("bill.jpg");
            image4 = toolkit.getImage("charlie.jpg");
            image5 = toolkit.getImage("brian.png");
            image6 = toolkit.getImage("mickTaylor.jpg");
        }

        private void paintString(Graphics g, String text, int x, int y)
        {
            for(String line: text.split("\n"))
            g.drawString(line, x,y+=g.getFontMetrics().getHeight());
           
        }
        
        public void paintComponent(Graphics g)
        {  
           
            super.paintComponent(g);
           
            
            g.setFont(g.getFont().deriveFont(20f));
            paintString(g, contacts.toString(), 30,28);
            
           Toolkit toolkit = Toolkit.getDefaultToolkit(); 
           for(int i=0; i<contacts.getCurrentSize(); i++)
            {
               if(contacts.getContact()[i] != null){
                  Image image = toolkit.getImage(contacts.getContact()[i].getPicture());
                  g.drawImage(image,430, (i+1)*72+(i*3),150,88,this);
               }
               
            }

            
   }
        
        public void actionPerformed(ActionEvent e)
        {
            JButton source = (JButton)e.getSource();
           
            
            if(source == next){
                count++;
            }
            
            System.out.println("click! "+count);
            switch(count){
                case 1:
                     contacts.addContacts("Mick", "mick.jpg", "lead singer", 1);
                     contacts.addContacts("Keith", "keith.jpg", "Lead guitarist", 2);
                     contacts.addContacts("Bill", "bill.jpg", "Bass guitarist", 3);
                     contacts.addContacts("Charlie", "charlie.jpg", "Lead drummer", 4);
                     contacts.addContacts("Brian", "brian.png", "Songwritter who died in his pool", 5);
                     contacts.viewContacts();
                     repaint();
                    break;
                case 2:
                    contacts.sortContacts();
                    repaint();
                    break;
                case 3:
                    contacts.deleteContacts("Brian");
                    repaint();
                    break;
                case 4:
                    contacts.addContacts("Keith", "keith.jpg", "Lead guitarist", 2);
                    repaint();
                    break;
                case 5:
                    contacts.addContacts("Mick Taylor", "mickTaylor.jpg", "Guitarist who replaced Brian", 6);
                   repaint();
                    break;
                case 6:
                    System.exit(0);
                    
            }
            
        }
        
        
}
    

