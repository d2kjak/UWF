import java.util.Stack;
import java.lang.Integer;

/******************************************************************************************************************
*My class that hold the values read from the input file contain Big int values to add or subtract
*******************************************************************************************************************/
public class BigIntValues {

   Stack intValueStack = new Stack(); //My first stack
   Stack intValueStack2 = new Stack(); //My second stack
   
   String[] arr = new String[3]; //my string arr to read first n amout of integers, sign, and second n amount of integers
    String firstNum = "";
    String secondNum = "";
    int count1=0;
    int count2=0;
    String sign = "";
    BigIntMath math = new BigIntMath(); 
   int firstNeg = 0;
    int secondNeg = 0;
    int amountOfZeroes = 0;
    int i, j;
    

/******************************************************************************************************************
*my method to read the Big integer characters
*******************************************************************************************************************/
    public void readByChar()
    {
        int i;
        int j;
        System.out.println("\nin readByChar testing...\n");
/**********************************************************************************************************************************************/
        for(i=0; i<arr[0].length(); i++)
        {
            if(arr[0].charAt(i)!='-')
            {
                firstNum = firstNum + arr[0].charAt(i); //read the first n amount of numbers in character
                count1++;

            }
            
        }
        
/**********************************************************************************************************************************************/
        for(j=0; j<arr[2].length(); j++)
        {
            if(arr[2].charAt(j)!='-')
            {
                secondNum = secondNum + arr[2].charAt(j); //read the second n amount of numbers in character
                count2++;

            }
            
        }
        
/**********************************************************************************************************************************************/
        
// padding on n amount of zeroes to the string of big integers to make them of equal length
        if(count1 < count2){
            amountOfZeroes = count2 - count1;
            //System.out.println("in padZero 1st loop, zeroAmount is: " +amountOfZeroes + "\n");
            for(i=0; i<amountOfZeroes; i++){
                firstNum = "0" + firstNum;
            }
        }
        System.out.println("\nin readByChar first num after checking equal lengths(zero) is..." + firstNum + "\n");
/**********************************************************************************************************************************************/
        
// padding on n amount of zeroes to the string of big integers to make them of equal length
        if(count2 < count1){
            amountOfZeroes = count1 - count2;
            //System.out.println("in padZero 1st loop, zeroAmount is: " +amountOfZeroes + "\n");
            for(i=0; i<amountOfZeroes; i++){
                secondNum = "0" + secondNum;
            }
        }
        System.out.println("\nin readByChar second num after checking equal lengths(zero) is..." + secondNum + "\n");
        
    }
    

/******************************************************************************************************************
*My method to add the big integers on to the stack after padded on the n amount of zeroes
*******************************************************************************************************************/
    public void addToStack(String value)
    {
        
        System.out.println("\nin addToStack testing...\n");
      
        arr = value.split(" "); //we are delimiting by space values
        int i=0;
        sign = arr[1];
        if(arr[0].charAt(0)=='-'){
            firstNeg = 1;
        }
        if(arr[2].charAt(0)=='-'){
            secondNeg = 1;
        }
        int a=0;
        int b=0;
        int x, y;
        //add the first n amount of big integers on to the first stack
        while(a<firstNum.length()){
            
            x = Integer.parseInt(firstNum.charAt(a)+ "");
            intValueStack.push(firstNum.charAt(x));
            a++;
            //System.out.println("\nin addToStack loop x is..."+ x + "\n");
            
        }
        //add the first n amount of big integers on to the second stack
        while(b<secondNum.length()){
            y = Integer.parseInt(secondNum.charAt(b)+ "");
            intValueStack2.push(secondNum.charAt(y));
            b++;
        }
        
    }
    
/******************************************************************************************************************
*My method to do all the calculations and return the answer added on to the stack
*******************************************************************************************************************/    
   public int mathAnswer()
   {
      System.out.println("in mathAnswer function, testing \n");
       int x= math.mathCalculator(intValueStack, intValueStack2, sign, firstNeg, secondNeg);
       
       
        return x;
    }
    
    
}