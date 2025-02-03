package views;

import javax.swing.*;
import java.awt.event.*;
import controllers.*;
import models.*;

public class CustomerProfileFrame extends JFrame implements ActionListener {
    private JLabel userIdLabel, nameLabel, genderLabel, ageLabel, emailLabel, phoneLabel, addressLabel, roleLabel, membershipLabel;
    private JTextField userIdTF, nameTF, genderTF, ageTF, emailTF, phoneTF, addressTF, roleTF, membershipTF;
	
    private JButton backButton;
    private Customer customer;
	private User u;
	private JPanel panel;

    public CustomerProfileFrame(User u) 
	{
        super("Customer Profile");
        this.setSize(1280, 720);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.panel=new JPanel();
		this.panel.setLayout(null);
		

		CustomerController adc=new CustomerController();
		this.customer=adc.searchCustomer(u.getUserId());
		
		
        userIdLabel = new JLabel("User ID:");
        userIdLabel.setBounds(50, 50, 100, 30);
        this.panel.add(userIdLabel);

        userIdTF = new JTextField(customer.getUserId());
        userIdTF.setBounds(200, 50, 200, 30);
        userIdTF.setEditable(false);
        this.panel.add(userIdTF);

        nameLabel = new JLabel("Name:");
        nameLabel.setBounds(50, 90, 100, 30);
        this.panel.add(nameLabel);

        nameTF = new JTextField(customer.getName());
        nameTF.setBounds(200, 90, 200, 30);
        nameTF.setEditable(false);
        this.panel.add(nameTF);

        genderLabel = new JLabel("Gender:");
        genderLabel.setBounds(50, 130, 100, 30);
        this.panel.add(genderLabel);

        genderTF = new JTextField(customer.getGender());
        genderTF.setBounds(200, 130, 200, 30);
        genderTF.setEditable(false);
        this.panel.add(genderTF);

        ageLabel = new JLabel("Age:");
        ageLabel.setBounds(50, 170, 100, 30);
        this.panel.add(ageLabel);

        ageTF = new JTextField(String.valueOf(customer.getAge()));
        ageTF.setBounds(200, 170, 200, 30);
        ageTF.setEditable(false);
        this.panel.add(ageTF);

        emailLabel = new JLabel("Email:");
        emailLabel.setBounds(50, 210, 100, 30);
        this.panel.add(emailLabel);

        emailTF = new JTextField(customer.getEmail());
        emailTF.setBounds(200, 210, 200, 30);
        emailTF.setEditable(false);
        this.panel.add(emailTF);

        phoneLabel = new JLabel("Phone No:");
        phoneLabel.setBounds(50, 250, 100, 30);
        this.panel.add(phoneLabel);

        phoneTF = new JTextField(customer.getPhoneNo());
        phoneTF.setBounds(200, 250, 200, 30);
        phoneTF.setEditable(false);
        this.panel.add(phoneTF);

        addressLabel = new JLabel("Address:");
        addressLabel.setBounds(50, 290, 100, 30);
        this.panel.add(addressLabel);

        addressTF = new JTextField(customer.getAddress());
        addressTF.setBounds(200, 290, 200, 30);
        addressTF.setEditable(false);
        this.panel.add(addressTF);

        roleLabel = new JLabel("Role:");
        roleLabel.setBounds(50, 330, 100, 30);
        this.panel.add(roleLabel);

        roleTF = new JTextField(String.valueOf(customer.getRole()));
        roleTF.setBounds(200, 330, 200, 30);
        roleTF.setEditable(false);
        this.panel.add(roleTF);

        membershipLabel = new JLabel("Membership Type:");
        membershipLabel.setBounds(50, 370, 130, 30);
        this.panel.add(membershipLabel);

        membershipTF = new JTextField(String.valueOf(customer.getMembershipType()));
        membershipTF.setBounds(200, 370, 200, 30);
        membershipTF.setEditable(false);
        this.panel.add(membershipTF);

        backButton = new JButton("Back");
        backButton.setBounds(200, 420, 100, 30);
        backButton.addActionListener(this);
        this.panel.add(backButton);
		
		this.add(panel);
		this.u=u;
		
    }

    public void actionPerformed(ActionEvent ae) 
	{
		String command=ae.getActionCommand();
        if (command.equals(backButton.getText())) 
		{
            CustomerHomeFrame chf = new CustomerHomeFrame(u);
            this.setVisible(false);
            chf.setVisible(true);
        }
    }
}
