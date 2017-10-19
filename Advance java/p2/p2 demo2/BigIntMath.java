import java.util.Vector;
import java.util.Stack;

public class BigIntMath {
    
    public int mathCalculator(Stack stack, Stack stack2, String sign)
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