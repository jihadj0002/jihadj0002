package models;
import java.lang.*;

public class Flight
{
	
	private String flightId;
	private String flightName;
	private String source;
	private String destination;
	private String departureDate;
	private String arrivalDate;
	private String departureTime;
	private String arrivalTime;
	private int price;
	private String seatAvailability;
																			//			arrivalDate;String departureTime;String arrivalTime;String price;String seatAvailability
	
	
	public Flight()
	{}
	
	public Flight(String flightId, String flightName, String source, String destination, String departureDate, String arrivalDate, String departureTime, String arrivalTime, int price, String seatAvailability)
	{
		this.flightId=flightId;
		this.flightName=flightName;
		this.source=source;
		this.destination=destination;
		this.departureDate=departureDate;
		this.arrivalDate=arrivalDate;
		this.departureTime=departureTime;
		this.arrivalTime=arrivalTime;
		this.price=price;
		this.seatAvailability=seatAvailability;
	}
	
	
	//Setter
	public void setFlightId(String flightId)
	{
		this.flightId=flightId;
	}
	public void setFlightName(String flightName)
	{
		this.flightName=flightName;
	}
	public void setSource(String source)
	{
		this.source=source;
	}
	public void setDestination(String destination)
	{
		this.destination=destination;
	}
	public void setDepartureDate(String departureDate)
	{
		this.departureDate=departureDate;
	}
	public void setDepartureTime(String departureTime)
	{
		this.departureTime=departureTime;
	}
	public void setArrivalDate(String arrivalDate)
	{
		this.arrivalDate=arrivalDate;
	}
	public void setArrivalTime(String arrivalTime)
	{
		this.arrivalTime=arrivalTime;
	}
	public void setPrice(int price)
	{
		this.price=price;
	}
	public void setSeatAvailability(String seatAvailability)
	{
		this.seatAvailability=seatAvailability;
	}
	
	
	//Getter
		
	public String getFlightId()
	{
		return this.flightId;
	}
		
	public String getFlightName()
	{
		return this.flightName;
	}
		
	public String getSource()
	{
		return this.source;
	}
		
	public String getDestination()
	{
		return this.destination;
	}
		
	public String getDepartureTime()
	{
		return this.departureTime;
	}
		
	public String getDepartureDate()
	{
		return this.departureDate;
	}
		
	public String getArrivalDate()
	{
		return this.arrivalDate;
	}
		
	public String getArrivalTime()
	{
		return this.arrivalTime;
	}
		
	public int getPrice()
	{
		return this.price;
	}
	public String getSeatAvailability()
	{
		return this.seatAvailability;
	}
	

	public String toStringFlight()
	{
		String str=this.flightId+","+this.flightName+","+this.source+","+this.destination+","+this.departureDate+","+this.departureTime+","+this.arrivalDate+","+this.arrivalTime+","+this.price+","+this.seatAvailability+"\n";
		return str;
	}
	
	public Flight formFlight(String str)
	{
		String data[]=str.split(",");
		
		Flight f = new Flight();
		
		f.setFlightId(data[0]);
		f.setFlightName(data[1]);
		f.setSource(data[2]);
		f.setDestination(data[3]);
		f.setDepartureDate(data[4]);
		f.setDepartureTime(data[5]);
		f.setArrivalDate(data[6]);
		f.setArrivalTime(data[7]);
		f.setPrice(Integer.parseInt(data[8]));
		f.setSeatAvailability(data[9]);
		
		return f;	
	}
	
}