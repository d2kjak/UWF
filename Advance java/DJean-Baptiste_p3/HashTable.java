
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author djj5
 */


/******************************************************************************************************************
*This is my HashTable/Dictionary implementation class
*******************************************************************************************************************/

public class HashTable {
    private Node[] table;
    private final int TABLESIZE = 210011; //setting max table size
    private final int characters = 26;
    
    
    public class Node{
        private String word;
        private Node nextNode;
        
        //my constructor
        public Node(String w, Node next){
        word = w;
        nextNode = next;
        }
    }
    
    
    public HashTable()
    {
        table = new Node[TABLESIZE];
        for(int i = 0; i < TABLESIZE; i++)
            table[i] = null;
        System.out.println("Done");
    }
    
    //My hashing function to hash the word passed into an index to get a key
    public int hash(String word){
        String temp = word;
        int value = 37;
        int i;
        for(i=0; i<temp.length();i++){
            value *=(i+1) * (int)temp.charAt(i);
        }
        if(value<0){
            value*= -1;
        }
        return (value % TABLESIZE);
    }
/******************************************************************************************************************
*My add function that takes a word and hash it into the hash table
*******************************************************************************************************************/    
    public void add(String word){
        int keyValue = hash(word);//gets and hold the key value for where the word is hashed to
        Node tempNode = new Node(word, table[keyValue]);
        table[keyValue] = tempNode;
    }
    
    
/******************************************************************************************************************
*My build table function that reads in the file, takes each words one by one and hash it unto the table
*******************************************************************************************************************/
    public void buildTable(){
        System.out.println("Building Table......");
        
        try{
            Scanner inFile = new Scanner(new BufferedReader(new FileReader("test.txt")));
            while(inFile.hasNext()){
                add(inFile.next());//adding the words in to the table
            }
            inFile.close(); // closing the file
        }
        catch(FileNotFoundException e){
            System.out.println("Could not open file\n");
            System.out.println(e.getMessage());
            System.exit(0);
        }
       
    }
    
    
/******************************************************************************************************************
*This is my function to open the other file that i will be checking for spell error
*******************************************************************************************************************/   
    public void fileToCheckSpelling(){
        ArrayList<String> words = new ArrayList<String>();
        HashTable ht = new HashTable();
        int i;
        String temp;
        try{
            Scanner inFile = new Scanner(new BufferedReader(new FileReader("inputTextFile.txt")));//my scanner to open the file
            while(inFile.hasNext()){
                words.add(inFile.next());//adding the word unto the array list
            }
            inFile.close();
        }
        catch(FileNotFoundException e){
            System.out.println(e.getMessage());
            System.exit(0);
        }
        
        for(i=0; i<words.size(); i++){
            temp=words.get(i);//getting each word to throw in to my functions to find suggestions
            ht.letterMissing(temp);
            ht.letterChanged(temp);
            ht.twoLetterReversed(temp);
            ht.oneLetterAdded(temp);
        }
    }

/****************************************************************************************************************************
*My look up function. It takes in a word and searches it in the hash table, if it is found then it says so, else it is false
****************************************************************************************************************************/
    public boolean lookUp(String word){
        boolean found = false;
        int keyValue2 = hash(word);//gets and hold key value for the word
        while(!found && table[keyValue2] !=null){
            if(table[keyValue2].word.equals(word)){ //if found return true
                return true;
            }
            else{ // else check next index
                table[keyValue2] = table[keyValue2].nextNode;
            }
        }
        return found; // return the value of found
    }
    
    
/******************************************************************************************************************
*This is my function to find suggestions if a letter is missing from the word passed to it
*******************************************************************************************************************/
    public void letterMissing(String word){
        HashTable ht = new HashTable();
        StringBuffer sb = new StringBuffer(word);
        String temp;
        int i, j;
        for(i = 0; i < word.length(); i++)  
	     {
            
            for(j = 0; j <characters; j++) {
            
            temp = sb.substring(j);
            
      		sb.insert(i, (char)('a' + j));
      		System.out.println(" one letter deleted = " + sb);
      		sb.deleteCharAt(i);
            boolean result = ht.lookUp(sb.toString());
            
            
            
            if(result == true){;
               ht.suggestions(sb.toString());
            }
            
   		}
         
   	}
        
   }
    
    
/******************************************************************************************************************
*This is my function to find suggestions if a letter is changed in the word that is passed to it
*******************************************************************************************************************/  
    public void letterChanged(String word){
        HashTable ht = new HashTable();
        int i, j;
        String temp;
        String temp2;
        
        for (i=0; i<word.length();i++){
            temp=helpMe(i, word);
            temp2=helpMe(i, word);
            StringBuffer sb = new StringBuffer(temp);
            for(i = 0; i < temp.length(); i++)  
            {
                for(j = 0; j <characters; j++) {
                    sb.insert(i, (char)('a'+j));
                    System.out.println(" one letter deleted = " + sb);
                     sb.deleteCharAt(i);
                     boolean result = ht.lookUp(sb.toString());
                     if(result == true){
                        ht.suggestions(sb.toString());
                     }
                }
            }
            
        }
    } 


