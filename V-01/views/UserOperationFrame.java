package views;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import models.*;
import controllers.*;

public class UserOperationFrame extends JFrame implements ActionListener
{
	private JLabel userIdLabel, nameLabel, emailLabel, phoneNoLabel, genderLabel, ageLabel, addressLabel, securityQsLabel, securityAnsLabel, passLabel, userTypeLabel;
	private JTextField userIdTF, nameTF, emailTF, phoneNoTF, genderTF, ageTF, addressTF, securityAnsTF;
	private JPasswordField passPF;
	private JRadioButton maleRB,femaleRB;
	private ButtonGroup bg;
	private JComboBox userTypeCMB;
	private JButton addBtn, removeBtn, updateBtn, resetBtn, searchBtn, backBtn;
	private JTable userTable;
	private JScrollPane userTableSP;
	private JPanel panel;
	private User u;
	
	
	public UserOperationFrame(User u)
	{
		super("User Operation Frame");
		this.setSize(1280, 720);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panel= new JPanel();
		this.panel.setLayout(null);
		
		this.userIdLabel=new JLabel("User Id:");
		this.userIdLabel.setBounds(100,100,60,30);
		this.panel.add(userIdLabel);
		
		this.userIdTF = new JTextField();
		this.userIdTF.setBounds(170, 100, 100, 30);
		this.panel.add(userIdTF);
		
		this.nameLabel=new JLabel("Name:");
		this.nameLabel.setBounds(100,160,60,30);
		this.panel.add(nameLabel);
		
		this.nameTF = new JTextField();
		this.nameTF.setBounds(170, 160, 100, 30);
		this.panel.add(nameTF);
		
		this.emailLabel=new JLabel("Email:");
		this.emailLabel.setBounds(540,100,60,30);
		this.panel.add(emailLabel);
		
		this.emailTF = new JTextField();
		this.emailTF.setBounds(610, 100, 100, 30);
		this.panel.add(emailTF);
		
		this.phoneNoLabel=new JLabel("Phone No:");
		this.phoneNoLabel.setBounds(100,220,60,30);
		this.panel.add(phoneNoLabel);
		
		this.phoneNoTF = new JTextField();
		this.phoneNoTF.setBounds(170, 220, 100, 30);
		this.panel.add(phoneNoTF);
		
		this.genderLabel=new JLabel("Gender:");
		this.genderLabel.setBounds(100,280,60,30);
		this.panel.add(genderLabel);
		
		this.maleRB=new JRadioButton("Male");
		this.maleRB.setBounds(170, 280, 60,30);
		this.panel.add(maleRB);
		
		this.femaleRB= new JRadioButton("Female");
		this.femaleRB.setBounds(240, 280, 80, 30);
		this.panel.add(femaleRB);
		
		this.bg = new ButtonGroup();
		bg.add(maleRB);
		bg.add(femaleRB);
		
		this.ageLabel = new JLabel("Age: ");
		this.ageLabel.setBounds(100, 340, 60, 30);
		this.panel.add(ageLabel);
		
		this.ageTF = new JTextField();
		this.ageTF.setBounds(170, 340, 100, 30);
		this.panel.add(ageTF);
		
		this.addressLabel = new JLabel("Address: ");
		this.addressLabel.setBounds(350, 100, 60, 30);
		this.panel.add(addressLabel);
		
		this.addressTF = new JTextField();
		this.addressTF.setBounds(420, 100, 100, 30);
		this.panel.add(addressTF);
		
		this.securityQsLabel = new JLabel("Security QS: What is your Pet Name? ");
		this.securityQsLabel.setBounds(350, 160, 300, 30);
		this.panel.add(securityQsLabel);
		
		this.securityAnsLabel = new JLabel("Security Ans: ");
		this.securityAnsLabel.setBounds(350, 220, 100, 30);
		this.panel.add(securityAnsLabel);
		
		this.securityAnsTF = new JTextField();
		this.securityAnsTF.setBounds(450, 220, 100, 30);
		this.panel.add(securityAnsTF);
		
		this.passLabel = new JLabel("Password: ");
		this.passLabel.setBounds(350, 280, 100, 30);
		this.panel.add(passLabel);
		
		this.passPF = new JPasswordField();
		this.passPF.setBounds(450, 280, 100, 30);
		this.panel.add(passPF);
		
		this.userTypeLabel = new JLabel("User Type ");
		this.userTypeLabel.setBounds(350, 340, 100, 30);
		this.panel.add(userTypeLabel);
		
		String[] item={"Admin", "Employee", "Customer" };
		this.userTypeCMB= new JComboBox(item);
		this.userTypeCMB.setBounds(450, 340, 200, 30);
		this.panel.add(userTypeCMB);
		
		//addBtn, removeBtn, updateBtn, resetBtn, searchBtn, backBtn;
		
		
		this.addBtn= new JButton("Add User");
		this.addBtn.setBounds(100, 400, 100, 30);
		this.addBtn.addActionListener(this);
		this.panel.add(addBtn);
		
		this.updateBtn = new JButton("Update User");
		this.updateBtn.setBounds(210, 400, 120,30);
		this.updateBtn.addActionListener(this);
		this.panel.add(updateBtn);
		
		this.removeBtn = new JButton("Remove User");
		this.removeBtn.setBounds(340, 400, 120, 30);
		this.removeBtn.addActionListener(this);
		this.panel.add(removeBtn);
		
		this.searchBtn = new JButton("Search User");
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
		
		//Get All Admin
		
		//getting all the admins info in Admin type array
		UserController adc=new UserController();
		User[] userList=adc.getAllUser();
		//converting the Admin type array in 2d String type array to put the values in the table beacuse in table there will be tow dimention. one is row, other one is colomn.
		String userData1[][]=new String[userList.length][4];
		for(int i=0;i<userList.length;i++)
		{
		
			if(userList[i]!=null)
			{
				
				System.out.println(userList[i].toStringUser());
				userData1[i][0]=userList[i].getUserId();
				userData1[i][1]=String.valueOf(userList[i].getRole());
				userData1[i][2]=userList[i].getSecurityAns();
				userData1[i][3]=userList[i].getPassword();
				
				/*
				System.out.println(userList[i].toStringAdmin());
				adminData1[i][0]=userList[i].getUserId();
				adminData1[i][1]=userList[i].getName();
				adminData1[i][2]=userList[i].getGender();
				adminData1[i][3]=String.valueOf(userList[i].getAge());
				adminData1[i][4]=userList[i].getEmail();
				adminData1[i][5]=userList[i].getPhoneNo();
				adminData1[i][6]=userList[i].getAddress();
				adminData1[i][7]=userList[i].getAdminType();
				*/
			}
			
			
			
		}
		//creating Table.
		//head1 is the colomn name;
		String head1[]={"Id","Role", "Security Ans", "PassWord"};
		//putting value and colomn name in the table.
		this.userTable=new JTable(userData1,head1);
		//adding scrolling bar in the table
		this.userTableSP=new JScrollPane(userTable);
		this.userTableSP.setBounds(100,450,700,200);
		this.userTable.setEnabled(false);
		this.panel.add(userTableSP);
		
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
			if(!userIdTF.getText().isEmpty() && !nameTF.getText().isEmpty() &&((maleRB.isSelected()) || (femaleRB.isSelected())) &&  !ageTF.getText().isEmpty() && !emailTF.getText().isEmpty() && !phoneNoTF.getText().isEmpty() && !addressTF.getText().isEmpty() && !securityAnsTF.getText().isEmpty() && !passPF.getText().isEmpty())
			{
				if(userTypeCMB.getSelectedItem().equals("Admin"))
				{
					UserController uc = new UserController();
					AdminController adc=new AdminController();
					User u=uc.searchUser(userIdTF.getText());
					if(u!=null)
					{
						JOptionPane.showMessageDialog(this, "User Id is already used");
					}
					else
					{
						String userId=userIdTF.getText();
						String name=nameTF.getText();
						String gender="";
						if(maleRB.isSelected())
						{
							gender=maleRB.getText();
						}
						else
						{
							gender=femaleRB.getText();
						}
						
						int age=0;
						try
						{
							age=Integer.parseInt(ageTF.getText());
						}
						catch(Exception e)
						{
							e.printStackTrace();
						}
						
						String email = emailTF.getText();
						String phoneNo= phoneNoTF.getText();
						String address= addressTF.getText();
						int role=1;
						String securityAns=securityAnsTF.getText();
						String password= passPF.getText();
						String adminType="Base Admin";
						
						//userId,name,gender,age, email,phoneNo,address,role, securityAns,password, adminType
						Admin a= new Admin(userId, name, gender, age, email, phoneNo, address,role, securityAns, password, adminType);
						uc.insertUser(a);
						adc.insertAdmin(a);
						JOptionPane.showMessageDialog(this, "Admin Added Succesfully");
						
						this.setVisible(false);
						UserOperationFrame uof= new UserOperationFrame(u);
						uof.setVisible(true);
					}
				}
				
				else if(userTypeCMB.getSelectedItem().equals("Employee"))
				{
					UserController uc = new UserController();
					EmployeeController adc=new EmployeeController();
					User u=uc.searchUser(userIdTF.getText());
					if(u!=null)
					{
						JOptionPane.showMessageDialog(this, "User Id is already used");
					}
					else
					{
						String userId=userIdTF.getText();
						String name=nameTF.getText();
						String gender="";
						if(maleRB.isSelected())
						{
							gender=maleRB.getText();
						}
						else
						{
							gender=femaleRB.getText();
						}
						
						int age=0;
						try
						{
							age=Integer.parseInt(ageTF.getText());
						}
						catch(Exception e)
						{
							e.printStackTrace();
						}
						
						String email = emailTF.getText();
						String phoneNo= phoneNoTF.getText();
						String address= addressTF.getText();
						int role=2;
						String securityAns=securityAnsTF.getText();
						String password= passPF.getText();
						String designation="Booking";
						double salary= 30000;
						
						
						//userId,name,gender,age, email,phoneNo,address,role, securityAns,password, adminType
						Employee a= new Employee(userId, name, gender, age, email, phoneNo, address,role, securityAns, password, designation, salary);
										//		userId,name,gender,age,email,phoneNo,address,role,securityAns,password,designation,salary)
						uc.insertUser(a);
						adc.insertEmployee(a);
						JOptionPane.showMessageDialog(this, "Employee Added Succesfully");
						
						this.setVisible(false);
						UserOperationFrame uof= new UserOperationFrame(u);
						uof.setVisible(true);
					}
				}
				
				else
				{
					UserController uc = new UserController();
					CustomerController adc=new CustomerController();
					User u=uc.searchUser(userIdTF.getText());
					if(u!=null)
					{
						JOptionPane.showMessageDialog(this, "User Id is already used");
					}
					else
					{
						String userId=userIdTF.getText();
						String name=nameTF.getText();
						String gender="";
						if(maleRB.isSelected())
						{
							gender=maleRB.getText();
						}
						else
						{
							gender=femaleRB.getText();
						}
						
						int age=0;
						try
						{
							age=Integer.parseInt(ageTF.getText());
						}
						catch(Exception e)
						{
							e.printStackTrace();
						}
						
						String email = emailTF.getText();
						String phoneNo= phoneNoTF.getText();
						String address= addressTF.getText();
						int role=3;
						String securityAns=securityAnsTF.getText();
						String password= passPF.getText();
						int membershipType=0;
						
						
						//userId,name,gender,age, email,phoneNo,address,role, securityAns,password, adminType
						Customer a= new Customer(userId, name, gender, age, email, phoneNo, address,role, securityAns, password, membershipType);
						uc.insertUser(a);
						adc.insertCustomer(a);
						JOptionPane.showMessageDialog(this, "Customer Added Succesfully");
						
						this.setVisible(false);
						UserOperationFrame uof= new UserOperationFrame(u);
						uof.setVisible(true);
					}
				}
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Please Fill Up the form");
			}
		}
		if(command.equals(updateBtn.getText()))
		{
			if(!userIdTF.getText().isEmpty() && !nameTF.getText().isEmpty() &&((maleRB.isSelected()) || (femaleRB.isSelected())) &&  !ageTF.getText().isEmpty() && !emailTF.getText().isEmpty() && !phoneNoTF.getText().isEmpty() && !addressTF.getText().isEmpty() )
			{
				if(userTypeCMB.getSelectedItem().equals("Admin"))
				{
					AdminController adc=new AdminController();
					Admin a=adc.searchAdmin(userIdTF.getText());
					if(a!=null)
					{
						String userId=userIdTF.getText();
						String name=nameTF.getText();
						String gender="";
						if(maleRB.isSelected())
						{
							gender=maleRB.getText();
						}
						else
						{
							gender=femaleRB.getText();
						}
						
						int age=0;
						
						try
						{
							age=Integer.parseInt(ageTF.getText());
						}
						catch(Exception e)
						{
							e.printStackTrace();
						}
						
						String email=emailTF.getText();
						String phoneNo=phoneNoTF.getText();
						String address=addressTF.getText();
						
						
						a.setName(name);
						a.setGender(gender);
						a.setAge(age);
						a.setEmail(email);
						a.setPhoneNo(phoneNo);
						a.setAddress(address);
						
						
						adc.updateAdmin(a);
						
						JOptionPane.showMessageDialog(this, "Updated Succesfully");
						
						this.setVisible(false);
						UserOperationFrame ahf= new UserOperationFrame(u);
						ahf.setVisible(true);
					}
					else
					{
						JOptionPane.showMessageDialog(this,"Admin Not found");
					}
				}
				else if(userTypeCMB.getSelectedItem().equals("Employee"))
				{
					EmployeeController adc=new EmployeeController();
					Employee a=adc.searchEmployee(userIdTF.getText());
					System.out.println(a);
					
					if(a!=null)
					{
						System.out.println("Employee Update Working");
						String userId=userIdTF.getText();
						String name=nameTF.getText();
						String gender="";
						if(maleRB.isSelected())
						{
							gender=maleRB.getText();
						}
						else
						{
							gender=femaleRB.getText();
						}
						
						int age=0;
						
						try
						{
							age=Integer.parseInt(ageTF.getText());
						}
						catch(Exception e)
						{
							e.printStackTrace();
						}
						
						String email=emailTF.getText();
						String phoneNo=phoneNoTF.getText();
						String address=addressTF.getText();
						
						
						a.setName(name);
						a.setGender(gender);
						a.setAge(age);
						a.setEmail(email);
						a.setPhoneNo(phoneNo);
						a.setAddress(address);
						
						
						adc.updateEmployee(a);
						
						JOptionPane.showMessageDialog(this, "Employee Updated Succesfully");
						
						this.setVisible(false);
						UserOperationFrame ahf= new UserOperationFrame(u);
						ahf.setVisible(true);
					}
					else
					{
						JOptionPane.showMessageDialog(this,"Employee Not found");
					}
				}
				else
				{
					CustomerController adc=new CustomerController();
					Customer a=adc.searchCustomer(userIdTF.getText());
					if(a!=null)
					{
						String userId=userIdTF.getText();
						String name=nameTF.getText();
						String gender="";
						if(maleRB.isSelected())
						{
							gender=maleRB.getText();
						}
						else
						{
							gender=femaleRB.getText();
						}
						
						int age=0;
						
						try
						{
							age=Integer.parseInt(ageTF.getText());
						}
						catch(Exception e)
						{
							e.printStackTrace();
						}
						
						String email=emailTF.getText();
						String phoneNo=phoneNoTF.getText();
						String address=addressTF.getText();
						
						
						a.setName(name);
						a.setGender(gender);
						a.setAge(age);
						a.setEmail(email);
						a.setPhoneNo(phoneNo);
						a.setAddress(address);
						
						
						adc.updateCustomer(a);
						
						JOptionPane.showMessageDialog(this, "Customer Updated Succesfully");
						
						this.setVisible(false);
						UserOperationFrame ahf= new UserOperationFrame(u);
						ahf.setVisible(true);
					}
					else
					{
						JOptionPane.showMessageDialog(this,"Customer Not found");
					}
				}
					
				
					
			}
			
			else
			{
				JOptionPane.showMessageDialog(this, "Please Fill up the form correctly.");
			}
		}
		
