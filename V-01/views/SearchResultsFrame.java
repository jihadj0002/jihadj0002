package views;

import javax.swing.*;
import models.*;
import controllers.*;
import java.awt.*;
import java.awt.event.*;

public class SearchResultsFrame extends JFrame {
    private JPanel panel;
    private JTable flightTable;
    private JScrollPane flightTableSP;
    private JButton backButton;
    private Customer customer;

    public SearchResultsFrame(Customer customer, Flight[] flights) {
        this.customer = customer;
        setTitle("Search Results");
        setSize(1280, 720);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(null);
        setContentPane(panel);

        // Convert Flight array to 2D String array
        String flightData[][] = new String[flights.length][8];
        for (int i = 0; i < flights.length; i++) {
            if (flights[i] != null) {
                flightData[i][0] = flights[i].getFlightId();
                flightData[i][1] = flights[i].getFlightName();
                flightData[i][2] = flights[i].getSource();
                flightData[i][3] = flights[i].getDestination();
                flightData[i][4] = flights[i].getDepartureDate();
                flightData[i][5] = flights[i].getArrivalDate();
                flightData[i][6] = String.valueOf(flights[i].getPrice());
                flightData[i][7] = String.valueOf(flights[i].getSeatAvailability());
            }
        }

        // Column names
        String columns[] = {"Flight ID", "Flight Name", "Source", "Destination", "Departure Date", "Arrival Date", "Price", "Seats Available"};

        // Creating the table
        flightTable = new JTable(flightData, columns);
        flightTableSP = new JScrollPane(flightTable);
        flightTableSP.setBounds(100, 100, 1080, 400);
        flightTable.setEnabled(false);
        panel.add(flightTableSP);

        // Back button
        backButton = new JButton("Back");
        backButton.setBounds(540, 550, 200, 50);
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                UserController uc=new UserController();
				CustomerController cc= new CustomerController();
                setVisible(false);
				
				User u= uc.searchUser(customer.getUserId());
                SearchFlightsFrame sff= new SearchFlightsFrame(u);
                sff.setVisible(true);
            }
        });
        panel.add(backButton);

        panel.revalidate();
        panel.repaint();
        setVisible(true);
    }
	/*
	public void actionPerformed(ActionEvent ae) 
	{
		String command = ae.getActionCommand();
			
			if(command.equals(backButton.getText()))
			{
				UserController uc=new UserController();
				CustomerController cc= new CustomerController();
                setVisible(false);
				
				User u= uc.searchUser(customer.getUserId());
                SearchFlightsFrame sff= new SearchFlightsFrame(u);
                ssf.setVisible(true);
            }
	}
	*/
}
