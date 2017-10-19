import java.util.Stack;

/******************************************************************************************************************
*My big int math class that does the math with the integers given from both stacks
*******************************************************************************************************************/ 
public class BigIntMath {
    
    int count1 = 1;
    int count2 = 1;
    int i;
    int j;
    int zeroToAdd=0;
    
/******************************************************************************************************************
*My method to do calculations from both stack by either adding them or subtracting them
*******************************************************************************************************************/ 
    public int mathCalculator(Stack stack, Stack stack2, String sign, int firstNeg, int secondNeg)
    {
     
     int x = (int)stack.pop();
     int y = (int)stack2.pop();
     int z = x+y;
     System.out.println("in Math calc, x is:" + x);
     System.out.println("in Math calc, y is:" + y);
     System.out.println("in Math calc, sign is:" + sign);
    
        return z;
        
    }
    
    
}