		if(command.equals(removeBtn.getText()))
		{
			
			if(!userIdTF.getText().isEmpty())
			{
				if(userTypeCMB.getSelectedItem().equals("Employee"))
				{
					String userId= userIdTF.getText();
					UserController uc= new UserController();
					User user=uc.searchUser(userId);
					
					if(user!=null)
					{
						uc.deleteUser(userId);
						EmployeeController adc=new EmployeeController();
						adc.deleteEmployee(userId);
						JOptionPane.showMessageDialog(this, "Employee Deleted Succesfully");
						System.out.println(userId +" Deletation Complete");
						UserOperationFrame aof= new UserOperationFrame(u);
						this.setVisible(false);
						aof.setVisible(true);
					}
					else
					{
						JOptionPane.showMessageDialog(this, "Not Found");
					}
				}
				
				else if(userTypeCMB.getSelectedItem().equals("Admin"))
				{
					String userId= userIdTF.getText();
					UserController uc= new UserController();
					User user=uc.searchUser(userId);
					
					if(user!=null)
					{
						uc.deleteUser(userId);
						AdminController adc=new AdminController();
						adc.deleteAdmin(userId);
						JOptionPane.showMessageDialog(this, "Admin Deleted Succesfully");
						System.out.println(userId +" Deletation Complete");
						UserOperationFrame aof= new UserOperationFrame(u);
						this.setVisible(false);
						aof.setVisible(true);
					}
					else
					{
						JOptionPane.showMessageDialog(this, "Not Found");
					}
				}
				
				else
				{
					String userId= userIdTF.getText();
					UserController uc= new UserController();
					User user=uc.searchUser(userId);
					
					if(user!=null)
					{
						uc.deleteUser(userId);
						CustomerController adc=new CustomerController();
						adc.deleteCustomer(userId);
						JOptionPane.showMessageDialog(this, "Customer Deleted Succesfully");
						System.out.println(userId +" Deletation Complete");
						UserOperationFrame aof= new UserOperationFrame(u);
						this.setVisible(false);
						aof.setVisible(true);
					}
					else
					{
						JOptionPane.showMessageDialog(this, "Not Found");
					}
				}
			}
			else
			{
				JOptionPane.showMessageDialog(this, "User Id Not Found");
			}
			
		}
		
