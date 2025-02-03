package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import models.*;
import controllers.*;
import java.util.*;
import java.time.LocalDate;

public class BookFlightFrame extends JFrame implements ActionListener
{
    private JLabel flightNameLabel, reservationIdLabel;
	private JTextField flightNameTF,reservationIdTF;
    private JButton bookButton, backBtn;
    
	private JTable flightTable;
	private JScrollPane flightTableSP;
	private JPanel panel;
	private User u;
	private Customer c;
	

    public BookFlightFrame(User u) 
	{
        
        
		super("Book Flight");
        setTitle("Book Flight");
        setSize(1280, 720);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
		
		this.panel = new JPanel();
		this.panel.setLayout(null);

		this.flightNameLabel=new JLabel("Flight Name:");
		this.flightNameLabel.setBounds(250,100,100,30);
		this.panel.add(flightNameLabel);
		
		this.flightNameTF= new JTextField();
		this.flightNameTF.setBounds(250, 160, 150, 30);
		this.panel.add(flightNameTF);
		
		this.reservationIdLabel=new JLabel("Reservation Id:");
		this.reservationIdLabel.setBounds(400,100,100,30);
		this.panel.add(reservationIdLabel);
		
		this.reservationIdTF= new JTextField();
		this.reservationIdTF.setBounds(400, 160, 150, 30);
		this.panel.add(reservationIdTF);
		
		
        this.bookButton = new JButton("Book Now");
        this.bookButton.setBounds(350, 200, 100, 50);
        this.bookButton.addActionListener(this);
        this.panel.add(bookButton);
		
        this.backBtn = new JButton("Back");
        this.backBtn.setBounds(365, 250, 80, 30);
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
		this.flightTableSP.setBounds(100, 400, 1000, 600);
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
		
		FlightController fc= new FlightController();
		Flight f= fc.searchFlightByName(flightNameTF.getText());
		
		
		int seats=0;
		try
		{
			seats=Integer.parseInt(f.getSeatAvailability());
			seats=seats-1;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
		LocalDate currentDate = LocalDate.now();
		
		Reservation r= new Reservation();
		
		
		
		if(command.equals(bookButton.getText()))
		{
			if(!flightNameTF.getText().isEmpty())
			{
				if(!reservationIdTF.getText().isEmpty())
				{
					
					r.setReservationId(reservationIdTF.getText());
					r.setFlightId(f.getFlightId());
					r.setUserId(u.getUserId());
					r.setBookingDate(String.valueOf(currentDate));
					r.setSeatNumber(String.valueOf(seats));
					r.setStatus(false);
					
					f.setSeatAvailability(String.valueOf(seats));
					fc.updateFlight(f);
					
					ReservationController rc= new ReservationController();
					rc.insertReservation(r);
					
					JOptionPane.showMessageDialog(this,"Reservation Completed");
					ViewReservedFlightFrame vrf= new ViewReservedFlightFrame(this.u);
					this.setVisible(false);
					vrf.setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(this,"No Flight on this name");
				}
			}
		}
		
		if(command.equals(backBtn.getText()))
		{
			//back button will take you to payment home page.
			CustomerHomeFrame adf=new CustomerHomeFrame(this.u);
			this.setVisible(false);
			adf.setVisible(true);
		}
		
	}

}
