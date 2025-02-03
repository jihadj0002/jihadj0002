package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import controllers.*;
import models.*;

public class SearchFlightsFrame extends JFrame implements ActionListener 
{
    private JPanel panel;
    private JLabel titleLabel, sourceLabel, destinationLabel;
    private JTextField sourceField, destinationField;
    private JButton searchButton, backButton;
    private Customer customer;
	private User u;

    public SearchFlightsFrame(User u) 
	{
        
        setTitle("Search Flights");
        setSize(1280, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.panel=new JPanel();
        panel.setLayout(null);
		
		CustomerController cc= new CustomerController();
		this.customer=cc.searchCustomer(u.getUserId());
        
        titleLabel = new JLabel("Search Flights");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setBounds(500, 30, 300, 40);
        this.panel.add(titleLabel);
        
        sourceLabel = new JLabel("Source:");
        sourceLabel.setBounds(400, 100, 100, 30);
        this.panel.add(sourceLabel);
        
        sourceField = new JTextField();
        sourceField.setBounds(500, 100, 300, 30);
        this.panel.add(sourceField);
        
        destinationLabel = new JLabel("Destination:");
        destinationLabel.setBounds(400, 150, 100, 30);
        this.panel.add(destinationLabel);
        
        destinationField = new JTextField();
        destinationField.setBounds(500, 150, 300, 30);
        this.panel.add(destinationField);
        
        searchButton = new JButton("Search");
        searchButton.setBounds(500, 200, 150, 40);
        searchButton.addActionListener(this);
        this.panel.add(searchButton);
        
        backButton = new JButton("Back");
        backButton.setBounds(660, 200, 150, 40);
        backButton.addActionListener(this);
        this.panel.add(backButton);
        
        this.add(panel);
		this.u=u;
    }

    @Override
    public void actionPerformed(ActionEvent ae) 
	{
		String command=ae.getActionCommand();
        if(command.equals(backButton.getText()))
		{
			CustomerHomeFrame chf=new CustomerHomeFrame(this.u);
			this.setVisible(false);
			chf.setVisible(true);
			
		}
    }
}