		if(command.equals(searchBtn.getText()))
		{
			if(!userIdTF.getText().isEmpty())
			{
				AdminController adc = new AdminController();
				EmployeeController emc = new EmployeeController();
				CustomerController cuc = new CustomerController();
				UserController uc = new UserController();
				
				String userId=userIdTF.getText();
				User a= uc.searchUser(userId);
				
				
				
				if(a.getRole()==1)
				{
					Admin ad= adc.searchAdmin(userId);
					userIdTF.setEnabled(false);
					nameTF.setText(ad.getName());
					if(ad.getGender().equals("Male"))
					{
						maleRB.setSelected(true);
					}
					else
					{
						femaleRB.setSelected(true);
					}
					
					ageTF.setText(String.valueOf(ad.getAge()));
					emailTF.setText(ad.getEmail());
					phoneNoTF.setText(ad.getPhoneNo());
					addressTF.setText(ad.getAddress());
					userTypeCMB.setSelectedItem("Admin");
					
				}
				else if(a.getRole()==2)
				{
					Employee aee= emc.searchEmployee(userId);
					userIdTF.setEnabled(false);
					nameTF.setText(aee.getName());
					if(aee.getGender().equals("Male"))
					{
						maleRB.setSelected(true);
					}
					else
					{
						femaleRB.setSelected(true);
					}
					
					ageTF.setText(String.valueOf(aee.getAge()));
					emailTF.setText(aee.getEmail());
					phoneNoTF.setText(aee.getPhoneNo());
					addressTF.setText(aee.getAddress());
					userTypeCMB.setSelectedItem("Employee");
					
				}
				else if(a.getRole()==3)
				{
					Customer ac= cuc.searchCustomer(userId);
					userIdTF.setEnabled(false);
					nameTF.setText(ac.getName());
					if(ac.getGender().equals("Male"))
					{
						maleRB.setSelected(true);
					}
					else
					{
						femaleRB.setSelected(true);
					}
					
					ageTF.setText(String.valueOf(ac.getAge()));
					emailTF.setText(ac.getEmail());
					phoneNoTF.setText(ac.getPhoneNo());
					addressTF.setText(ac.getAddress());
					userTypeCMB.setSelectedItem("Customer");
					
				}
				else
				{
					JOptionPane.showMessageDialog(this, "User Not found");
				}
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Please Provide UserId");
			}
		}
		
		if(command.equals(resetBtn.getText()))
		{
			userIdTF.setEnabled(true);
			userIdTF.setText("");
			nameTF.setText("");
			ageTF.setText("");
			emailTF.setText("");
			phoneNoTF.setText("");
			addressTF.setText("");
			passPF.setText("");
			securityAnsTF.setText("");
		}
		
		if(command.equals(backBtn.getText()))
		{
			AdminHomeFrame ahf= new AdminHomeFrame(this.u);
			this.setVisible(false);
			ahf.setVisible(true);
		}
		
		
		
		
		
		
		
		
		
				
	}
	

}