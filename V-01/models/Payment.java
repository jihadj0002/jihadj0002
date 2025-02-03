package models;
import java.lang.*;

public class Payment
{
	private String userId;
	private String paymentId;
	private String reservationId;
	private int amount;
	private String paymentDate;
	private String paymentMethod;
	
	
	public Payment()
	{}
	
	public Payment(String userId, String paymentId, String reservationId, int amount, String paymentDate, String paymentMethod)
	{
		this.userId=userId;
		this.paymentId=paymentId;
		this.reservationId=reservationId;
		this.amount=amount;
		this.paymentDate=paymentDate;
		this.paymentMethod=paymentMethod;
		
	}
	
	public void setUserId(String userId)
	{
		this.userId=userId;
	}
	
	public void setPaymentId(String paymentId)
	{
		this.paymentId=paymentId;
	}
	
	public void setReservationId(String reservationId)
	{
		this.reservationId=reservationId;
	}
	
	public void setAmount(int amount)
	{
		this.amount=amount;
	}
	
	public void setPaymentDate(String paymentDate)
	{
		this.paymentDate=paymentDate;
	}
	
	public void setPaymentMethod(String paymentMethod)
	{
		this.paymentMethod=paymentMethod;
	}
	
	public String getUserId()
	{
		return this.userId;
	}
	public String getPaymentId()
	{
		return this.paymentId;
	}
	public String getReservationId()
	{
		return this.reservationId;
	}
	public int getAmount()
	{
		return this.amount;
	}
	public String getPaymentDate()
	{
		return this.paymentDate;
	}
	public String getPaymentMethod()
	{
		return this.paymentMethod;
	}
	
	public String toStringPayment()
	{
		String str=this.userId+", "+this.paymentId+", "+this.reservationId+", "+this.amount+", "+this.paymentDate+", "+this.paymentMethod+"\n";
		return str;
	}
	
	public Payment formPayment(String str)
	{
		String data[]=str.split(", ");
		
		Payment p=new Payment();
		
		p.setUserId(data[0]);
		p.setPaymentId(data[1]);
		p.setReservationId(data[2]);
		p.setAmount(Integer.parseInt(data[3]));
		p.setPaymentDate(data[4]);
		p.setPaymentMethod(data[5]);
		
		return p;
		
	}
	
}