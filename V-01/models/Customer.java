package models;

import java.lang.*;

public class Customer extends User
{
	
	private int membershipType;
	
	public Customer()
	{
		super();
	}
	
	public Customer(String userId,String name,String gender,int age,String email,String phoneNo,String address,int role,String securityAns,String password, int membershipType)
	{
		
		super(userId,role,securityAns,password);
		this.name=name;
		this.gender=gender;
		this.age=age;
		this.email=email;
		this.phoneNo=phoneNo;
		this.address=address;
		this.membershipType=membershipType;
	}
	
	public void setMembershipType(int membershipType)
	{
		this.membershipType=membershipType;
	}
	
	public int getMembershipType()
	{
		return this.membershipType;
	}
	
	public String toStringCustomer()
	{
		//userId,name,gender,age,					email,phoneNo,address,role,			//securityAns,password,membershipType
		
		String str= this.userId+","+this.name+","+this.gender+","+this.age+","+this.email+","+this.phoneNo+","+this.address+","+this.membershipType+"\n";
		return str;
		
	}
	
	public Customer formCustomer(String str)
	{
		String data[]=str.split(",");
		
		Customer cus= new Customer();
		
		cus.setUserId(data[0]);
		cus.setName(data[1]);
		cus.setGender(data[2]);
		cus.setAge(Integer.parseInt(data[3]));
		cus.setEmail(data[4]);
		cus.setPhoneNo(data[5]);
		cus.setAddress(data[6]);
		cus.setMembershipType(Integer.parseInt(data[7]));
		
		return cus;
		
	}
	
	
	
	
}