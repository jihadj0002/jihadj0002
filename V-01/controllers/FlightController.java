package controllers;

import java.util.*;

import java.lang.*;
import models.*;

public class FlightController
{
	public void insertFlight(Flight f)
	{
		Flight flights[]=this.getAllFlight();
		
		for(int i=0; i<flights.length; i++)
		{
			if(flights[i]==null)
			{
				flights[i]=f;
				break;
			}
		}
		this.write(flights);
	}
	
	public void updateFlight(Flight f)
	{
		Flight flights[] = this.getAllFlight();
		
		for(int i=0; i<flights.length; i++)
		{
			if(flights[i]!=null)
			{
				if(flights[i].getFlightId().equals(f.getFlightId()))
				{
					flights[i]=f;
				}
			}
		}
		this.write(flights);
	}
	
	public void deleteFlight(String flightId)
	{
		Flight flights[]=this.getAllFlight();
		for(int i=0; i<flights.length; i++)
		{
			if(flights[i]!=null)
			{
				if(flights[i].getFlightId().equals(flightId))
				{
					flights[i]=null;
				}
			}
		}
		this.write(flights);
	}
	
	public Flight searchFlight(String flightId)
	{
		Flight flights[]=this.getAllFlight();
		
		for(int i=0; i<flights.length; i++)
		{
			if(flights[i]!=null)
			{
				if(flights[i].getFlightId().equals(flightId))
				{
					return flights[i];
				}
			}
		}
		return null;
	}
	
	public Flight searchFlightByName(String flightName)
	{
		Flight flights[]=this.getAllFlight();
		
		for(int i=0; i<flights.length; i++)
		{
			if(flights[i]!=null)
			{
				if(flights[i].getFlightName().equals(flightName))
				{
					return flights[i];
				}
			}
		}
		return null;
	}

	//searchFlights(source, destination)
	public Flight[] searchFlight(String source, String destination) 
	{
    Flight flights[] = this.getAllFlight();
    
	Flight flight[] = new Flight[100]; // Array to store search results
    int index = 0; // Separate index for search results

    for (int i = 0; i < flights.length; i++) {
        if (flights[i] != null) {
            if (flights[i].getSource().equalsIgnoreCase(source) && flights[i].getDestination().equalsIgnoreCase(destination)) {
                flight[index++] = flights[i]; // Store matching flight
            }
        }
    }
    return flight;
}


	public Flight[] getAllFlight()
	{
		String fileName="controllers/data/flights.txt";
		FileIO fio = new FileIO();
		String values[] = fio.readFile(fileName);
		
		Flight flights[]=new Flight[100];
		
		Flight f = new Flight();
		
		for(int i=0; i<values.length; i++)
		{
			if(values[i]!=null)
			{
				if(flights[i]==null)
				{
					flights[i]=f.formFlight(values[i]);
				}
			}
		}
		
		return flights;
	}
	
	public void write(Flight flights[])
	{
		String data[]=new String[100];
		
		for(int i=0; i<data.length; i++)
		{
			if(flights[i]!=null)
			{
			data[i]=flights[i].toStringFlight();
			}
		}
		
		String fileName="controllers/data/flights.txt";
		
		FileIO fio = new FileIO();
		fio.writeFile(fileName, data);
	}
}