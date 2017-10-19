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

   public static void main(String[] args) {
        BigIntValues intValue = new BigIntValues();
        int count1 = 0, count2=0, count3=0;
        String numbers;
        String numbers2;
        String[] value = new String[3];
        String a = "+";
        String b = "-";
        
        
        try{

            Scanner inFile = new Scanner(new BufferedReader(new FileReader("addsAndSubtracts.txt")));
            
            while(inFile.hasNextLine()){
                numbers = inFile.nextLine();
          
                intValue.addToStack(numbers);
                intValue.readByChar();
                System.out.println("in scanner, math is: " + intValue.mathAnswer() + "\n");
               
              
               
                count1++;
            }
           
            /*
            for(String s: bigInt){
                System.out.println("\nin bigInt LL:"+ bigInt + "\n");
            }
            for(String r: bigInt){
                System.out.println("\nin list2 LL: "+ bigInt2 + "\n");
            }*/
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