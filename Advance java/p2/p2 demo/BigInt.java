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
public class BigInt {
    int num;
    String operator;
    
    public BigInt(){
        num = 0;
        operator = "";
    }
    public BigInt(int n, String o){
        num = n;
        operator = o;
    }
    
    public void setNum(int n){
        num = n;
    }
    
    public int getNum(){
        return num;
    }
    
    public void setOperator(String o){
        operator = o;
    }
    
    public String getOperator(){
        return operator;
    }
}
