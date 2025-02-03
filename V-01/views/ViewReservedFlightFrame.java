package views;

import javax.swing.*;
import java.awt.event.*;
import models.*;
import controllers.*;

public class ViewReservedFlightFrame extends JFrame implements ActionListener 
{
    private JButton backBtn;
    private JTable reservedFlightsTable;
    private JScrollPane reservedFlightsTableSP;
    private JPanel panel;
    private Customer customer;
	private User u;

    public ViewReservedFlightFrame(User u) {
        super("View Booked Flights");
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.panel = new JPanel();
        this.panel.setLayout(null);
        
        this.backBtn = new JButton("Back");
        this.backBtn.setBounds(50, 50, 100, 30);
        this.backBtn.addActionListener(this);
        this.panel.add(backBtn);
        
        ReservationController rc = new ReservationController();
        Reservation reservedFlights[] = rc.getBookedFlightsByCustomer(u.getUserId());
        
        String reservedFlightsData[][] = new String[reservedFlights.length][6];
        for (int i = 0; i < reservedFlights.length; i++) {
            if (reservedFlights[i] != null) {
                reservedFlightsData[i][0] = reservedFlights[i].getReservationId();
                reservedFlightsData[i][1] = reservedFlights[i].getFlightId();
                reservedFlightsData[i][2] = reservedFlights[i].getBookingDate();
                reservedFlightsData[i][3] = reservedFlights[i].getSeatNumber();
                reservedFlightsData[i][4] = String.valueOf(reservedFlights[i].getStatus());
            }
        }
        
        String columns[] = {"Reservation Id", "Flight ID", "Booking Date", "Seat Number", "Status"};
        this.reservedFlightsTable = new JTable(reservedFlightsData, columns);
        this.reservedFlightsTableSP = new JScrollPane(reservedFlightsTable);
        this.reservedFlightsTableSP.setBounds(50, 110, 700, 450);
        this.reservedFlightsTable.setEnabled(false);
        this.panel.add(reservedFlightsTableSP);
        
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
