package views;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import models.*;
import controllers.*;

public class LoginFrame extends JFrame implements ActionListener
{
	private JLabel userIdLabel, passLabel;
	private JTextField userTF;
	private JPasswordField passPF;
	private JButton loginBtn, exitBtn, signUpBtn, forgetPassBtn;
	private JPanel panel;
	
	public LoginFrame()
	{
		super("Login Frame");
		this.setSize(1280, 728);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panel=new JPanel();
		this.panel.setLayout(null);
		
		this.userIdLabel= new JLabel("User Id: ");
		this.userIdLabel.setBounds(450, 150, 140, 40);
		this.panel.add(userIdLabel);
		
		this.userTF= new JTextField();
		this.userTF.setBounds(550, 150, 140, 40);
		this.panel.add(userTF);
		
		
		this.passLabel= new JLabel("Password: ");
		this.passLabel.setBounds(450, 200, 140, 40);
		this.panel.add(passLabel);
		
		this.passPF= new JPasswordField();
		this.passPF.setBounds(550, 200, 140, 40);
		this.panel.add(passPF);
		
		this.loginBtn=new JButton("Login");
		this.loginBtn.setBounds(470, 270, 100,40);
		this.loginBtn.addActionListener(this);
		this.panel.add(loginBtn);
		
		this.signUpBtn= new JButton("Sign Up");
		this.signUpBtn.setBounds(590, 270, 100, 40);
		this.signUpBtn.addActionListener(this);
		this.panel.add(signUpBtn);
		
		this.exitBtn=new JButton("Exit");
		this.exitBtn.setBounds(520, 320, 150, 40);
		this.exitBtn.addActionListener(this);
		this.panel.add(exitBtn);
		
		
		this.forgetPassBtn= new JButton("Forget Password");
		this.forgetPassBtn.setBounds(520, 370, 150, 40);
		this.forgetPassBtn.addActionListener(this);
		this.panel.add(forgetPassBtn);
		
		
		
		this.add(panel);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String command= ae.getActionCommand();
		
		if(command.equals(loginBtn.getText()))
		{
			if(!userTF.getText().isEmpty() && !passPF.getText().isEmpty())
			{
				String userTFValue = userTF.getText();
				String passPFValue = passPF.getText();
				
				UserController uc=new UserController();
				User u=uc.searchUser(userTFValue);
				
				if(u!=null)
				{
					if(u.getPassword().equals(passPFValue))
					{
						if(u.getRole()==1)
						{
							AdminHomeFrame ahf= new AdminHomeFrame(u);
							this.setVisible(false);
							ahf.setVisible(true);
							
						}
						else if(u.getRole()==2)
						{
							//JOptionPane.showMessageDialog(this, "Welcome Employee");
							EmployeeHomeFrame ehf= new EmployeeHomeFrame(u);
							this.setVisible(false);
							ehf.setVisible(true);
						}
						else
						{
							CustomerHomeFrame chf = new CustomerHomeFrame(u);
							this.setVisible(false);
							chf.setVisible(true);
							//JOptionPane.showMessageDialog(this, "Welcome" );
						}
					}
					else
					{
						JOptionPane.showMessageDialog(this, "Wrong Password");
					}
				}
				else
				{
					JOptionPane.showMessageDialog(this, "Wrong User Id");
				}
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Please Fill up All the Field");
			}
		}
		
		if(command.equals(signUpBtn.getText()))
		{
			
			SignUpFrame suf= new SignUpFrame();
			this.setVisible(false);
			suf.setVisible(true);
			
		}
		
		if(command.equals(forgetPassBtn.getText()))
		{
			
			ForgetPassFrame fpf=new ForgetPassFrame();
			this.setVisible(false);
			fpf.setVisible(true);
			
			
		}
		
		if(command.equals(exitBtn.getText()))
		{
			System.exit(0);
		}
	}
}









