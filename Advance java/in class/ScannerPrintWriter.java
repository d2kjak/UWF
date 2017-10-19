/***************************************************************
  Student Name: Delikarl Jean-baptiste
  File Name: ScannerPrintWriter
***************************************************************/

import java.util.*;
import java.io.*;

public class ScannerPrintWriter{
   private ArrayList<Integer> il = new ArrayList<Integer>();
  
   public void test(){
      String fname = getFileName();
      System.out.println("[ " + fname + " ]");
      readFile(fname);
      show();
     
   }
  
   public String getFileName(){
      Scanner sc = new Scanner(System.in);
      System.out.println("enter file name");
      String name = sc.nextLine();
      return name;
   }
  
   public void readFile(String fname){
      System.out.println("Start of read file \n" + fname + "\n");
      try{
         Scanner sc = new Scanner(new File(fname));
         while(sc.hasNextInt()){
            int val = sc.nextInt();
            System.out.println(val);
            il.add(val);
         }
      }
      catch(Exception e) {
         e.printStackTrace();
      }
   }
  
   public void show(){
      System.out.println("showing..... \n");
      for(Integer i : il){
         System.out.println(i);
      }
   }
  
   public static void main(String[] args) {
      ScannerPrintWriter sc = new ScannerPrintWriter();
      sc.test();
   }
}


