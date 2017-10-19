import java.util.Stack;

/******************************************************************************************************************
*My class that hold the values read from the input file contain Big int values to add or subtract
*******************************************************************************************************************/
public class BigIntValues {

   Stack intValueStack = new Stack(); //My first stack
   Stack intValueStack2 = new Stack(); //My second stack
   
   String[] arr = new String[3]; //my string arr to read first n amout of integers, sign, and second n amount of integers
    String firstNum = "";
    String secondNum = "";
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

        for(i=0; i<arr[0].length(); i++)
        {
            if(arr[0].charAt(i)!='-')
            {
                firstNum = firstNum + arr[0].charAt(i); //read the first n amount of numbers in character
                //int temp = Integer.parseInt(arr[0].charAt(i)+ "");
                //intValueStack.push(temp);

            }
            
        }
        for(j=0; j<arr[2].length(); j++)
        {   
//            if(j<arr[2].length())
            if(arr[2].charAt(j)!='-')
            {
                secondNum = secondNum + arr[2].charAt(j); //read the second n amount of numbers in character
                //int temp2 = Integer.parseInt(arr[2].charAt(j)+ "");
                //intValueStack2.push(temp2);

            }
            
        }
    }

/******************************************************************************************************************
*My method to pad on n amount of zeroes to the string of big integers to make them of equal length
*******************************************************************************************************************/
    public void padOnZeroes(){

        if(firstNum.length()<=secondNum.length()){
            amountOfZeroes = secondNum.length() - firstNum.length();
            for(i=0; i<=amountOfZeroes; i++){
                firstNum = "0" + firstNum;
            }
        }
        if(secondNum.length() <=firstNum.length()){
            amountOfZeroes = firstNum.length() - secondNum.length();
            for(i=0; i<=amountOfZeroes; i++){
                secondNum = "0" + secondNum;
            }
        }
    
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
        
        padOnZeroes(); //calling the padOnZeroes to pad on the amount of zeroes necessary before we push on to the stack
        int a=0;
        int b=0;
        int x, y;
        //add the first n amount of big integers on to the first stack
        while(a<firstNum.length()){
            
            x = Integer.parseInt(firstNum.charAt(a)+ "");
            intValueStack.push(firstNum.charAt(x));
            a++;
            
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
      System.out.println("in mathAnswer, testing \n");
      System.out.println("in mathAnswer2, testing \n");
       int x= math.mathCalculator(intValueStack, intValueStack2, sign, firstNeg, secondNeg);
       System.out.println("in mathAnswer3, testing \n");
       //viewStack();
       
       
        return x;
    }
    
   /*
    public void viewStack(){
      for(int i=0; i<=8; i++){
         System.out.println("\nshowing stack1: ");
         intValueStack.pop();
         System.out.println("\nshowing stack2: ");
         intValueStack2.pop();
      }
    }*/
    
    
}