
import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author djj5
 */
public class ContactsArrayList{
   
   
   private int capacity=1;
   private Contact[] contacts = new Contact[capacity];
   private int currentSize;
   
   
   private Contact[] doubleCapacity()
   {
      capacity *= 2;
      Contact[] arr1 = new Contact[capacity];;
      for(int i=0; i<currentSize; i++){
         arr1[i] = contacts[i];
      }
      return arr1;
   }
   
   public boolean isFull(){
      return currentSize == capacity;
   }
   

    public boolean inList(String name){
      for(int i=0; i<currentSize; i++){
         if(contacts[i]!=null)
         if(contacts[i].getName().equals(name)){
            return true;
         }
      }
      return false;
  }
   
   
   public int getCurrentSize(){
      return currentSize;
   }
   
   public void addContacts(String name1,String pic,String cmnt, int contactID)
   {
      
      
      if(inList(name1))
      {
         System.out.println("Contact exists \n");
         JOptionPane.showMessageDialog(new JFrame(), "Contact exists");
         return;
      }
      
      Contact contact = new Contact(name1,pic,cmnt,contactID);
      
         if(isFull())
         {
            contacts = doubleCapacity();
            contacts[currentSize] = contact;
            currentSize++;
         }
         else
         {
            contacts[currentSize] = contact;
            currentSize++;
         }
      
      
   }
   
   public Contact[] deleteContacts(String name1){
      if(inList(name1)){
         for(int i=0; i<currentSize; i++){
            if(contacts[i] != null){
               if(contacts[i].getName().equals(name1)){
                  contacts[i] = null;
               }
            }
         }
      }
      return contacts;
     
   }
   
   public Contact[] getContact(){
      return contacts;
   }
   
   public void viewContacts(){
   
      for(int i = 0; i<currentSize; i++){
         System.out.println(contacts[i].toString());
      }
   
   }
   
   
   public void sortContacts(){
     Contact temp;
      for(int i=0; i<currentSize-1; i++){
          for(int j=i+1; j<currentSize; j++){
            if(contacts[i].getName().compareTo(contacts[j].getName()) > 0){
                temp = contacts[j];
                contacts[j] = contacts[i];
                contacts[i] = temp;
            }
          }
        System.out.println(contacts[i]);
      }
   }
   
   
   public String toString()
   {
      String info="";
      for(int i=0; i<contacts.length; i++)
      {
         if(contacts[i]!=null)
         info= info + contacts[i].toString() +"\n";
      }
      return info;
   }
   
}