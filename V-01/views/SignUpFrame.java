package views;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import models.*;
import controllers.*;

public class SignUpFrame extends JFrame implements ActionListener
{
	private JLabel userIdLabel,nameLabel, emailLabel, phoneNoLabel, genderLabel, ageLabel, addressLabel, securityQuesLabel, securityAnsLabel, passLabel, membershipLabel;
	private JTextField userTF, nameTF, emailTF, phoneNoTF, ageTF, addressTF, securityAnsTF, membershipTF;
	private JPasswordField passPF;
	private JRadioButton maleRB, femaleRB;
	private ButtonGroup bg;
	private JButton addBtn, backBtn;
	
	private JPanel panel;
	
	
	
	
	public SignUpFrame()
	{
		super("Client Registration Frame");
		this.setSize(1280,760);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panel=new JPanel();
		this.panel.setLayout(null);
		
		this.userIdLabel=new JLabel("User Id:");
		this.userIdLabel.setBounds(100,100,60,30);
		this.panel.add(userIdLabel);
		
		this.userTF=new JTextField();
		this.userTF.setBounds(180,100,100,30);
		this.panel.add(userTF);
		
		this.nameLabel=new JLabel("Name:");
		this.nameLabel.setBounds(100,160,60,30);
		this.panel.add(nameLabel);
		
		this.nameTF=new JTextField();
		this.nameTF.setBounds(180,160,100,30);
		this.panel.add(nameTF);
		
		this.emailLabel=new JLabel("Email:");
		this.emailLabel.setBounds(100,220,60,30);
		this.panel.add(emailLabel);
		
		this.emailTF=new JTextField();
		this.emailTF.setBounds(180,220,100,30);
		this.panel.add(emailTF);
		
		this.phoneNoLabel=new JLabel("phone No:");
		this.phoneNoLabel.setBounds(100,280,60,30);
		this.panel.add(phoneNoLabel);
		
		this.phoneNoTF=new JTextField();
		this.phoneNoTF.setBounds(180,280,100,30);
		this.panel.add(phoneNoTF);
		
		this.genderLabel=new JLabel("Gender:");
		this.genderLabel.setBounds(100,340,60,30);
		this.panel.add(genderLabel);
		
		this.maleRB=new JRadioButton("Male");
		this.maleRB.setBounds(180,340,60,30);
		this.panel.add(maleRB);
		
		this.femaleRB=new JRadioButton("Female");
		this.femaleRB.setBounds(250,340,80,30);
		this.panel.add(femaleRB);
		
		this.bg=new ButtonGroup();
		bg.add(maleRB);
		bg.add(femaleRB);
		
		this.ageLabel=new JLabel("Age:");
		this.ageLabel.setBounds(100,400,60,30);
		this.panel.add(ageLabel);
		
		this.ageTF=new JTextField();
		this.ageTF.setBounds(180,400,100,30);
		this.panel.add(ageTF);
		
		this.addressLabel=new JLabel("Address:");
		this.addressLabel.setBounds(400,100,60,30);
		this.panel.add(addressLabel);
		
		this.addressTF=new JTextField();
		this.addressTF.setBounds(500,100,100,30);
		this.panel.add(addressTF);
		
		this.securityQuesLabel=new JLabel("Security Ques: What is your pet name?:");
		this.securityQuesLabel.setBounds(400,160,300,30);
		this.panel.add(securityQuesLabel);
		
		this.securityAnsLabel=new JLabel("Security Ans:");
		this.securityAnsLabel.setBounds(400,220,100,30);
		this.panel.add(securityAnsLabel);
		
		this.securityAnsTF=new JTextField();
		this.securityAnsTF.setBounds(510,220,100,30);
		this.panel.add(securityAnsTF);
		
		this.passLabel=new JLabel("Password:");
		this.passLabel.setBounds(400,280,100,30);
		this.panel.add(passLabel);
		
		this.passPF=new JPasswordField();
		this.passPF.setBounds(510,280,100,30);
		this.panel.add(passPF);
		
		this.membershipLabel=new JLabel("Membership: Default [Bronze]");
		this.membershipLabel.setBounds(400,340,200,30);
		this.panel.add(membershipLabel);
		
		this.membershipTF=new JTextField();
		this.membershipTF.setBounds(510,340,100,30);
		//this.panel.add(membershipTF);
		
		
		this.addBtn=new JButton("Submit");
		this.addBtn.setBounds(100,450,100,30);
		this.addBtn.addActionListener(this);
		this.panel.add(addBtn);
		
		
		this.backBtn=new JButton("back");
		this.backBtn.setBounds(200,450,100,30);
		this.backBtn.addActionListener(this);
		this.panel.add(backBtn);
		
		
		this.add(panel);

		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String command=ae.getActionCommand();
		
		if(command.equals(addBtn.getText()))
		{
			if(!userTF.getText().isEmpty() && !nameTF.getText().isEmpty() && !emailTF.getText().isEmpty() && !phoneNoTF.getText().isEmpty() && !addressTF.getText().isEmpty() && !ageTF.getText().isEmpty() && !passPF.getText().isEmpty() && !securityAnsTF.getText().isEmpty() && ((maleRB.isSelected()) || (femaleRB.isSelected())))
			{
				String userTFValue=userTF.getText();
				String nameValue=nameTF.getText();
				String genderValue="";
				if(maleRB.isSelected())
				{
					genderValue="male";
				}
				else
				{
					genderValue="female";
				}
				int ageValue=0;
				try
				{
					String inputAge=ageTF.getText();
					ageValue=Integer.parseInt(inputAge);
				}
				catch(Exception e)
				{
					e.printStackTrace();
					JOptionPane.showMessageDialog(this,"Age value should be int.");
				}
				
				String emailValue=emailTF.getText();
				String phoneNoValue=phoneNoTF.getText();
				String addressValue=addressTF.getText();
				int role=3;
				String securityAnsValue=securityAnsTF.getText();
				String passwordValue=passPF.getText();
				int membershipType=1;
				
				
				Customer c=new Customer(userTFValue,nameValue,genderValue,ageValue,emailValue,phoneNoValue,addressValue,role,securityAnsValue,passwordValue,membershipType);
				
				UserController uc=new UserController();
				uc.insertUser(c);
				
				CustomerController cc=new CustomerController();
				cc.insertCustomer(c);
				
				JOptionPane.showMessageDialog(this, "Registration Success full");
				
				LoginFrame lf=new LoginFrame();
				this.setVisible(false);
				lf.setVisible(true);
			}
			
			else
			{
				JOptionPane.showMessageDialog(this,"Please fill up all the field properly");
			}
		}
		
		
		
		if(command.equals(backBtn.getText()))
		{
			LoginFrame lf=new LoginFrame();
			this.setVisible(false);
			lf.setVisible(true);
		}
	}
	
}