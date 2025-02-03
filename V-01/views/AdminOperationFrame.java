package views;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import models.*;
import controllers.*;

public class AdminOperationFrame extends JFrame implements ActionListener
{
	private JLabel userIdLabel, nameLabel, emailLabel, phoneNoLabel, genderLabel, ageLabel, addressLabel, securityQsLabel, securityAnsLabel, passLabel, adminTypeLabel;
	private JTextField userIdTF, nameTF, emailTF, phoneNoTF, genderTF, ageTF, addressTF, securityAnsTF;
	private JPasswordField passPF;
	private JRadioButton maleRB,femaleRB;
	private ButtonGroup bg;
	private JComboBox adminTypeCMB;
	private JButton addBtn, removeBtn, updateBtn, resetBtn, searchBtn, backBtn;
	private JTable adminTable;
	private JScrollPane adminTableSP;
	private JPanel panel;
	private User u;
	
	
	public AdminOperationFrame(User u)
	{
		super("Admin Operation Frame");
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
		
		this.adminTypeLabel = new JLabel("Admin Type ");
		this.adminTypeLabel.setBounds(350, 340, 100, 30);
		this.panel.add(adminTypeLabel);
		
		String[] item={"Base Admin", "Customer Admin" };
		this.adminTypeCMB= new JComboBox(item);
		this.adminTypeCMB.setBounds(450, 340, 200, 30);
		this.panel.add(adminTypeCMB);
		
		//addBtn, removeBtn, updateBtn, resetBtn, searchBtn, backBtn;
		
		
		this.addBtn= new JButton("Add Admin");
		this.addBtn.setBounds(100, 400, 100, 30);
		this.addBtn.addActionListener(this);
		this.panel.add(addBtn);
		
		this.updateBtn = new JButton("Update Admin");
		this.updateBtn.setBounds(210, 400, 120,30);
		this.updateBtn.addActionListener(this);
		this.panel.add(updateBtn);
		
		this.removeBtn = new JButton("Remove Admin");
		this.removeBtn.setBounds(340, 400, 120, 30);
		this.removeBtn.addActionListener(this);
		this.panel.add(removeBtn);
		
		this.searchBtn = new JButton("Search Admin");
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
		AdminController adc=new AdminController();
		Admin[] adminList=adc.getAllAdmin();
		//converting the Admin type array in 2d String type array to put the values in the table beacuse in table there will be tow dimention. one is row, other one is colomn.
		String adminData1[][]=new String[adminList.length][8];
		for(int i=0;i<adminList.length;i++)
		{
		
			if(adminList[i]!=null)
			{
				System.out.println(adminList[i].toStringAdmin());
				adminData1[i][0]=adminList[i].getUserId();
				adminData1[i][1]=adminList[i].getName();
				adminData1[i][2]=adminList[i].getGender();
				adminData1[i][3]=String.valueOf(adminList[i].getAge());
				adminData1[i][4]=adminList[i].getEmail();
				adminData1[i][5]=adminList[i].getPhoneNo();
				adminData1[i][6]=adminList[i].getAddress();
				adminData1[i][7]=adminList[i].getAdminType();
			}
			
			
			
		}
		//creating Table.
		//head1 is the colomn name;
		String head1[]={"Id","Name","Gender","Age","Email","Phone No","Adress","AdminType"};
		//putting value and colomn name in the table.
		this.adminTable=new JTable(adminData1,head1);
		//adding scrolling bar in the table
		this.adminTableSP=new JScrollPane(adminTable);
		this.adminTableSP.setBounds(100,450,700,200);
		this.adminTable.setEnabled(false);
		this.panel.add(adminTableSP);
		
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
					String adminType=adminTypeCMB.getSelectedItem().toString();
					
					//userId,name,gender,age, email,phoneNo,address,role, securityAns,password, adminType
					Admin a= new Admin(userId, name, gender, age, email, phoneNo, address,role, securityAns, password, adminType);
					uc.insertUser(a);
					adc.insertAdmin(a);
					JOptionPane.showMessageDialog(this, "Admin Added Succesfully");
					
					this.setVisible(false);
					AdminOperationFrame ahf= new AdminOperationFrame(u);
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
			if(!userIdTF.getText().isEmpty() && !nameTF.getText().isEmpty() &&((maleRB.isSelected()) || (femaleRB.isSelected())) &&  !ageTF.getText().isEmpty() && !emailTF.getText().isEmpty() && !phoneNoTF.getText().isEmpty() && !addressTF.getText().isEmpty() )
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
					String adminType=adminTypeCMB.getSelectedItem().toString();
					
					a.setName(name);
					a.setGender(gender);
					a.setAge(age);
					a.setEmail(email);
					a.setPhoneNo(phoneNo);
					a.setAddress(address);
					a.setAdminType(adminType);
					
					adc.updateAdmin(a);
					
					JOptionPane.showMessageDialog(this, "Updated Succesfully");
					
					this.setVisible(false);
					AdminOperationFrame ahf= new AdminOperationFrame(u);
					ahf.setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Admin Not found");
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
				String userId= userIdTF.getText();
				UserController uc= new UserController();
				User user=uc.searchUser(userId);
				
				if(user!=null)
				{
					uc.deleteUser(userId);
					AdminController adc=new AdminController();
					adc.deleteAdmin(userId);
					JOptionPane.showMessageDialog(this, "User Deleted Succesfully");
					System.out.println(userId +" Deletation Complete");
					AdminOperationFrame aof= new AdminOperationFrame(u);
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
				JOptionPane.showMessageDialog(this, "User Id Not Found");
			}
			
		}
		
		if(command.equals(searchBtn.getText()))
		{
			if(!userIdTF.getText().isEmpty())
			{
				AdminController adc = new AdminController();
				String userId=userIdTF.getText();
				Admin a= adc.searchAdmin(userId);
				
				if(a!=null)
				{
					userIdTF.setEnabled(false);
					nameTF.setText(a.getName());
					if(a.getGender().equals("Male"))
					{
						maleRB.setSelected(true);
					}
					else
					{
						femaleRB.setSelected(true);
					}
					
					ageTF.setText(String.valueOf(a.getAge()));
					emailTF.setText(a.getEmail());
					phoneNoTF.setText(a.getPhoneNo());
					addressTF.setText(a.getAddress());
					adminTypeCMB.setSelectedItem(a.getAdminType());
					
				}
				else
				{
					JOptionPane.showMessageDialog(this, "Admin Not found");
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