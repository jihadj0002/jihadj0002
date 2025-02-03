package views;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import models.*;
import controllers.*;

public class CustomerHomeFrame extends JFrame implements ActionListener
{
	private JButton viewProfileBtn, searchFlightsBtn, viewReservationsBtn, bookFlightBtn, makePaymentBtn, paymentHistoryBtn, cancelReservationBtn, updateProfileBtn, logoutBtn, backToHomeBtn;
	private JPanel panel;
	private User u;
	
	
	public CustomerHomeFrame(User u)
	{
		super("Customer Home Frame");
		this.setSize(1280, 720);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panel=new JPanel();
		this.panel.setLayout(null);
		
		
		this.viewProfileBtn = new JButton("View Profile");
		this.viewProfileBtn.setBounds(120, 120, 200, 50);
		this.viewProfileBtn.addActionListener(this);
		this.panel.add(viewProfileBtn);

		
		this.searchFlightsBtn = new JButton("Search Flights");
		this.searchFlightsBtn.setBounds(350, 120, 200, 50);
		this.searchFlightsBtn.addActionListener(this);
		this.panel.add(searchFlightsBtn);

		
		this.viewReservationsBtn = new JButton("View My Reservations");
		this.viewReservationsBtn.setBounds(580, 120, 200, 50);
		this.viewReservationsBtn.addActionListener(this);
		this.panel.add(viewReservationsBtn);

		
		this.bookFlightBtn = new JButton("Book Flight");
		this.bookFlightBtn.setBounds(810, 120, 200, 50);
		this.bookFlightBtn.addActionListener(this);
		this.panel.add(bookFlightBtn);

		
		this.makePaymentBtn = new JButton("Make Payment");
		this.makePaymentBtn.setBounds(120, 250, 200, 50);
		this.makePaymentBtn.addActionListener(this);
		this.panel.add(makePaymentBtn);

		
		this.paymentHistoryBtn = new JButton("View Payment History");
		this.paymentHistoryBtn.setBounds(350, 250, 200, 50);
		this.paymentHistoryBtn.addActionListener(this);
		this.panel.add(paymentHistoryBtn);

		
		this.cancelReservationBtn = new JButton("Cancel Reservation");
		this.cancelReservationBtn.setBounds(580, 250, 200, 50);
		this.cancelReservationBtn.addActionListener(this);
		this.panel.add(cancelReservationBtn);

		
		this.updateProfileBtn = new JButton("Update Profile");
		this.updateProfileBtn.setBounds(120, 370, 200, 50);
		this.updateProfileBtn.addActionListener(this);
		this.panel.add(updateProfileBtn);

		
		this.logoutBtn = new JButton("Logout");
		this.logoutBtn.setBounds(810, 370, 200, 50);
		this.logoutBtn.addActionListener(this);
		this.panel.add(logoutBtn);

		
		
		
		this.add(panel);
		this.u=u;
		
	}
	
	public void actionPerformed(ActionEvent ae) 
	{		
		String command = ae.getActionCommand();
		System.out.println("Button pressed: " + command);

		if (viewProfileBtn.getText().equals(command)) 
		{
			
			
			CustomerProfileFrame cpf = new CustomerProfileFrame(u);
			this.setVisible(false);
			cpf.setVisible(true);
			
			
		}

		if (searchFlightsBtn.getText().equals(command)) 
		{
			
			SearchFlightsFrame sff = new SearchFlightsFrame(u);
			System.out.println("Opening Search Flights Frame");
			this.setVisible(false);
			sff.setVisible(true);
			
		}

		if (viewReservationsBtn.getText().equals(command)) 
		{
			
			ViewReservedFlightFrame vrf = new ViewReservedFlightFrame(u);
			System.out.println("Opening View Booked Flights Frame");
			this.setVisible(false);
			vrf.setVisible(true);
			 
		}

		if (paymentHistoryBtn.getText().equals(command)) 
		{
			
			PaymentHistoryFrame phf = new PaymentHistoryFrame(u);
			System.out.println("Opening Payment History Frame");
			this.setVisible(false);
			phf.setVisible(true);
			
		}

		if (bookFlightBtn.getText().equals(command)) 
		{
			
			BookFlightFrame bff = new BookFlightFrame(u);
			System.out.println("Opening Book Flight Frame");
			this.setVisible(false);
			bff.setVisible(true);
			
		}

		if (makePaymentBtn.getText().equals(command)) 
		{
			
			PaymentFrame pf = new PaymentFrame(u);
			System.out.println("Opening Make Payment Frame");
			this.setVisible(false);
			pf.setVisible(true);
			
		}

		if (cancelReservationBtn.getText().equals(command)) 
		{
			JOptionPane.showMessageDialog(this,"Cancel Reservation Layout Coming Soon..!	");
			/*
			CancelReservationFrame crf = new CancelReservationFrame(u);
			System.out.println("Opening Cancel Reservation Frame");
			this.setVisible(false);
			crf.setVisible(true);
			*/
		}

		if (updateProfileBtn.getText().equals(command)) 
		{
			
			CusUpdateProfileFrame upf = new CusUpdateProfileFrame(u);
			System.out.println("Opening Update Profile Frame");
			this.setVisible(false);
			upf.setVisible(true);
			
		}

		if (logoutBtn.getText().equals(command)) 
		{
			
			LoginFrame lf = new LoginFrame();
			System.out.println("Logging out");
			this.setVisible(false);
			lf.setVisible(true);
			
		}

	}

}