    public String helpMe(int a, String word){
        int i, j;
        String temp ="";
        for(i=0; i<word.length(); i++){
            if(i != a){
                temp = temp + word.charAt(i);
            }
        }
        return temp;
    }
    
    
/******************************************************************************************************************
*This is my function to give suggestions if a word have an additional letter added unto it
*******************************************************************************************************************/
    public void oneLetterAdded(String word){
        HashTable ht = new HashTable();
        StringBuffer sb = new StringBuffer(word);
        
        int i, j;
        String temp;
        for(i=0; i<word.length(); i++){
            temp = helpMe(i, word);
            System.out.println("in add to delete " + temp);
            boolean result = ht.lookUp(temp);
            if(result == true){
               ht.suggestions(temp);
            }
        }
        
        
    }
    
   
/******************************************************************************************************************
*This is my function to give suggestions if a word have two letters reversed
*******************************************************************************************************************/
    public void twoLetterReversed(String word){
        HashTable ht = new HashTable();
        StringBuffer sb = new StringBuffer(word);
        int i, j;
        char c1;
        char c2;
        for(i=0; i<word.length()-1; i++){
            j=i;
            c1 = sb.charAt(i);
            c2 = sb.charAt(i+1);
            sb.setCharAt(i, c2);
            sb.setCharAt(j+1, c1);
            //System.out.println(" two letter reversed = " + sb);
            boolean result = ht.lookUp(sb.toString());
            if(result == true){
               ht.suggestions(sb.toString());
            }
        }
    }

    
/******************************************************************************************************************
*This is my suggestion function that get words that are passed to it that may be a suggestive word, and added unto an arraylist
*******************************************************************************************************************/
    public void suggestions(String word){
         HashTable ht = new HashTable();
         ArrayList<String> list = new ArrayList<String>();
         //boolean result = ht.lookUp(word);
         list.add(word);
         for(int i=0;i<list.size();i++){
             System.out.println("in suggestion, list is " + list.get(i));
         }
         if(list.size() < 1){
             System.out.println("Could not find suggestions for you");
         }
         
         
    }
    
    

/******************************************************************************************************************
*This is my main function to run and test all my functions
*******************************************************************************************************************/
    
    public static void main(String[] args){
        HashTable ht = new HashTable();
        
        ht.buildTable();
        //ht.fileToCheckSpelling();
        System.out.println("\n\n\n");
        
        //System.out.println(ht.lookUp("catt"));
        //ht.letterMissing("ct");//working
        //ht.letterChanged("cot");
        //ht.twoLetterReversed("fuor");//working
        ht.oneLetterAdded("catt");//working
    }
    
    
    
}
