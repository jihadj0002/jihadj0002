package views;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import models.*;
import controllers.*;

public class AllPaymentFrame extends JFrame implements ActionListener
{
	private JButton backBtn;
	private JTable paymentTable;
	private JScrollPane paymentTableSP;
	private JPanel panel;
	private User u;
	
	
	public AllPaymentFrame(User u)
	{
		super("All Payment Frame");
		this.setSize(1280, 720);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panel= new JPanel();
		this.panel.setLayout(null);
		
		this.backBtn= new JButton("Back");
		this.backBtn.setBounds(100,70,100,30);
		this.backBtn.addActionListener(this);
		this.panel.add(backBtn);
		
		PaymentController fc = new PaymentController();
		Payment PaymentList[]=fc.getAllPayment();
		
		//1d to 2d
		//userId, paymentId, reservationId, int amount, paymentDate, paymentMethod)
		
		String PaymentData[][]= new String[PaymentList.length][6];
		
		for(int i=0; i<PaymentList.length; i++)
		{
			if(PaymentList[i]!=null)
			{
				PaymentData[i][0]=PaymentList[i].getUserId();
				PaymentData[i][1]=PaymentList[i].getPaymentId();
				PaymentData[i][2]=PaymentList[i].getReservationId();
				PaymentData[i][3]=String.valueOf(PaymentList[i].getAmount());
				PaymentData[i][4]=PaymentList[i].getPaymentDate();
				PaymentData[i][5]=PaymentList[i].getPaymentMethod();
				
			}
		}
		
		String head[]={"User ID", "Payment ID", "Reservation ID","Amount","Payment Date","Payment Method"};
		
		this.paymentTable=new JTable(PaymentData, head);
		
		this.paymentTableSP= new JScrollPane(paymentTable);
		this.paymentTableSP.setBounds(100, 120, 1000, 600);
		this.paymentTable.setEnabled(false);
		this.panel.add(paymentTableSP);
		
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
