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
public class Account {
	
	   private String companyName;
	   private String companyAddress;
	   User[] users = new User[10];
	   private int numOfelements;
	   private int NOTFOUND = -1;
	

	public Account()
	{
	   this.companyName = " ";
	   this.companyAddress = " ";
	   this.numOfelements = 0;
	
	}
	
	public Account(String companyName, String companyAddress, int numOfelements)
	{
		this.companyName = companyName;
		this.companyAddress = companyAddress;
		this.numOfelements = numOfelements;
		
	}
	
	public String getCompanyName()
	{
		return companyName;
	}
	
	public void setCompanyName(String companyName)
	{
		this.companyName = companyName;
	}
	
	public String getCompanyAddresss()
	{
		return companyAddress;
	}
	
	public void setCompanyAddress(String companyAddress)
	{
		this.companyAddress = companyAddress;
	}
	
	public void AddUser(User u)
	{
		users[numOfelements] = u;
		numOfelements++;
		
	}
        
        public User getUser(String username){
            
            for(int i=0; i < users.length;i++){
                if(username.equals(users[i])){
                    return users[i];
                }
            }
            return null;
        }

	
	
	

}