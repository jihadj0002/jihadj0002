package views;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import models.*;
import controllers.*;

public class AdminHomeFrame extends JFrame implements ActionListener
{
	private JButton adminBtn, customerBtn, employeeBtn, flightBtn, paymentBtn, reservationBtn, userBtn;
	private JButton updateProfileBtn, logoutBtn;
	private JPanel panel;
	private User u;
	
	
	public AdminHomeFrame(User u)
	{
		super("Admin Home Frame");
		this.setSize(1280, 720);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panel=new JPanel();
		this.panel.setLayout(null);
		
		this.adminBtn=new JButton("Admin Operation");
		this.adminBtn.setBounds(120, 120, 200, 50);
		this.adminBtn.addActionListener(this);
		this.panel.add(adminBtn);
		
		this.employeeBtn= new JButton("Employee Operations");
		this.employeeBtn.setBounds(350, 120, 200, 50);
		this.employeeBtn.addActionListener(this);
		this.panel.add(employeeBtn);
		
		this.customerBtn= new JButton("Customer Operation");
		this.customerBtn.setBounds(580, 120, 200, 50);
		this.customerBtn.addActionListener(this);
		this.panel.add(customerBtn);
		
		this.userBtn= new JButton("User");
		this.userBtn.setBounds(810, 120, 200, 50);
		this.userBtn.addActionListener(this);
		this.panel.add(userBtn);
		
		this.flightBtn= new JButton("Flights");
		this.flightBtn.setBounds(810, 250, 200, 50);
		this.flightBtn.addActionListener(this);
		this.panel.add(flightBtn);
		
		
		this.logoutBtn= new JButton("LogOut");
		this.logoutBtn.setBounds(810, 370, 200, 50);
		this.logoutBtn.addActionListener(this);
		this.panel.add(logoutBtn);
		
		
		
		this.paymentBtn=new JButton("Payments");
		this.paymentBtn.setBounds(120, 250,200, 50 );
		this.paymentBtn.addActionListener(this);
		this.panel.add(paymentBtn);
		
		this.reservationBtn=new JButton("Reservations");
		this.reservationBtn.setBounds(350, 250, 200, 50 );
		this.reservationBtn.addActionListener(this);
		this.panel.add(reservationBtn);
		
		this.updateProfileBtn= new JButton("Update Profile");
		this.updateProfileBtn.setBounds(120, 370, 200, 50);
		this.updateProfileBtn.addActionListener(this);
		this.panel.add(updateProfileBtn);
		
		
		
		this.add(panel);
		this.u=u;
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String command=ae.getActionCommand();
		System.out.println("Button pressed: " + command);
		if(adminBtn.getText().equals(command))
		{
			AdminOperationFrame aof= new AdminOperationFrame(u);
			System.out.println("Starting Admin Operation Frame");
			this.setVisible(false);
			aof.setVisible(true);
		}
		//adminBtn, customerBtn, employeeBtn, flightBtn, paymentBtn, reservationBtn, userBtn;
		if(customerBtn.getText().equals(command))
		{
			
			CustomerOperationFrame cof= new CustomerOperationFrame(u);
			this.setVisible(false);
			cof.setVisible(true);
			
			
		}
		
		if(employeeBtn.getText().equals(command))
		{
			
			EmployeeOperationFrame eof= new EmployeeOperationFrame(u);
			this.setVisible(false);
			eof.setVisible(true);
			
		}
		
		if(flightBtn.getText().equals(command))
		{
			
			AllFlightFrame fof = new AllFlightFrame(u);
			this.setVisible(false);
			fof.setVisible(true);
			
		}
		
		if(paymentBtn.getText().equals(command))
		{
			
			AllPaymentFrame pof= new AllPaymentFrame(u);
			this.setVisible(false);
			pof.setVisible(true);
			
		}
		if(reservationBtn.getText().equals(command))
		{
			
			AllReservationFrame rof = new AllReservationFrame(u);
			this.setVisible(false);
			rof.setVisible(true);
			
		}
		if(userBtn.getText().equals(command))
		{
			
			UserOperationFrame uof = new UserOperationFrame(u);
			this.setVisible(false);
			uof.setVisible(true);
			
		}
		
		if(updateProfileBtn.getText().equals(command))
		{
			
			AdminUpdateProfileFrame aupf= new AdminUpdateProfileFrame(u);
			this.setVisible(false);
			aupf.setVisible(true);
			
			
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








