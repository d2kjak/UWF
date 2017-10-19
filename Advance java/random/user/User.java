/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

/**
 *
 * @author djj5
 */
import java.util.Scanner;

public class User {
	
	private static String username;
	private static String clearPassword;
	private String encryptedPassword;
	private static String key;
	
	public User ()
	{
		this.username = " ";
		this.clearPassword = " ";
		this.encryptedPassword = " ";
		this.key = " ";
		
	}
   
   public User(String username, String clearPassword, String key)
   {
      this.username = username;
      this.clearPassword = clearPassword;
      this.key = key;
   //   encrypt(clearPassword, key);
   }
	
	public String getUsername()
	{
		return username;
	}
	
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	public String getClearP()
	{
		return clearPassword;
	}
	
	public void setClearP(String clearPassword)
	{
		this.clearPassword = clearPassword;
	}
	
	public String getEncryptP()
	{
		return encryptedPassword;
	}
	
	public void setEncryptP(String encryptedPassword)
	{
		this.encryptedPassword = encryptedPassword;
	}
	
	public String getKey()
	{
		return key;
	}
	
	public void setKey(String key)
	{
		this.key = key;
		
	}
	
	
	private static String encryption(String clearPassword, String key)
	{
		String temp = "";
		String word = clearPassword.toUpperCase();
		
		
		System.out.println("before for \n");
		for(int i = 0, j = 0; i < clearPassword.length(); i++)
		{
			char c = word.charAt(i);
			System.out.println("before if \n");
			if(c > 'A' || c < 'Z')
			{
				System.out.println("after if \n");
				//continue;
				temp += (char)((c + key.charAt(j) - 2 * 'A') % 26 + 'A');
				j = j++ % key.length();
			}
		}
		
		return temp;
		
	}
	
   

	public String toString()
	{
		return ("Username: " + username + "\n" + "Password: " + clearPassword + "\n" + "Encrypted Password: " +  encryptedPassword + "\n" + "Key: " + key );
	}
	
       
	
	
	
}