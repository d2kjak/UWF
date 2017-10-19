

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *Project 2 calculating big integers using stacks
 * @author djj5
 */
public class Stack {
    private int max;
    private int[] stackArray;
    private int top;
    
    private Stack(int m){
        max = m;
        stackArray = new int[max];
        top = -1;
    }
    
    public void push(int i){
        stackArray[top++]=i;
    }
    
    public int pop(){
        return stackArray[top--];
    }
    
    public boolean isEmpty(){
        return top==-1;
    }
    
    public int peek(){
        return stackArray[top];
    }
    
}
