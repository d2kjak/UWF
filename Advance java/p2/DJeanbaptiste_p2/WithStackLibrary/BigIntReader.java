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

/******************************************************************************************************************
*This is my Reader class to read in the file of big integers to put in a stack to calculate
*******************************************************************************************************************/

public class BigIntReader {

   public static void main(String[] args) {
        BigIntValues intValue = new BigIntValues();
        int count1 = 0, count2=0, count3=0;
        String numbers;
        String numbers2;
        String[] value = new String[3];
        
        //My try and catch to read in the file to send to my value class to put in the big integers into a stack
        try{

            Scanner inFile = new Scanner(new BufferedReader(new FileReader("addsAndSubtracts.txt")));
            
            while(inFile.hasNextLine()){
                
                
                numbers = inFile.nextLine();
                intValue.addToStack(numbers);
                intValue.readByChar();
                System.out.println("in scanner, math is: " + intValue.mathAnswer() + "\n");
               
              
               
                count1++;
                
            }
            
            
        }
        catch(FileNotFoundException e){
            System.out.println(e.getMessage());
            System.exit(0);
        }
   }

}