package models;
import java.lang.*;


public class Reservation
{
	//reservationId, flightId, userId (Customer), bookingDate,
	//seatNumber, status (Booked, Cancelled). 
	private String reservationId;
	private String flightId;
	private String userId;
	private String bookingDate;
	private String seatNumber;
	private boolean status;
	
	
	public Reservation()
	{}
	
	public Reservation(String reservationId, String flightId, String userId, String bookingDate, String seatNumber, boolean status)
	{
		this.reservationId=reservationId;
		this.flightId=flightId;
		this.userId=userId;
		this.bookingDate=bookingDate;
		this.seatNumber=seatNumber;
		this.status=status;
	}
	
	
	public void setReservationId(String reservationId)
	{
		this.reservationId=reservationId;
	}
	
	public void setFlightId(String flightId)
	{
		this.flightId=flightId;
	}
	
	public void setUserId(String userId)
	{
		this.userId=userId;
	}
	
	public void setBookingDate(String bookingDate)
	{
		this.bookingDate=bookingDate;
	}
	
	public void setStatus(boolean status)
	{
		this.status=status;
	}
	
	public void setSeatNumber(String seatNumber)
	{
		this.seatNumber=seatNumber;
	}
	
	
	public String getReservationId()
	{
		return this.reservationId;
	}
	
	public String getFlightId()
	{
		return this.flightId;
	}
	
	public String getUserId()
	{
		return this.userId;
	}
	
	public String getBookingDate()
	{
		return this.bookingDate;
	}
	
	public boolean getStatus()
	{
		return this.status;
	}
	
	public String getSeatNumber()
	{
		return this.seatNumber;
	}
	
	
	
	public String toStringReservation()
	{
		String str=this.reservationId+","+this.flightId+","+this.userId+","+this.bookingDate+","+this.seatNumber+","+this.status+"\n";
		return str;
	}
	
	public Reservation formReservation(String str)
	{
		String data[]=str.split(",");
		
		Reservation r=new Reservation();
		r.setReservationId(data[0]);
		r.setFlightId(data[1]);
		r.setUserId(data[2]);
		r.setBookingDate(data[3]);
		r.setSeatNumber(data[4]);
		r.setStatus(Boolean.parseBoolean(data[5]));
		
		return r;
	}
	
	
}