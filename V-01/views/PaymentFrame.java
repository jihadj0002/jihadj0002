package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import models.*;
import controllers.*;
import java.util.*;
import java.time.LocalDate;

public class PaymentFrame extends JFrame implements ActionListener
{
    private JLabel flightNameLabel, reservationIdLabel;
	private JTextField flightNameTF,reservationIdTF;
    private JButton payBtn, backBtn;
    
	private JTable flightTable;
	private JScrollPane flightTableSP;
	private JPanel panel;
	private User u;
	private Customer c;
	

    public PaymentFrame(User u) 
	{
        
        
		super("Payment Frame");
        setTitle("My Payments");
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
		
		
        this.payBtn = new JButton("Pay Now");
        this.payBtn.setBounds(350, 200, 100, 50);
        this.payBtn.addActionListener(this);
        this.panel.add(payBtn);
		
        this.backBtn = new JButton("Back");
        this.backBtn.setBounds(365, 250, 80, 30);
        this.backBtn.addActionListener(this);
        this.panel.add(backBtn);
		
		
		FlightController fc = new FlightController();
		Flight flightList[]=fc.getAllFlight();
		
		
		ReservationController rc= new ReservationController();
		Reservation r[]= rc.getBookedFlightsByCustomer(u.getUserId());
		//1d to 2d
		//flightId, flightName, source, destination, departureDate, arrivalDate, 
		//departureTime, arrivalTime, int price, seatAvailability
		String reservationData[][]= new String[flightList.length][5];
		
		for(int i=0; i<r.length; i++)
		{
			if(r[i]!=null)
			{
				reservationData[i][0]=r[i].getReservationId();
				reservationData[i][1]=r[i].getFlightId();
				reservationData[i][2]=r[i].getBookingDate();
				reservationData[i][3]=r[i].getSeatNumber();
				reservationData[i][4]=String.valueOf(r[i].getStatus());
			}
		}
		
		String head[]={"Reservation ID", "Flight Id", "Booking Date","Seat Number","Paid",};
		
		this.flightTable=new JTable(reservationData, head);
		
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
		
		//flightNameTF,reservationIdTF
		if(command.equals(payBtn.getText()))
		{
			if(!flightNameTF.getText().isEmpty())
			{
				if(!reservationIdTF.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(this,"Payment Layout Coming Soon..!	");
					/*
					PaymentFrame pf = new PaymentFrame(u);
					System.out.println("Opening Make Payment Frame");
					this.setVisible(false);
					pf.setVisible(true);
					*/
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
