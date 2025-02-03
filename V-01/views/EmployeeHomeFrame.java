package views;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import models.*;
import controllers.*;

public class EmployeeHomeFrame extends JFrame implements ActionListener
{
	private JButton addFlightBtn, addReservationBtn, addPaymentBtn, logoutBtn;
	private JPanel panel;
	private User u;
	
	
	public EmployeeHomeFrame(User u)
	{
		super("Customer Home Frame");
		this.setSize(1280, 720);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panel=new JPanel();
		this.panel.setLayout(null);
		
		this.addFlightBtn=new JButton("Add Flight");
		this.addFlightBtn.setBounds(120, 120, 200, 50);
		this.addFlightBtn.addActionListener(this);
		this.panel.add(addFlightBtn);
		
		this.addPaymentBtn= new JButton("Add Payment");
		this.addPaymentBtn.setBounds(350, 120, 200, 50);
		this.addPaymentBtn.addActionListener(this);
		this.panel.add(addPaymentBtn);
		
		this.addReservationBtn= new JButton("Add Reservation");
		this.addReservationBtn.setBounds(580, 120, 200, 50);
		this.addReservationBtn.addActionListener(this);
		this.panel.add(addReservationBtn);
		
		this.logoutBtn= new JButton("Logout");
		this.logoutBtn.setBounds(820, 120, 200, 50);
		this.logoutBtn.addActionListener(this);
		this.panel.add(logoutBtn);
		
		
		this.add(panel);
		this.u=u;
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String command=ae.getActionCommand();
		System.out.println("Button pressed: " + command);
		if(addFlightBtn.getText().equals(command))
		{
			
			FlightOperationFrame fof= new FlightOperationFrame(u);
			System.out.println("Starting Flight Operation Frame");
			this.setVisible(false);
			fof.setVisible(true);
			
		}
		
		if(addReservationBtn.getText().equals(command))
		{
			
			ReservationOperationFrame rof= new ReservationOperationFrame(u);
			this.setVisible(false);
			rof.setVisible(true);
			
			
		}
		if(addPaymentBtn.getText().equals(command))
		{
			
			PaymentOperationFrame eof= new PaymentOperationFrame(u);
			this.setVisible(false);
			eof.setVisible(true);
			
			
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








