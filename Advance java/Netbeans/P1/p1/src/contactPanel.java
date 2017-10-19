/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *This is my ContactPanel Class
 * @author djj5 / Delikarl Jean-Baptiste
 * Project 1
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

//ContactPanel class the extends JPanel and implements an actionListener for one button called "next"
public class contactPanel extends JPanel implements ActionListener 
{
    
        //my (private) instance variables
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

        //my contactPanel construct that calls super and get my images and connects my next button to actionListener
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
        
        //formatting my strings (the out that has the name, id, etc....)
        private void paintString(Graphics g, String text, int x, int y)
        {
            for(String line: text.split("\n"))
            g.drawString(line, x,y+=g.getFontMetrics().getHeight());
           
        }
        
        //My paint component method
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
        
        //This is my actionPerformed event listener for my next button
        public void actionPerformed(ActionEvent e)
        {
            JButton source = (JButton)e.getSource();//getting the source ("next")
           
            //increments my count variable everytime the next button is clicked
            if(source == next){
                count++;
            }
            
            //System.out.println("click! "+count);
            //implement a switch statement that will do different events/things everytime the next button is clicked
            switch(count){
                //first event creats 5 new contacts
                case 1:
                     contacts.addContacts("Mick", "mick.jpg", "lead singer", 1);
                     contacts.addContacts("Keith", "keith.jpg", "Lead guitarist", 2);
                     contacts.addContacts("Bill", "bill.jpg", "Bass guitarist", 3);
                     contacts.addContacts("Charlie", "charlie.jpg", "Lead drummer", 4);
                     contacts.addContacts("Brian", "brian.png", "Songwritter who died in his pool", 5);
                     contacts.viewContacts();
                     repaint();
                    break;
                //second event sorts the contact my calling my sortArray method from my ContactsArrayList class
                case 2:
                    contacts.sortContacts();
                    repaint();
                    break;
                //third event deletes the brian contact
                case 3:
                    contacts.deleteContacts("Brian");
                    repaint();
                    break;
                //fourth event add a new contact called keith, which will not work as we already have a contact call keith
                case 4:
                    contacts.addContacts("Keith", "keith.jpg", "Lead guitarist", 2);
                    repaint();
                    break;
                //fifth even creates a new contact called mick Taylor
                case 5:
                    contacts.addContacts("Mick Taylor", "mickTaylor.jpg", "Guitarist who replaced Brian", 6);
                   repaint();
                    break;
                //sixth event exits the event panel and frame
                case 6:
                    System.exit(0);
                    
            }
            
        }
        
        
}
    

