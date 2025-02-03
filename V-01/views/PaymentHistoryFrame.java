package views;

import javax.swing.*;
import java.awt.event.*;
import models.*;
import controllers.*;

public class PaymentHistoryFrame extends JFrame implements ActionListener 
{
    private JButton backBtn;
    private JTable PaymentTable;
    private JScrollPane PaymentTableSP;
    private JPanel panel;
    private Customer customer;
	private User u;

    public PaymentHistoryFrame(User u) {
        super("View Booked Flights");
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.panel = new JPanel();
        this.panel.setLayout(null);
        
        this.backBtn = new JButton("Back");
        this.backBtn.setBounds(50, 50, 100, 30);
        this.backBtn.addActionListener(this);
        this.panel.add(backBtn);
        
        PaymentController rc = new PaymentController();
        Payment p[] = rc.getPaymentsByCustomer(u.getUserId());
        
        String PaymentData[][] = new String[p.length][6];
        for (int i = 0; i < p.length; i++) {
            if (p[i] != null) {
                PaymentData[i][0] = p[i].getPaymentId();
                PaymentData[i][1] = p[i].getReservationId();
                PaymentData[i][2] = p[i].getPaymentDate();
                PaymentData[i][3] = p[i].getPaymentMethod();
                PaymentData[i][4] = String.valueOf(p[i].getAmount());
            }
        }
        
        String columns[] = {"Payment Id", "Reservation ID", "Payment Date", "Payment Method", "Amount"};
        this.PaymentTable = new JTable(PaymentData, columns);
        this.PaymentTableSP = new JScrollPane(PaymentTable);
        this.PaymentTableSP.setBounds(50, 110, 700, 450);
        this.PaymentTable.setEnabled(false);
        this.panel.add(PaymentTableSP);
        
        this.panel.revalidate();
        this.panel.repaint();
        this.add(panel);
        
        this.customer = customer;
		this.u=u;
    }
    
    public void actionPerformed(ActionEvent ae) 
	{
        if (ae.getSource() == backBtn) 
		{
			
            CustomerHomeFrame chf = new CustomerHomeFrame(this.u);
            this.setVisible(false);
            chf.setVisible(true);
        }
    }
}
