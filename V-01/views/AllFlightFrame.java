package views;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import models.*;
import controllers.*;

public class AllFlightFrame extends JFrame implements ActionListener
{
	private JButton backBtn;
	private JTable flightTable;
	private JScrollPane flightTableSP;
	private JPanel panel;
	private User u;
	
	
	public AllFlightFrame(User u)
	{
		super("All Flight Frame");
		this.setSize(1280, 720);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panel= new JPanel();
		this.panel.setLayout(null);
		
		this.backBtn= new JButton("Back");
		this.backBtn.setBounds(100,70,100,30);
		this.backBtn.addActionListener(this);
		this.panel.add(backBtn);
		
		FlightController fc = new FlightController();
		Flight flightList[]=fc.getAllFlight();
		
		//1d to 2d
		//flightId, flightName, source, destination, departureDate, arrivalDate, 
		//departureTime, arrivalTime, int price, seatAvailability
		String flightData[][]= new String[flightList.length][10];
		
		for(int i=0; i<flightList.length; i++)
		{
			if(flightList[i]!=null)
			{
				flightData[i][0]=flightList[i].getFlightId();
				flightData[i][1]=flightList[i].getFlightName();
				flightData[i][2]=flightList[i].getSource();
				flightData[i][3]=flightList[i].getDestination();
				flightData[i][4]=flightList[i].getDepartureDate();
				flightData[i][5]=flightList[i].getArrivalDate();
				flightData[i][6]=flightList[i].getDepartureTime();
				flightData[i][7]=flightList[i].getArrivalTime();
				flightData[i][8]=String.valueOf(flightList[i].getPrice());
				flightData[i][9]=String.valueOf(flightList[i].getSeatAvailability());
			}
		}
		
		String head[]={"ID", "Name", "Source","Destination","Departure Date","Arrival Date", "Departure Time", "Arrival Time", "Price", "Available Seat"  };
		
		this.flightTable=new JTable(flightData, head);
		
		this.flightTableSP= new JScrollPane(flightTable);
		this.flightTableSP.setBounds(100, 120, 1000, 600);
		this.flightTable.setEnabled(false);
		this.panel.add(flightTableSP);
		
		this.panel.revalidate();
		this.panel.repaint();
		
		this.add(panel);
		this.u=u;
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String command=ae.getActionCommand();
		
		if(command.equals(backBtn.getText()))
		{
			//back button will take you to payment home page.
			AdminHomeFrame adf=new AdminHomeFrame(this.u);
			this.setVisible(false);
			adf.setVisible(true);
		}
	}
}
