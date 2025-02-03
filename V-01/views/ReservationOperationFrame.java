package views;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import models.*;
import controllers.*;

public class ReservationOperationFrame extends JFrame implements ActionListener
{
	
	//String userId, String ReservationId, String reservationId, int amount, String ReservationDate, String ReservationMethod
	private JLabel reservationIdLabel, flightIdLabel, userIdLabel, bookingDateLabel, seatNumberLabel, statusLabel;
	private JTextField reservationIdTF, flightIdTF, userIdTF, bookingDateTF, seatNumberTF;
	private JComboBox statusCMB;
	private JButton addBtn, removeBtn, updateBtn, resetBtn, searchBtn, backBtn;
	private JTable ReservationTable;
	private JScrollPane ReservationTableSP;
	private JPanel panel;
	private User u;
	
	
	public ReservationOperationFrame(User u)
	{
		super("Reservation Operation Frame");
		this.setSize(1280, 720);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panel= new JPanel();
		this.panel.setLayout(null);
		
		this.reservationIdLabel=new JLabel("Reservation Id:");
		this.reservationIdLabel.setBounds(100,100,120,30);
		this.panel.add(reservationIdLabel);
		
		this.reservationIdTF = new JTextField();
		this.reservationIdTF.setBounds(240, 100, 100, 30);
		this.panel.add(reservationIdTF);
		
		this.flightIdLabel=new JLabel("Flight ID:");
		this.flightIdLabel.setBounds(100,160,120,30);
		this.panel.add(flightIdLabel);
		
		this.flightIdTF = new JTextField();
		this.flightIdTF.setBounds(240, 160, 100, 30);
		this.panel.add(flightIdTF);
		
		this.userIdLabel=new JLabel("User ID:");
		this.userIdLabel.setBounds(100,220,120,30);
		this.panel.add(userIdLabel);
		
		this.userIdTF = new JTextField();
		this.userIdTF.setBounds(240, 220, 100, 30);
		this.panel.add(userIdTF);
		
		this.bookingDateLabel=new JLabel("Booking Date:");
		this.bookingDateLabel.setBounds(100,280,120,30);
		this.panel.add(bookingDateLabel);
		
		this.bookingDateTF = new JTextField();
		this.bookingDateTF.setBounds(240, 280, 100, 30);
		this.panel.add(bookingDateTF);
		
		this.seatNumberLabel=new JLabel("Seat Number:");
		this.seatNumberLabel.setBounds(380,100,120,30);
		this.panel.add(seatNumberLabel);
		
		this.seatNumberTF= new JTextField();
		this.seatNumberTF.setBounds(520, 100, 100, 30);
		this.panel.add(seatNumberTF);
		
		this.statusLabel = new JLabel("Status: ");
		this.statusLabel.setBounds(100, 340, 120, 30);
		this.panel.add(statusLabel);
		
		String[] item={"Reserved", "Open"};
		this.statusCMB = new JComboBox(item);
		this.statusCMB.setBounds(250, 340, 200, 30);
		this.panel.add(statusCMB);
		
		
		//addBtn, removeBtn, updateBtn, resetBtn, searchBtn, backBtn;
		
		
		this.addBtn= new JButton("Add Reservation");
		this.addBtn.setBounds(100, 400, 140, 30);
		this.addBtn.addActionListener(this);
		this.panel.add(addBtn);
		
		this.updateBtn = new JButton("Update Reservation");
		this.updateBtn.setBounds(260, 400, 160,30);
		this.updateBtn.addActionListener(this);
		this.panel.add(updateBtn);
		
		this.removeBtn = new JButton("Remove Reservation");
		this.removeBtn.setBounds(440, 400, 160, 30);
		this.removeBtn.addActionListener(this);
		this.panel.add(removeBtn);
		
		this.searchBtn = new JButton("Search Reservation");
		this.searchBtn.setBounds(620, 400, 160, 30);
		this.searchBtn.addActionListener(this);
		this.panel.add(searchBtn);
		
		this.resetBtn = new JButton("Reset");
		this.resetBtn.setBounds(800, 400, 100, 30);
		this.resetBtn.addActionListener(this);
		this.panel.add(resetBtn);
		
		this.backBtn = new JButton("Back");
		this.backBtn.setBounds(920, 400, 120, 30);
		this.backBtn.addActionListener(this);
		this.panel.add(backBtn);
		
		//Get All Reservation
		
		//getting all the Reservations info in Reservation type array
		ReservationController rc=new ReservationController();
		Reservation[] ReservationList=rc.getAllReservation();
		//converting the Reservation type array in 2d String type array to put the values in the table beacuse in table there will be tow dimention. one is row, other one is colomn.
		String ReservationData1[][]=new String[ReservationList.length][6];
		for(int i=0;i<ReservationList.length;i++)
		{
			//String reservationId, String flightId, String userId, String bookingDate, String seatNumber, boolean status
			if(ReservationList[i]!=null)
			{
				System.out.println(ReservationList[i].toStringReservation());
				ReservationData1[i][0]=ReservationList[i].getReservationId();
				ReservationData1[i][1]=ReservationList[i].getFlightId();
				ReservationData1[i][2]=ReservationList[i].getUserId();
				ReservationData1[i][3]=String.valueOf(ReservationList[i].getStatus());
				ReservationData1[i][4]=ReservationList[i].getBookingDate();
				ReservationData1[i][5]=ReservationList[i].getSeatNumber();
			}
			
			
			
		}
		//creating Table.
		//head1 is the colomn name;
		String head1[]={"Reservation Id","Flight ID","User ID","Status","Booking Date","Seat Number"};
		//putting value and colomn name in the table.
		this.ReservationTable=new JTable(ReservationData1,head1);
		//adding scrolling bar in the table
		this.ReservationTableSP=new JScrollPane(ReservationTable);
		this.ReservationTableSP.setBounds(100,450,800,500);
		this.ReservationTable.setEnabled(false);
		this.panel.add(ReservationTableSP);
		
		this.panel.revalidate();
		this.panel.repaint();
		
		this.add(panel);
		
		this.u=u;
		
		
		
		
	}
	
