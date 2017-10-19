import java.util.Stack;
import java.util.Vector;

public class BigIntValues {

   Stack intValueStack = new Stack();
   Stack intValueStack2 = new Stack();
   
   String[] arr = new String[3];
    String firstNum = "";
    String secondNum = "";
    String sign = "";
    BigIntMath math = new BigIntMath(); 
   int firstNeg = 0;
    int secondNeg = 0;
    
    public void addToStack(String value)
    {
       
      arr = value.split(" ");
        int i=0;
        sign = arr[1];
        if(arr[0].charAt(0)=='-'){
            firstNeg = 1;
        }
        if(arr[2].charAt(0)=='-'){
            secondNeg = 1;
        }
    }
    
    public void readByChar()
    {
        int i;
        int j;

        for(i=0; i<arr[0].length(); i++){
            if(arr[0].charAt(i)!='-'){
               // firstNum = firstNum + arr[0].charAt(i);
                int temp = Integer.parseInt(arr[0].charAt(i)+ "");
                intValueStack.push(temp);

            }
            
        }
        for(j=0; j<arr[2].length(); j++)
        {   
//            if(j<arr[2].length())
            if(arr[2].charAt(j)!='-')
            {
               // firstNum = firstNum + arr[2].charAt(j);
                int temp2 = Integer.parseInt(arr[2].charAt(j)+ "");
                intValueStack2.push(temp2);

            }
            
        }
        //System.out.println("poppin' :" + intValueStack.pop()+"\n");
   
   }

   public int mathAnswer()
   {
       int x= math.mathCalculator(intValueStack, intValueStack2, sign);
       
        return x;
    }
}