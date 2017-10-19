/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *This is my Contact Class
 * @author djj5 / Delikarl Jean-Baptiste
 * Project 1
 */
import java.util.Arrays;
import java.util.*;
import java.awt.event.*;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

public class Contact{
   String name, picture, comment;
   int id = 1;
   
   //this is my constructor method
   public Contact(String name1,String pic, String cmnt, int contactID){
         this.name = name1;
         this.picture = pic;
         this.comment = cmnt;
         this.id = contactID;
   }

   
   /**
    * My setters and getters initializing methods
    * @return 
    */
   public String getName(){
        return name;
   }
   public void setName(String name){
      this.name = name;
   }
   public String getPicture(){
      return picture;
   }
   public void setPicture(String picture){
      this.picture = picture;
   }
   public String getComment(){
      return comment;
   }
   public void setComment(String comment){
      this.comment = comment;
   }
   public int getId(){
      return id;
   }
   public void setId(int id){
      this.id = id;
   }
   
   /**
    * This is my toString that will print out my outputs of name, picture, comment, and id
    *Please note that i made the unique identifiers 1, 2, 3, etc... for simplicity
    */
   public String toString()
   {
      
      String info = " \n\n"+ getId()+ " " +getName() + ": " + getComment() + "  ";
      return info;
   }
   
   
}