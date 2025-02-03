package models;
import java.lang.*;

public class Employee extends User
{
	private String designation;
	private double salary;
	
	public Employee()
	{
		super();
	}
	public Employee(String userId,String name,String gender,int age,String email,String phoneNo,String address,int role,String securityAns,String password,String designation,double salary)
	//String UserId,String name,String gender,
	//int age,String email,String phoneNo,String address,int role,
	//String securityAns,String password,String designation,double salary
	{
		super(userId,role,securityAns,password);
		this.name=name;
		this.gender=gender;
		this.age=age;
		this.email=email;
		this.phoneNo=phoneNo;
		this.address=address;
		this.designation=designation;
		this.salary=salary;
	}
	
	public void setDesignation(String designation)
	{
		this.designation=designation;
	}
	public String getDesignation()
	{
		return this.designation;
	}
	
	public void setSalary(double salary)
	{
		this.salary=salary;
	}
	public double getSalary()
	{
		return this.salary;
	}
	
	public String toStringEmployee()
	{
		String str = this.userId+","+this.name+","+this.gender+","+this.age+","+this.email+","+this.phoneNo+","+this.address+","+this.designation+","+this.salary+"\n";
		return str;
	}
	
	public Employee formEmployee(String str)
	{
		String data[]=str.split(",");
		
		Employee e = new Employee();
		
		e.setUserId(data[0]);
		e.setName(data[1]);
		e.setGender(data[2]);
		e.setAge(Integer.parseInt(data[3]));
		e.setEmail(data[4]);
		e.setPhoneNo(data[5]);
		e.setAddress(data[6]);
		e.setDesignation(data[7]);
		e.setSalary(Double.parseDouble(data[8]));
		
		return e;
	}
	
	
}