package controllers;
import java.lang.*;
import models.*;

public class UserController
{
	public void insertUser(User u)
	{
		User user[]=this.getAllUser();
		
		for(int i=0; i<100; i++)
		{
			if(user[i]==null)
			{
				user[i]=u;
				break;
			}
		}
		
		this.write(user);
	}
	
	public void updateUser(User u)
	{
		User user[]=this.getAllUser();
		
		for(int i=0; i<user.length; i++)
		{
			if(user[i]!=null)
			{
				if(user[i].getUserId().equals(u.getUserId()))
				{
				user[i]=u;
				}
			}
		}
		this.write(user);
	}
	
	public void deleteUser(String userId)
	{
		User user[]=this.getAllUser();
		
		for(int i=0; i<user.length; i++)
		{
			if(user[i]!=null)
			{
				if(user[i].getUserId().equals(userId))
				{
					user[i]=null;
				}
			}
		}
		this.write(user);
	}
	
public User searchUser(String userId)
	{
		User user[]=this.getAllUser();
		
		for(int i=0;i<user.length;i++)
		{
			if(user[i]!=null)
			{
				if(user[i].getUserId().equals(userId))
				{
					
					return user[i];
				}
			}
			
		}
		
		return null;
	}
	
	public User[] getAllUser()
	{
		String fileName="controllers/data/users.txt";
		FileIO fio=new FileIO();
		String values[]=fio.readFile(fileName);
		
		User user[]=new User[100];
		
		User u=new User();
		
		for(int i=0;i<values.length;i++)
		{
			if(values[i]!=null)
			{
				if(user[i]==null)
				{
					user[i]=u.formUser(values[i]);
				}
			}
			
		}
		
		return user;
	}
	
	public void write(User user[])
	{
		String data[]=new String[100];
		
		for(int i=0; i<data.length; i++)
		{
			if(user[i]!=null)
			{
				data[i]=user[i].toStringUser();
			}
		}
		
		String fileName="controllers/data/users.txt";
		
		FileIO fio=new FileIO();
		fio.writeFile(fileName, data);
	}
	
	
	
}