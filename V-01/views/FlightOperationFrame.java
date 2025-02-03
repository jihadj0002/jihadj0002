package views;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import models.*;
import controllers.*;

public class FlightOperationFrame extends JFrame implements ActionListener
{
	private JLabel flightIdLabel, flightNameLabel, sourceLabel, destinationLabel, departureDateLabel, arrivalDateLabel, departureTimeLabel, arrivalTimeLabel, priceLabel, seatAvailabilityLabel;
	private JTextField flightIdTF, flightNameTF, sourceTF, destinationTF, departureDateTF, arrivalDateTF, departureTimeTF, arrivalTimeTF, priceTF, seatAvailabilityTF ;
	private JButton addBtn, removeBtn, updateBtn, resetBtn, searchBtn, backBtn;
	private JTable flightTable;
	private JScrollPane flightTableSP;
	private JPanel panel;
	private User u;
	
	
	public FlightOperationFrame(User u)
	{
		super("Flight Operation Frame");
		this.setSize(1280, 720);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panel= new JPanel();
		this.panel.setLayout(null);
		
		this.flightIdLabel=new JLabel("Flight Id:");
		this.flightIdLabel.setBounds(100,100,120,30);
		this.panel.add(flightIdLabel);
		
		this.flightIdTF = new JTextField();
		this.flightIdTF.setBounds(240, 100, 100, 30);
		this.panel.add(flightIdTF);
		
		this.flightNameLabel=new JLabel("Flight Name:");
		this.flightNameLabel.setBounds(100,160,120,30);
		this.panel.add(flightNameLabel);
		
		this.flightNameTF = new JTextField();
		this.flightNameTF.setBounds(240, 160, 100, 30);
		this.panel.add(flightNameTF);
		
		this.sourceLabel=new JLabel("Source:");
		this.sourceLabel.setBounds(100,220,120,30);
		this.panel.add(sourceLabel);
		
		this.sourceTF = new JTextField();
		this.sourceTF.setBounds(240, 220, 100, 30);
		this.panel.add(sourceTF);
		
		this.destinationLabel=new JLabel("Destination:");
		this.destinationLabel.setBounds(100,280,120,30);
		this.panel.add(destinationLabel);
		
		this.destinationTF = new JTextField();
		this.destinationTF.setBounds(240, 280, 100, 30);
		this.panel.add(destinationTF);
		
		this.departureDateLabel=new JLabel("Departure Date:");
		this.departureDateLabel.setBounds(380,100,120,30);
		this.panel.add(departureDateLabel);
		
		this.departureDateTF= new JTextField();
		this.departureDateTF.setBounds(520, 100, 100, 30);
		this.panel.add(departureDateTF);
		
		
		this.departureTimeLabel = new JLabel("Departure Time: ");
		this.departureTimeLabel.setBounds(380, 160, 120, 30);
		this.panel.add(departureTimeLabel);
		
		
		this.departureTimeTF = new JTextField();
		this.departureTimeTF.setBounds(520, 160, 100, 30);
		this.panel.add(departureTimeTF);
		
		
		this.arrivalDateLabel = new JLabel("Arrival Date: ");
		this.arrivalDateLabel.setBounds(380, 220, 120, 30);
		this.panel.add(arrivalDateLabel);
		
		this.arrivalDateTF = new JTextField();
		this.arrivalDateTF.setBounds(520, 220, 100, 30);
		this.panel.add(arrivalDateTF);
		
		this.arrivalTimeLabel = new JLabel("Arrival Time ");
		this.arrivalTimeLabel.setBounds(380, 280, 120, 30);
		this.panel.add(arrivalTimeLabel);
		
		this.arrivalTimeTF = new JTextField();
		this.arrivalTimeTF.setBounds(520, 280, 100, 30);
		this.panel.add(arrivalTimeTF);
		
		this.priceLabel = new JLabel("Price: ");
		this.priceLabel.setBounds(100, 340, 120, 30);
		this.panel.add(priceLabel);
		
		this.priceTF = new JTextField();
		this.priceTF.setBounds(240, 340, 100, 30);
		this.panel.add(priceTF);
		
		this.seatAvailabilityLabel = new JLabel("Available Seat: ");
		this.seatAvailabilityLabel.setBounds(380, 340, 120, 30);
		this.panel.add(seatAvailabilityLabel);
		
		this.seatAvailabilityTF = new JTextField();
		this.seatAvailabilityTF.setBounds(520, 340, 100, 30);
		this.panel.add(seatAvailabilityTF);
		
		//addBtn, removeBtn, updateBtn, resetBtn, searchBtn, backBtn;
		
		
		this.addBtn= new JButton("Add Flight");
		this.addBtn.setBounds(100, 400, 100, 30);
		this.addBtn.addActionListener(this);
		this.panel.add(addBtn);
		
		this.updateBtn = new JButton("Update Flight");
		this.updateBtn.setBounds(210, 400, 120,30);
		this.updateBtn.addActionListener(this);
		this.panel.add(updateBtn);
		
		this.removeBtn = new JButton("Remove Flight");
		this.removeBtn.setBounds(340, 400, 120, 30);
		this.removeBtn.addActionListener(this);
		this.panel.add(removeBtn);
		
		this.searchBtn = new JButton("Search Flight");
		this.searchBtn.setBounds(470, 400, 120, 30);
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
		
		//Get All Flight
		
		//getting all the flights info in Flight type array
		FlightController fc=new FlightController();
		Flight[] flightList=fc.getAllFlight();
		//converting the Flight type array in 2d String type array to put the values in the table beacuse in table there will be tow dimention. one is row, other one is colomn.
		String flightData1[][]=new String[flightList.length][10];
		for(int i=0;i<flightList.length;i++)
		{
			//flightId, flightName, source, destination, departureDate, arrivalDate, departureTime,
			//arrivalTime, int price, seatAvailability
			if(flightList[i]!=null)
			{
				System.out.println(flightList[i].toStringFlight());
				flightData1[i][0]=flightList[i].getFlightId();
				flightData1[i][1]=flightList[i].getFlightName();
				flightData1[i][2]=flightList[i].getSource();
				flightData1[i][3]=flightList[i].getDestination();
				flightData1[i][4]=flightList[i].getDepartureDate();
				flightData1[i][5]=flightList[i].getDepartureTime();
				flightData1[i][6]=flightList[i].getArrivalDate();
				flightData1[i][7]=flightList[i].getArrivalTime();
				flightData1[i][8]=String.valueOf(flightList[i].getPrice());
				flightData1[i][9]=flightList[i].getSeatAvailability();
			}
			
			
			
		}
		//creating Table.
		//head1 is the colomn name;
		String head1[]={"Flight Id","Flight Name","Source","Destination","Departure Date","Departure Time","Arrival Date","Arrival Time", "Price", "Available Seat"};
		//putting value and colomn name in the table.
		this.flightTable=new JTable(flightData1,head1);
		//adding scrolling bar in the table
		this.flightTableSP=new JScrollPane(flightTable);
		this.flightTableSP.setBounds(100,450,800,500);
		this.flightTable.setEnabled(false);
		this.panel.add(flightTableSP);
		
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
			//flightIdTF, flightNameTF, 											sourceTF, 						destinationTF, 							departureDateTF, 					arrivalDateTF, 							departureTimeTF, 							arrivalTimeTF, 							priceTF, 				seatAvailabilityTF
			if(!flightIdTF.getText().isEmpty() && !flightNameTF.getText().isEmpty() && !sourceTF.getText().isEmpty() && !destinationTF.getText().isEmpty() && !departureDateTF.getText().isEmpty() && !arrivalDateTF.getText().isEmpty() && !departureTimeTF.getText().isEmpty() && !arrivalTimeTF.getText().isEmpty() && !priceTF.getText().isEmpty() && !seatAvailabilityTF.getText().isEmpty())
			{
				UserController uc = new UserController();
				FlightController fc=new FlightController();
				Flight f=fc.searchFlight(flightIdTF.getText());
				
				if(f!=null)
				{
					JOptionPane.showMessageDialog(this, "Flight Id is already used");
				}
				else
				{
					//flightId flightName, source, destination, departureDate, arrivalDate, departureTime, 
					//arrivalTime, int price, seatAvailability)
					
					String flightId=flightIdTF.getText();
					String flightName=flightNameTF.getText();
					String source=sourceTF.getText();
					
					String destination = destinationTF.getText();
					String departureDate= departureDateTF.getText();
					String arrivalDate= arrivalDateTF.getText();
					String departureTime=departureTimeTF.getText();
					String arrivalTime= arrivalTimeTF.getText();
					int price=0;
					try
					{
						price=Integer.parseInt(priceTF.getText());
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
					
					String seatAvailability=seatAvailabilityTF.getText();
					
					
					//flightId flightName, source, destination, departureDate, arrivalDate, 				departureTime, 	arrivalTime, int price, seatAvailability)
					Flight a= new Flight(flightId, flightName, source, destination, departureDate, arrivalDate, departureTime,arrivalTime, price, seatAvailability);
					fc.insertFlight(a);
					
					JOptionPane.showMessageDialog(this, "Flight Added Succesfully");
					
					this.setVisible(false);
					FlightOperationFrame ahf= new FlightOperationFrame(u);
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
			if(!flightIdTF.getText().isEmpty() && !flightNameTF.getText().isEmpty() && !sourceTF.getText().isEmpty() && !destinationTF.getText().isEmpty() && !departureDateTF.getText().isEmpty() && !arrivalDateTF.getText().isEmpty() && !departureTimeTF.getText().isEmpty() && !arrivalTimeTF.getText().isEmpty() && !priceTF.getText().isEmpty() && !seatAvailabilityTF.getText().isEmpty())
			{
				FlightController fc=new FlightController();
				Flight f=fc.searchFlight(flightIdTF.getText());
				if(f!=null)
				{
					
					String flightId=flightIdTF.getText();
					String flightName=flightNameTF.getText();
					String source=sourceTF.getText();
					
					String destination = destinationTF.getText();
					String departureDate= departureDateTF.getText();
					String arrivalDate= arrivalDateTF.getText();
					String departureTime=departureTimeTF.getText();
					String arrivalTime= arrivalTimeTF.getText();
					int price=0;
					try
					{
						price=Integer.parseInt(priceTF.getText());
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
					
					String seatAvailability=seatAvailabilityTF.getText();
					
					f.setFlightId(flightId);
					f.setFlightName(flightName);
					f.setSource(source);
					f.setDestination(destination);
					f.setDepartureDate(departureDate);
					f.setDepartureTime(departureTime);
					f.setArrivalDate(arrivalDate);
					f.setArrivalTime(arrivalTime);
					f.setPrice(price);
					f.setSeatAvailability(seatAvailability);
					
					fc.updateFlight(f);
					
					JOptionPane.showMessageDialog(this, "Flight Updated Succesfully");
					
					this.setVisible(false);
					FlightOperationFrame fof= new FlightOperationFrame(u);
					fof.setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Flight Not found");
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
				String flightId= flightIdTF.getText();
				FlightController fc= new FlightController();
				Flight flight=fc.searchFlight(flightId);
				
				if(flight!=null)
				{
					fc.deleteFlight(flightId);
					JOptionPane.showMessageDialog(this, "Flight Deleted Succesfully");
					System.out.println(flightId +" Deletation Complete");
					FlightOperationFrame fof= new FlightOperationFrame(u);
					this.setVisible(false);
					fof.setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(this, "Not Found");
				}
			}
			else
			{
				JOptionPane.showMessageDialog(this, "FLight Id Not Found");
			}
			
		}
		
		if(command.equals(searchBtn.getText()))
		{
			if(!flightIdTF.getText().isEmpty())
			{
				FlightController fc = new FlightController();
				String flightId=flightIdTF.getText();
				Flight f= fc.searchFlight(flightId);
				
				if(f!=null)
				{
					flightIdTF.setEnabled(false);
					flightNameTF.setText(f.getFlightName());
					sourceTF.setText(f.getSource());
					destinationTF.setText(f.getDestination());
					departureDateTF.setText(f.getDepartureDate());
					departureTimeTF.setText(f.getDepartureTime());
					arrivalDateTF.setText(f.getArrivalDate());
					arrivalTimeTF.setText(f.getArrivalTime());
					priceTF.setText(String.valueOf(f.getPrice()));
					seatAvailabilityTF.setText(f.getSeatAvailability());
					
				}
				else
				{
					JOptionPane.showMessageDialog(this, "Flight Not found");
				}
			}
			else	
			{
				JOptionPane.showMessageDialog(this, "Please Provide UserId");
			}
		}
		
		if(command.equals(resetBtn.getText()))
		{
			
			flightIdTF.setEnabled(true);
			flightIdTF.setText("");
			flightNameTF.setText("");
			sourceTF.setText("");
			destinationTF.setText("");
			departureDateTF.setText("");
			departureTimeTF.setText("");
			arrivalDateTF.setText("");
			arrivalTimeTF.setText("");
			priceTF.setText("");
			seatAvailabilityTF.setText("");
		}
		
		if(command.equals(backBtn.getText()))
		{
			EmployeeHomeFrame ehf= new EmployeeHomeFrame(this.u);
			this.setVisible(false);
			ehf.setVisible(true);
		}
		
		
		
		
		
		
		
		
		
				
	}
		

}