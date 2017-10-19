/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2;

/**
 *
 * @author djj5
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.*;
import java.util.Vector;
import java.util.Stack;
public class BigIntReader {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Scanner inFile = null;
    
        BigIntValues intValue = new BigIntValues();
        int count1 = 0, count2=0, count3=0;
        String numbers;
        String numbers2;
        String[] value = new String[3];
        String a = "+";
        String b = "-";
      /*  LinkedList<String> bigInt = new LinkedList<String>();
        LinkedList<String> bigInt2 = new LinkedList<String>();
        LinkedList<String> bigInt3 = new LinkedList<String>();*/
       
        try{
            //BufferedReader inFile = new BufferedReader(new FileReader("addsAndSubtracts.txt"));
            Scanner inFile = new Scanner(new BufferedReader(new FileReader("addsAndSubtracts.txt")));
            /*while(inFile.hasNext()){
                String file = inFile.next();
                count1++;
            }*/
            while(inFile.hasNextLine()){
                numbers = inFile.nextLine();
                //value = numbers.split(" ");
                //bigInt.add(numbers);
                //intValue.addToStack(numbers);
                //BigIntValues intValue = new BigIntValues();
                intValue.addToStack(numbers);
                intValue.readByChar();
                //System.out.println("int main: " + intValue.getFirstNum());
                
                
                //intValue
                /*if(bigInt.contains(a) || bigInt.contains(b)){
                    numbers2 = inFile.nextLine();
                    list2.add(numbers2);
                    count2++;
                    return;
                }*/
                count1++;
            }
           
          /*  
            for(String s: bigInt){
                System.out.println("\nin bigInt LL:"+ bigInt + "\n");
            }
            /*for(String r: bigInt){
                System.out.println("\nin list2 LL: "+ bigInt2 + "\n");
            }
            for(int j=0; j<3; j++){
                System.out.println("\n My value(s) is: " + value[j] + "\n");
            }
            System.out.println("\ncount1 = " + count1 + "\n");
            System.out.println("\ncount1 = " + count2 + "\n");
            
            /*Iterator i = bigInt.iterator();
            while(i.hasNext()){
                if(i.charAt(0)== "-"){
                
                }
            }*/
            
            
        }
        catch(FileNotFoundException e){
            System.out.println(e.getMessage());
            System.exit(0);
        }
        
    }
    
    
    
}
