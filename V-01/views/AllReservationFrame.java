package views;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import models.*;
import controllers.*;

public class AllReservationFrame extends JFrame implements ActionListener
{
	private JButton backBtn;
	private JTable reservationTable;
	private JScrollPane reservationTableSP;
	private JPanel panel;
	private User u;
	
	
	public AllReservationFrame(User u)
	{
		super("All Reservation Frame");
		this.setSize(1280, 720);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panel= new JPanel();
		this.panel.setLayout(null);
		
		this.backBtn= new JButton("Back");
		this.backBtn.setBounds(100,70,100,30);
		this.backBtn.addActionListener(this);
		this.panel.add(backBtn);
		
		ReservationController fc = new ReservationController();
		Reservation ReservationList[]=fc.getAllReservation();
		
		//1d to 2d
		//reservationId, flightId, userId, bookingDate, seatNumber, boolean status
		
		String ReservationData[][]= new String[ReservationList.length][6];
		
		for(int i=0; i<ReservationList.length; i++)
		{
			if(ReservationList[i]!=null)
			{
				ReservationData[i][0]=ReservationList[i].getReservationId();
				ReservationData[i][1]=ReservationList[i].getFlightId();
				ReservationData[i][2]=ReservationList[i].getUserId();
				ReservationData[i][3]=ReservationList[i].getBookingDate();
				ReservationData[i][4]=ReservationList[i].getSeatNumber();
				ReservationData[i][5]=String.valueOf(ReservationList[i].getStatus());
				
			}
		}
		
		String head[]={"Reservation ID", "Flight ID", "User ID","Booking Date","Seat Number","Status"};
		
		this.reservationTable=new JTable(ReservationData, head);
		
		this.reservationTableSP= new JScrollPane(reservationTable);
		this.reservationTableSP.setBounds(100, 120, 1000, 600);
		this.reservationTable.setEnabled(false);
		this.panel.add(reservationTableSP);
		
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
