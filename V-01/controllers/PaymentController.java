package controllers;
import java.lang.*;
import models.*;
import java.util.*;


public class PaymentController
{
	public void insertPayment(Payment p)
	{
		Payment payment[] = this.getAllPayment();
		
		for(int i=0; i<payment.length; i++)
		{
			if(payment[i]==null)
			{
				payment[i]=p;
				break;
			}
		}
		
		this.write(payment);
	}
	
	
	public void updatePayment(Payment p)
	{
		Payment payment[] = this.getAllPayment();
		
		for(int i=0; i<payment.length; i++)
		{
			if(payment[i]!=null)
			{
				if(payment[i].getUserId().equals(p.getUserId()))
				{
					payment[i]=p;
				}
			}
		}
		
		this.write(payment);
	}
	
	public void deletePayment(String paymentId)
	{
		Payment payment[]= this.getAllPayment();
		
		for(int i=0; i<payment.length; i++)
		{
			if(payment[i]!=null)
			{
				if(payment[i].getPaymentId().equals(paymentId))
				{
					payment[i]=null;
				}
			}
		}
		
		this.write(payment);
	}
	
	
	public Payment searchPayment(String userId)
	{
		Payment payment[]=this.getAllPayment();
		
		for(int i=0; i<payment.length; i++)
		{
			if(payment[i]!=null && payment[i].getUserId().equals(userId))
			{
				return payment[i];
			}
		}
		return null;
	}
	
	public Payment searchPaymentByPay(String paymentId)
	{
		Payment payment[]=this.getAllPayment();
		
		for(int i=0; i<payment.length; i++)
		{
			if(payment[i]!=null && payment[i].getPaymentId().equals(paymentId))
			{
				return payment[i];
			}
		}
		return null;
	}
	
	public Payment[] getPaymentsByCustomer(String userId)
	{
		Payment payment[]=this.getAllPayment();
		List<Payment> matchedPayment = new ArrayList<>();
		for(int i=0; i<payment.length; i++)
		{
			if(payment[i]!=null && payment[i].getUserId().equals(userId))
			{
				if(payment[i].getUserId().equals(userId))
				{
					
					matchedPayment.add(payment[i]);
				}
			}
		}
		return matchedPayment.toArray(new Payment[0]);
	}
	
	public Payment[] getAllPayment()
	{
		String fileName="controllers/data/payments.txt";
		FileIO fio = new FileIO();
		String values[] = fio.readFile(fileName);
		
		Payment payment[] = new Payment[100];
		Payment p= new Payment();
		
		for(int i=0; i< values.length; i++)
		{
			if(values[i]!=null)
			{
				if(payment[i]==null)
				{
					payment[i]=p.formPayment(values[i]);
				}
			}
		}
		
		return payment;
	}
	
	public void write(Payment payment[])
	{
		String data[] = new String[100];
		
		for(int i=0; i<data.length; i++)
		{
			if(payment[i]!=null)
			{
				data[i]=payment[i].toStringPayment();
			}
		}
		
		String fileName="controllers/data/payments.txt";
		
		FileIO fio = new FileIO();
		
		fio.writeFile(fileName, data);
	}
		
}