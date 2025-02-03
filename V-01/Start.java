import java.lang.*;
//import controllers.*;
//import models.*;
import views.*;


public class Start
{
	public static void main(String[] args)
	{
		/*	
		User u = new User("admin", 1, "admin","admin");
		AdminOperationFrame aof = new AdminOperationFrame(u);
		aof.setVisible(true);
		*/
		
		//Test Login Frame
		LoginFrame lf= new LoginFrame();
		lf.setVisible(true);
		
		
		
		/*Test Admin Home Frame
		User u = new User("admin", 1, "admin","admin");
		
		AdminHomeFrame ahf= new AdminHomeFrame(u);
		ahf.setVisible(true);
		*/
		
		
		/* Working Do not Touch..!
		UserController uc= new UserController();
		
		User u = new User("J-01", 0, "Jubayer", "Ahamed");
		User u1 = new User("J-02", 0, "Ahamed", "Jubayer");	//This
		User u2 = new User("admin", 1, "admin", "admin");
		User u3 = new User("emp", 2, "employee", "employee");
		
		uc.insertUser(u);
		uc.insertUser(u1);
		uc.insertUser(u2);
		uc.insertUser(u3);
		*/
		
		
		/*
		
		//User k= new User("103",2,"Dog","1235");
		
		//uc.insertUser(k);
		
		/*User us=uc.searchUser("103");
		System.out.println(us.toStringUser());
		uc.deleteUser("101");
		User users[]=uc.getAllUser();
		for(int i=0;i<users.length;i++)
		{
			if(users[i]!=null)
			{
				System.out.println(users[i].toStringUser());
			}
		}
		
		*/
		
		//Customer(String userId,String name,String gender,int age, String email,String phoneNo,String address,int role, String securityAns,String password)
		/*Customer c = new Customer("test","Test","Male",12,"test@gmail.com","01793504010","Basundhara",2,"test","test");
		Customer d = new Customer("test1","Test1","Male",13,"test1@gmail.com","01793504010","Basundhara",1,"test","test");
		CustomerController cc = new CustomerController();
		cc.insertCustomer(c);
		cc.insertCustomer(d);
		*/
		
		
		//Working do not Touch...!
		
		//Admin(String userId,String name,String gender,int age, String email,String phoneNo,String address,int role, String securityAns,String password, String adminType)
		/* Admin a = new Admin("admin","admin","male",15, "admin@gmail.com","01793504010","Basundhara R/A",1,"admin","admin","admin");
		Admin a1 = new Admin("admin1","admin1","male",15, "admin1@gmail.com","01793504010","Basundhara R/A",1,"admin1","admin1","admin1");
		AdminController ac= new AdminController();
		ac.insertAdmin(a);
		ac.insertAdmin(a1);
		*/
		
		
		/* Working Do not Touch..!
		
		//Flight(String flightId, String flightName, String source, String destination, String departureDate, String)
		
		Flight f = new Flight("flight","USA","BD-AirLines", "Bangladesh","23-01-2025","23-01-2026","10:30 PM","12:30 PM",9000,"40");
		Flight fa = new Flight("flight1","USA","BD-AirLines", "Bangladesh","23-01-2025","23-01-2026","10:30 PM","12:30 PM",9000,"40");
		FlightController fc=new FlightController();
		fc.insertFlight(f);
		fc.insertFlight(fa);
		System.out.println("Flight Done");
		*/
		
		
		/* Working Do not Touch..!
		
		//Problem Here..
		//Solved.
		//Employee(String userId, String name, String gender, int age, String email, String phoneNo, String address, int role, String securityAns, String password, String designation, double salary)
		Employee a = new Employee("E-01", "Jubayer", "Male", 22, "emp@gmail.com", "017xxxxxxxxx", "Basundhara R/A", 2, "employee", "employee", "employee", 25000);
		Employee aa = new Employee("E-02", "Ahamed", "Male", 22, "emp@gmail.com", "017xxxxxxxxx", "Basundhara R/A", 2, "employee", "employee", "employee", 25000);
		EmployeeController ec= new EmployeeController();
		ec.insertEmployee(a);
		ec.insertEmployee(aa);
		*/
		
		/* Working
		//Payment(String userId, String paymentId, String reservationId, int amount, String paymentDate, String paymentMethod)
		Payment p = new Payment("J-01","p-01","r-01",10000,"23-2-2024","Cash On Delivery");
		Payment p1 = new Payment("J-01","p-02","r-02",10000,"23-2-2024","Cash On Delivery");
		PaymentController pc = new PaymentController();
		pc.insertPayment(p);
		pc.insertPayment(p1);
		
		*/
		
		
		/* Working 
		//Reservation(String reservationId, String flightId, String userId, String bookingDate, String seatNumber, Boolean status)
		Reservation r = new Reservation("r-01","flight","J-01","23-2-2024","23",true);
		Reservation r1 = new Reservation("r-02","flight1","J-01","23-2-2024","23",true);
		ReservationController rc = new ReservationController();
		rc.insertReservation(r);
		rc.insertReservation(r1);
		*/
		
		
	}
}
