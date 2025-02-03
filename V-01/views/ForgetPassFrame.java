package views;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import models.*;
import controllers.*;


public class ForgetPassFrame extends JFrame implements ActionListener
{
	private JLabel userIdLabel, securityQuesLabel, securityAnsLabel, passLabel;
	private JTextField userTF, securityAnsTF;
	private JPasswordField passPF;
	private JButton submitBtn, exitBtn, backBtn;
	private JPanel panel;
	
	public ForgetPassFrame()
	{
		super("Forget Password Frame");
		this.setSize(1280,728);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panel=new JPanel();
		this.panel.setLayout(null);
		
		this.userIdLabel=new JLabel("User Id:");
		this.userIdLabel.setBounds(100,100,100,20);
		this.panel.add(userIdLabel);
		
		this.userTF=new JTextField();
		this.userTF.setBounds(220,100,100,30);
		this.panel.add(userTF);
		
		this.securityQuesLabel=new JLabel("Security Ques: What is your pet name?:");
		this.securityQuesLabel.setBounds(100,160,300,20);
		this.panel.add(securityQuesLabel);
		
		this.securityAnsLabel=new JLabel("Security Ans:");
		this.securityAnsLabel.setBounds(100,220,100,20);
		this.panel.add(securityAnsLabel);
		
		this.securityAnsTF=new JTextField();
		this.securityAnsTF.setBounds(220,220,100,30);
		this.panel.add(securityAnsTF);
		
		this.passLabel=new JLabel("New Password:");
		this.passLabel.setBounds(100,280,100,20);
		this.panel.add(passLabel);
		
		this.passPF=new JPasswordField();
		this.passPF.setBounds(220,280,100,30);
		this.panel.add(passPF);
		
		this.submitBtn=new JButton("Submit");
		this.submitBtn.setBounds(100,320,100,30);
		this.submitBtn.addActionListener(this);
		this.panel.add(submitBtn);
		
		this.exitBtn=new JButton("Exit");
		this.exitBtn.setBounds(220,320,100,30);
		this.exitBtn.addActionListener(this);
		this.panel.add(exitBtn);
		
		this.backBtn=new JButton("Back");
		this.backBtn.setBounds(340,320,100,30);
		this.backBtn.addActionListener(this);
		this.panel.add(backBtn);
		
		
		this.add(panel);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String command= ae.getActionCommand();
		
		if(command.equals(submitBtn.getText()))
		{
			if(!userTF.getText().isEmpty() && !securityAnsTF.getText().isEmpty() && !passPF.getText().isEmpty())
			{
				String userTFValue=userTF.getText();
				String passPFValue=passPF.getText();
				String securityAnsTFValue=securityAnsTF.getText();
				UserController uc=new UserController();
				User u=uc.searchUser(userTFValue);
				if(u!=null)
				{
					if(u.getSecurityAns().equals(securityAnsTFValue))
					{
						u.setPassword(passPFValue);
						uc.updateUser(u);
						JOptionPane.showMessageDialog(this,"Password Updated Successfully");
						LoginFrame lf=new LoginFrame();
						this.setVisible(false);
						lf.setVisible(true);
					}
					
					else
					{
						JOptionPane.showMessageDialog(this,"Wrong Security ans");
					}
				}
				
				else
				{
					JOptionPane.showMessageDialog(this,"Wrong userId");
				}
			}
		}
		
		if(command.equals(backBtn.getText()))
		{
			LoginFrame lf=new LoginFrame();
			this.setVisible(false);
			lf.setVisible(true);
		}
		
		
		if(command.equals(exitBtn.getText()))
		{
			System.exit(0);
		}
	}
	
}
