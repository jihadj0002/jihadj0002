package views;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import models.*;
import controllers.*;

public class PaymentOperationFrame extends JFrame implements ActionListener
{
	
	//String userId, String paymentId, String reservationId, int amount, String paymentDate, String paymentMethod
	private JLabel userIdLabel, paymentIdLabel, reservationIdLabel, amountLabel, paymentDateLabel, paymentMethodLabel;
	private JTextField userIdTF, paymentIdTF, reservationIdTF, amountTF, paymentDateTF;
	private JComboBox paymentMethodCMB;
	private JButton addBtn, removeBtn, updateBtn, resetBtn, searchBtn, backBtn;
	private JTable PaymentTable;
	private JScrollPane PaymentTableSP;
	private JPanel panel;
	private User u;
	
	
	public PaymentOperationFrame(User u)
	{
		super("Payment Operation Frame");
		this.setSize(1280, 720);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panel= new JPanel();
		this.panel.setLayout(null);
		
		this.userIdLabel=new JLabel("User Id:");
		this.userIdLabel.setBounds(100,100,120,30);
		this.panel.add(userIdLabel);
		
		this.userIdTF = new JTextField();
		this.userIdTF.setBounds(240, 100, 100, 30);
		this.panel.add(userIdTF);
		
		this.paymentIdLabel=new JLabel("Payment ID:");
		this.paymentIdLabel.setBounds(100,160,120,30);
		this.panel.add(paymentIdLabel);
		
		this.paymentIdTF = new JTextField();
		this.paymentIdTF.setBounds(240, 160, 100, 30);
		this.panel.add(paymentIdTF);
		
		this.reservationIdLabel=new JLabel("Reservation ID:");
		this.reservationIdLabel.setBounds(100,220,120,30);
		this.panel.add(reservationIdLabel);
		
		this.reservationIdTF = new JTextField();
		this.reservationIdTF.setBounds(240, 220, 100, 30);
		this.panel.add(reservationIdTF);
		
		this.amountLabel=new JLabel("Amount:");
		this.amountLabel.setBounds(100,280,120,30);
		this.panel.add(amountLabel);
		
		this.amountTF = new JTextField();
		this.amountTF.setBounds(240, 280, 100, 30);
		this.panel.add(amountTF);
		
		this.paymentDateLabel=new JLabel("Payment Date:");
		this.paymentDateLabel.setBounds(380,100,120,30);
		this.panel.add(paymentDateLabel);
		
		this.paymentDateTF= new JTextField();
		this.paymentDateTF.setBounds(520, 100, 100, 30);
		this.panel.add(paymentDateTF);
		
		this.paymentMethodLabel = new JLabel("Payment Method: ");
		this.paymentMethodLabel.setBounds(100, 340, 120, 30);
		this.panel.add(paymentMethodLabel);
		
		String[] item={"Bank", "Bkash", "Nagad"};
		this.paymentMethodCMB = new JComboBox(item);
		this.paymentMethodCMB.setBounds(250, 340, 200, 30);
		this.panel.add(paymentMethodCMB);
		
		
		//addBtn, removeBtn, updateBtn, resetBtn, searchBtn, backBtn;
		
		
		this.addBtn= new JButton("Add Payment");
		this.addBtn.setBounds(100, 400, 140, 30);
		this.addBtn.addActionListener(this);
		this.panel.add(addBtn);
		
		this.updateBtn = new JButton("Update Payment");
		this.updateBtn.setBounds(260, 400, 140,30);
		this.updateBtn.addActionListener(this);
		this.panel.add(updateBtn);
		
		this.removeBtn = new JButton("Remove Payment");
		this.removeBtn.setBounds(420, 400, 140, 30);
		this.removeBtn.addActionListener(this);
		this.panel.add(removeBtn);
		
		this.searchBtn = new JButton("Search Payment");
		this.searchBtn.setBounds(580, 400, 140, 30);
		this.searchBtn.addActionListener(this);
		this.panel.add(searchBtn);
		
		this.resetBtn = new JButton("Reset");
		this.resetBtn.setBounds(600, 400, 120, 30);
		this.resetBtn.addActionListener(this);
		this.panel.add(resetBtn);
		
		this.backBtn = new JButton("Back");
		this.backBtn.setBounds(730, 400, 120, 30);
		this.backBtn.addActionListener(this);
		this.panel.add(backBtn);
		
		//Get All Payment
		
		//getting all the Payments info in Payment type array
		PaymentController fc=new PaymentController();
		Payment[] PaymentList=fc.getAllPayment();
		//converting the Payment type array in 2d String type array to put the values in the table beacuse in table there will be tow dimention. one is row, other one is colomn.
		String PaymentData1[][]=new String[PaymentList.length][6];
		for(int i=0;i<PaymentList.length;i++)
		{
			//String userId, String paymentId, String reservationId, int amount, String paymentDate, String paymentMethod
			if(PaymentList[i]!=null)
			{
				System.out.println(PaymentList[i].toStringPayment());
				PaymentData1[i][0]=PaymentList[i].getUserId();
				PaymentData1[i][1]=PaymentList[i].getPaymentId();
				PaymentData1[i][2]=PaymentList[i].getReservationId();
				PaymentData1[i][3]=String.valueOf(PaymentList[i].getAmount());
				PaymentData1[i][4]=PaymentList[i].getPaymentDate();
				PaymentData1[i][5]=PaymentList[i].getPaymentMethod();
			}
			
			
			
		}
		//creating Table.
		//head1 is the colomn name;
		String head1[]={"User Id","Payment ID","Reservation ID","Amount","Payment Date","Payment Method"};
		//putting value and colomn name in the table.
		this.PaymentTable=new JTable(PaymentData1,head1);
		//adding scrolling bar in the table
		this.PaymentTableSP=new JScrollPane(PaymentTable);
		this.PaymentTableSP.setBounds(100,450,800,500);
		this.PaymentTable.setEnabled(false);
		this.panel.add(PaymentTableSP);
		
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
		
		
		if(command.equals(addBtn.getText()))
		{
			System.out.println("Add Button Working");
			//String userId, String paymentId, 								String reservationId, int amount, 								String paymentDate, 					String paymentMethod)
			if(!userIdTF.getText().isEmpty() && !paymentIdTF.getText().isEmpty() && !reservationIdTF.getText().isEmpty() && !amountTF.getText().isEmpty() && !paymentDateTF.getText().isEmpty())
			{
				PaymentController pc = new PaymentController();
				
				Payment p=pc.searchPaymentByPay(paymentIdTF.getText());
				
				if(p!=null)
				{
					JOptionPane.showMessageDialog(this, "Payment Id is already used");
				}
				else
				{
					//String userId, String paymentId, String reservationId, int amount, String paymentDate, String paymentMethod
					String userId=userIdTF.getText();
					String paymentId=paymentIdTF.getText();
					String reservationId=reservationIdTF.getText();
					int amount=0;
					try
					{
						amount=Integer.parseInt(amountTF.getText());
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
					
					String paymentDate = paymentDateTF.getText();
					String paymentMethod= paymentMethodCMB.getSelectedItem().toString();
					
					
					//paymentId PaymentName, source, destination, departureDate, arrivalDate, 				departureTime, 	arrivalTime, int price, seatAvailability)
					Payment pp= new Payment(userId, paymentId, reservationId, amount, paymentDate, paymentMethod);
					pc.insertPayment(pp);
					
					JOptionPane.showMessageDialog(this, "Payment Added Succesfully");
					
					this.setVisible(false);
					PaymentOperationFrame ahf= new PaymentOperationFrame(u);
					ahf.setVisible(true);
				}
				
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Please Fill Up the form");
			}
		}
		
		if(command.equals(updateBtn.getText()))
		{
			if(!userIdTF.getText().isEmpty() && !paymentIdTF.getText().isEmpty() && !reservationIdTF.getText().isEmpty() && !amountTF.getText().isEmpty() && !paymentDateTF.getText().isEmpty())
			{
				PaymentController pc=new PaymentController();
				Payment p=pc.searchPayment(userIdTF.getText());
				if(p!=null)
				{
					String userId=userIdTF.getText();
					String paymentId=paymentIdTF.getText();
					String reservationId=reservationIdTF.getText();
					int amount=0;
					try
					{
						amount=Integer.parseInt(amountTF.getText());
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
					
					String paymentDate = paymentDateTF.getText();
					String paymentMethod= paymentMethodCMB.getSelectedItem().toString();
					
					
					p.setUserId(userId);
					p.setPaymentId(paymentId);
					p.setReservationId(reservationId);
					p.setAmount(amount);
					p.setPaymentDate(paymentDate);
					p.setPaymentMethod(paymentMethod);
					
					
					pc.updatePayment(p);
					
					JOptionPane.showMessageDialog(this, "Payment Updated Succesfully");
					
					this.setVisible(false);
					PaymentOperationFrame pof= new PaymentOperationFrame(u);
					pof.setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Payment Not found");
				}
			}
			
			else
			{
				JOptionPane.showMessageDialog(this, "Please Fill up the form correctly.");
			}
		}
		
		if(command.equals(removeBtn.getText()))
		{
			if(!paymentIdTF.getText().isEmpty())
			{
				String paymentId= paymentIdTF.getText();
				PaymentController pc= new PaymentController();
				Payment p=pc.searchPayment(paymentId);
				
				if(p!=null)
				{
					pc.deletePayment(paymentId);
					JOptionPane.showMessageDialog(this, "Payment Deleted Succesfully");
					System.out.println(paymentId +" Deletation Complete");
					PaymentOperationFrame pof= new PaymentOperationFrame(u);
					this.setVisible(false);
					pof.setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(this, "Not Found");
				}
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Payment Id Not Found");
			}
			
		}
		
		if(command.equals(searchBtn.getText()))
		{
			if(!userIdTF.getText().isEmpty())
			{
				PaymentController pc = new PaymentController();
				String paymentId=paymentIdTF.getText();
				Payment p= pc.searchPayment(paymentId);
				
				if(p!=null)
				{
					paymentIdTF.setEnabled(false);
					userIdTF.setText(p.getUserId());
					reservationIdTF.setText(p.getReservationId());
					amountTF.setText(String.valueOf(p.getAmount()));
					paymentDateTF.setText(p.getPaymentDate());
					paymentMethodCMB.setSelectedItem(p.getPaymentMethod());
					
				}
				else
				{
					JOptionPane.showMessageDialog(this, "Payment Not found");
				}
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Please Provide Payment Id");
			}
		}
		
		if(command.equals(resetBtn.getText()))
		{
			
			paymentIdTF.setEnabled(true);
			userIdTF.setText("");
			reservationIdTF.setText("");
			amountTF.setText("");
			paymentDateTF.setText("");
			
		}
		
		if(command.equals(backBtn.getText()))
		{
			EmployeeHomeFrame ehf= new EmployeeHomeFrame(this.u);
			this.setVisible(false);
			ehf.setVisible(true);
		}
		
		
		
		
		
		
		
		
		
				
	}
		

}