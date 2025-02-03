package controllers;
import java.lang.*;
import models.*;

public class CustomerController
{
	
	public Customer searchCustomer(String userId)
	{
		Customer customer[] = this.getAllCustomer();
		
		for(int i=0; i<customer.length; i++)
		{
			if(customer[i]!=null)
			{
				if(customer[i].getUserId().equals(userId))
				{
					return customer[i];
				}
			}
		}
		return null;
	}
	
	public Customer[] getAllCustomer()
	{
		String fileName = "controllers/data/customers.txt";
		FileIO fio=new FileIO();
		String values[]=fio.readFile(fileName);
		
		Customer customer[]= new Customer[100];
		
		Customer c= new Customer();
		
		for(int i=0; i<values.length; i++)
		{
			if(values[i]!=null)
			{
				if(customer[i]==null)
				{
					customer[i]=c.formCustomer(values[i]);
				}
			}
		}
		return customer;
	}
	
	public void write(Customer customer[])
	{
		String data[] = new String[100];
		
		for(int i=0; i<data.length; i++)
		{
			if(customer[i]!=null)
			{
				data[i]=customer[i].toStringCustomer();
			}
		}
		
		String fileName="controllers/data/customers.txt";
		
		FileIO fio = new FileIO();
		fio.writeFile(fileName, data);
	}
	
	
	public void insertCustomer(Customer c)
	{
		Customer customer[]=this.getAllCustomer();
		
		for(int i=0; i<customer.length; i++)
		{
			if(customer[i]==null)
			{
				customer[i]=c;
				break;
			}
		}
		
		
		this.write(customer);
	}
	
	public void updateCustomer(Customer c)
	{
		Customer customer[]=this.getAllCustomer();
		
		for(int i=0; i<customer.length; i++)
		{
			if(customer[i]!=null)
			{
				if(customer[i].getUserId().equals(c.getUserId()))
				{
					customer[i]=c;
				}
			}
		}
		
		this.write(customer);
	}
	
	public void deleteCustomer(String userId)
	{
		Customer customer[]= this.getAllCustomer();
		
		for(int i=0; i<customer.length; i++)
		{
			if(customer[i]!=null)
			{
				if(customer[i].getUserId().equals(userId))
				{
					customer[i]=null;
				}
			}
		}
		this.write(customer);
	}
	
}





















