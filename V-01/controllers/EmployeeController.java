package controllers;
import java.lang.*;
import models.*;

public class EmployeeController
{
	public void insertEmployee(Employee e)
	{
		Employee emp[]=this.getAllEmployee();
		
		for(int i=0; i<emp.length; i++)
		{
			if(emp[i]==null)
			{
				emp[i]=e;
				break;
			}
		}
		
		this.write(emp);
	}
	
	
	public void updateEmployee(Employee e)
	{
		Employee emp[]=this.getAllEmployee();
		
		for(int i=0; i<emp.length; i++)
		{
			if(emp[i]!=null)
			{
				if(emp[i].getUserId().equals(e.getUserId()))
				{
					emp[i]=e;
				}
			}
		}
		
		this.write(emp);
	}
	
	
	public void deleteEmployee(String userId)
	{
		Employee emp[]= this.getAllEmployee();
		
		for(int i=0; i<emp.length; i++)
		{
			if(emp[i]!=null)
			{
				if(emp[i].getUserId().equals(userId))
				{
					emp[i]=null;
				}
			}
		}
		this.write(emp);
	}
	
	public Employee searchEmployee(String userId)
	{
		Employee emp[] = this.getAllEmployee();
		
		for(int i=0; i<emp.length; i++)
		{
			if(emp[i]!=null)
			{
				if(emp[i].getUserId().equals(userId))
				{
					return emp[i];
				}
			}
		}
		return null;
	}
	
	
	public Employee[] getAllEmployee()
	{
		String fileName="controllers/data/emp.txt";
		FileIO fio = new FileIO();
		
		String data[]= fio.readFile(fileName);
		
		Employee emp[]=new Employee[100];
		Employee e=new Employee();
		
		for (int i=0;i<data.length; i++)
		{
			if(data[i]!=null)
			{
				if(emp[i]==null)
				{
					emp[i]=e.formEmployee(data[i]);
				}
			}
		}
		
		return emp;
	}
	
	public void write(Employee emp[])
	{
		String data[]=new String[100];
		
		for(int i=0; i<data.length; i++)
		{
			if(emp[i]!=null)
			{
				data[i]=emp[i].toStringEmployee();
				
			}
		}
		String fileName="controllers/data/emp.txt";
		FileIO fio=new FileIO();
		fio.writeFile(fileName, data);
	}
}