	//Add Button
	
	public void actionPerformed(ActionEvent ae)
	{
		
		String command=ae.getActionCommand();
		System.out.println(command);
		
		//String reservationId, String flightId, String userId, String bookingDate, String seatNumber, boolean status)
		if(command.equals(addBtn.getText()))
		{
			System.out.println("Add Button Working");
			
			if(!reservationIdTF.getText().isEmpty() && !flightIdTF.getText().isEmpty() && !userIdTF.getText().isEmpty() && !bookingDateTF.getText().isEmpty() && !seatNumberTF.getText().isEmpty())
			{
				ReservationController rc = new ReservationController();
				
				Reservation r=rc.searchReservation(userIdTF.getText());
				
				if(r!=null)
				{
					JOptionPane.showMessageDialog(this, "Reservation Id is already used");
				}
				else
				{
					//String userId, String ReservationId, String reservationId, int amount, String ReservationDate, String ReservationMethod
					String userId=userIdTF.getText();
					String flightId=flightIdTF.getText();
					String reservationId=reservationIdTF.getText();
					boolean status=false;
					
					if(statusCMB.getSelectedItem().toString()=="Reserved")
					{
						status=true;
					}
					
					String seatNumber = seatNumberTF.getText();
					String bookingDate= bookingDateTF.getText();
					
					
					//String reservationId, String flightId, String userId, String bookingDate, String seatNumber, boolean status)
					Reservation pp= new Reservation(reservationId, flightId, userId, bookingDate, seatNumber, status);
					rc.insertReservation(pp);
					
					JOptionPane.showMessageDialog(this, "Reservation Added Succesfully");
					
					this.setVisible(false);
					ReservationOperationFrame rof= new ReservationOperationFrame(u);
					rof.setVisible(true);
				}
				
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Please Fill Up the form");
			}
		}
		
		if(command.equals(updateBtn.getText()))
		{
			if(!reservationIdTF.getText().isEmpty() && !flightIdTF.getText().isEmpty() && !userIdTF.getText().isEmpty() && !bookingDateTF.getText().isEmpty() && !seatNumberTF.getText().isEmpty())
			{
				ReservationController rc=new ReservationController();
				Reservation r=rc.searchReservation(reservationIdTF.getText());
				if(r!=null)
				{
					//String reservationId, String flightId, String userId, String bookingDate, String seatNumber, boolean status
					String userId=userIdTF.getText();
					String flightId=flightIdTF.getText();
					String reservationId=reservationIdTF.getText();
					boolean status=false;
					
					if(statusCMB.getSelectedItem().toString()=="Reserved")
					{
						status=true;
					}
					
					String seatNumber = seatNumberTF.getText();
					String bookingDate= bookingDateTF.getText();
					
					
					
					r.setUserId(userId);
					r.setReservationId(reservationId);
					r.setFlightId(reservationId);
					r.setStatus(status);
					r.setSeatNumber(seatNumber);
					r.setBookingDate(bookingDate);
					
					
					rc.updateReservation(r);
					
					JOptionPane.showMessageDialog(this, "Reservation Updated Succesfully");
					
					this.setVisible(false);
					ReservationOperationFrame rof= new ReservationOperationFrame(u);
					rof.setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Reservation Not found");
				}
			}
			
			else
			{
				JOptionPane.showMessageDialog(this, "Please Fill up the form correctly.");
			}
		}
		
		if(command.equals(removeBtn.getText()))
		{
			if(!flightIdTF.getText().isEmpty())
			{
				String ReservationId= reservationIdTF.getText();
				ReservationController rc= new ReservationController();
				Reservation r=rc.searchReservation(ReservationId);
				
				if(r!=null)
				{
					rc.deleteReservation(ReservationId);
					JOptionPane.showMessageDialog(this, "Reservation Deleted Succesfully");
					System.out.println(ReservationId +" Deletation Complete");
					
					ReservationOperationFrame rof= new ReservationOperationFrame(u);
					this.setVisible(false);
					rof.setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(this, "Not Found");
				}
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Reservation Id Not Found");
			}
			
		}
		
		if(command.equals(searchBtn.getText()))
		{
			if(!reservationIdTF.getText().isEmpty())
			{
				ReservationController rc = new ReservationController();
				String ReservationId=reservationIdTF.getText();
				Reservation r= rc.searchReservation(ReservationId);
				
				if(r!=null)
				{
					reservationIdTF.setEnabled(false);
					userIdTF.setText(r.getUserId());
					flightIdTF.setText(r.getFlightId());
					bookingDateTF.setText(r.getBookingDate());
					seatNumberTF.setText(r.getSeatNumber());
					//statusCMB.setSelectedItem(p.getReservationMethod());
					
				}
				else
				{
					JOptionPane.showMessageDialog(this, "Reservation Not found");
				}
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Please Provide Reservation Id");
			}
		}
		
		if(command.equals(resetBtn.getText()))
		{
			
			flightIdTF.setEnabled(true);
			userIdTF.setText("");
			reservationIdTF.setText("");
			bookingDateTF.setText("");
			seatNumberTF.setText("");
			
		}
		
		if(command.equals(backBtn.getText()))
		{
			EmployeeHomeFrame ehf= new EmployeeHomeFrame(this.u);
			this.setVisible(false);
			ehf.setVisible(true);
		}
		
		
		
		
		
		
		
		
		
				
	}
		

}