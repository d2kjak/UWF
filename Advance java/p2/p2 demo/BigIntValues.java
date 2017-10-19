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
import java.util.Stack;
import java.util.Vector;

public class BigIntValues {
    
    Stack intValueStack = new Stack();
    Stack intValueStack2 = new Stack();
    //Stack operatorStack = new Stack();
    String[] arr = new String[3];
    String firstNum = "";
    String secondNum = "";
    BigIntMath math = new BigIntMath(); 
   int firstNeg = 0;
    int secondNeg = 0;
    
    
    public void addToStack(String value)
    {
        //String v = ;
        arr = value.split(" ");
        int i=0;
        /*while(i<arr.length){
            System.out.println("" + arr[i]);
            i++;
        }*/
        if(arr[0].charAt(0)=='-'){
            firstNeg = 1;
        }
        if(arr[2].charAt(0)=='-'){
            secondNeg = 1;
        }
        
      
    }
    public void readByChar(){
        int i;
        //int j;
        for(i=0; i<arr[0].length(); i++){
            if(arr[0].charAt(i)!='-'){
                firstNum = firstNum + arr[0].charAt(i);
                int temp = Integer.parseInt(arr[0].charAt(i)+ "");
                intValueStack.push(temp);
                //System.out.println("in loop: "+ firstNum);
            }
            
        }
        /*
        for(j=0; j<arr[2].length(); j++){
            if(arr[2].charAt(j)!='-'){
                firstNum = firstNum + arr[2].charAt(j);
                int temp = Integer.parseInt(arr[2].charAt(j)+ "");
                intValueStack2.push(temp);
                //System.out.println("in loop: "+ firstNum);
            }
            
        }*/
    }
//    public Stack getFirstStack(){
//        /*for(int i=0; i<firstNum.length(); i++){
//            System.out.println("poppin' :" + intValueStack.pop()+"\n");
//        }*/
//        return intValueStack;
//    }
    /*
    public Stack getSecondStack(){
        return intValueStack2;
    }*/
    /*
    public static void main(String[] args){
        BigIntValues intValue = new BigIntValues();
        intValue.addToStack("-576546 - 897987");
        intValue.readByChar();
        System.out.println("int main: " + intValue.getFirstNum());
    }*/
    public int mathAnswer(){
        math.mathCalculator(intValueStack);
        return 1;
    }
    
}
