package models;
import java.lang.*;

public class Admin extends User
{
	private String adminType;
	
	public Admin()
	{
		super();
	}
	
	//String userId,String name,String gender,int age, String email,String phoneNo,String address,int role, String securityAns,String password
	
	public Admin(String userId,String name,String gender,int age, String email,String phoneNo,String address,int role, String securityAns,String password, String adminType)
	{
		super(userId, role, securityAns, password);
		this.name=name;
		this.gender=gender;
		this.age=age;
		this.email=email;
		this.phoneNo=phoneNo;
		this.address=address;
		this.adminType=adminType;
	}
	
	public void setAdminType(String adminType)
	{
		this.adminType=adminType;
	}
	
	public String getAdminType()
	{
		return this.adminType;
	}
	
	public String toStringAdmin()
	{
		String str=this.userId+","+this.name+","+this.gender+","+this.age+","+this.email+","+this.phoneNo+","+this.address+","+this.adminType+"\n";
		return str;
	}
	
	public Admin formAdmin(String str)
	{
		String data[]=str.split(",");
		Admin a=new Admin();
		
		a.setUserId(data[0]);
		a.setName(data[1]);
		a.setGender(data[2]);
		a.setAge(Integer.parseInt(data[3]));
		a.setEmail(data[4]);
		a.setPhoneNo(data[5]);
		a.setAddress(data[6]);
		a.setAdminType(data[7]);
		
		return a;
	}
}	