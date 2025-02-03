package controllers;
import java.lang.*;
import models.*;
import java.util.*;

public class ReservationController
{
	
	public void insertReservation(Reservation r)
	{
		Reservation reservation[] = this.getAllReservation();
		
		for(int i=0; i<reservation.length; i++)
		{
			if(reservation[i]==null)
			{
				reservation[i]=r;
				break;
			}
		}
		
		this.write(reservation);
	}
	
	
	
	public void updateReservation(Reservation r)
	{
		Reservation reservation[] = this.getAllReservation();
		
		for(int i=0; i<reservation.length; i++)
		{
			if(reservation[i]!= null)
			{
				if(reservation[i].getUserId().equals(r.getUserId()))
				{
					reservation[i]=r;
				}
			}
		}
		this.write(reservation);
	}
	
	
	public void deleteReservation(String reservationId)
	{
		Reservation reservation[] = this.getAllReservation();
		
		for(int i=0; i<reservation.length; i++)
		{
			if(reservation[i]!=null)
			{
				if(reservation[i].getReservationId().equals(reservationId))
				{
					reservation[i]=null;
				}
			}
		}
		this.write(reservation);
	}
	
	public Reservation[] getBookedFlightsByCustomer(String userId)
	{
		Reservation reservation[]=this.getAllReservation();
		List<Reservation> matchedReservations = new ArrayList<>();
		for(int i=0; i<reservation.length; i++)
		{
			if(reservation[i]!=null && reservation[i].getUserId().equals(userId))
			{
				if(reservation[i].getUserId().equals(userId))
				{
					
					matchedReservations.add(reservation[i]);
				}
			}
		}
		return matchedReservations.toArray(new Reservation[0]);
	}
	
	public Reservation searchReservation(String reservationId)
	{
		Reservation reservation[]=this.getAllReservation();
		
		for(int i=0; i<reservation.length; i++)
		{
			if(reservation[i]!=null)
			{
				if(reservation[i].getReservationId().equals(reservationId))
				{
					return reservation[i];
				}
			}
		}
		return null;
	}
	
	public Reservation[] getAllReservation()
	{
		String fileName="controllers/data/reservation.txt";
		FileIO fio= new FileIO();
		
		String values[] = fio.readFile(fileName);
		
		Reservation reservation[] = new Reservation[100];
		Reservation r=new Reservation();
		
		for (int i=0; i<values.length; i++)
		{
			if(values[i]!=null)
			{
				if(reservation[i]==null);
				{
					reservation[i]=r.formReservation(values[i]);
				}
			}
		}
		
		return reservation;
	}
	
	public void write(Reservation reservation[])
	{
		String data[] = new String[100];
		for(int i=0; i<data.length; i++)
		{
			if(reservation[i]!=null)
			{
				data[i]=reservation[i].toStringReservation();
			}
		}
		
		String fileName= "controllers/data/reservation.txt";
		
		FileIO fio= new FileIO();
		fio.writeFile(fileName,data);
	}
	
	
	
	
}