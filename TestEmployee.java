import java.sql.SQLException;
import java.util.Scanner;

public class TestEmployee{

	public static void main(String[] args) throws SQLException {
		Employee e=new Employee();
		String city = null;
		int cid;
		
		System.out.println("************** Global Tech Solutions **************");
		System.out.println("----------- Employee Management System ----------");
		while(true)
		{
		System.out.println("Press 1 for New Employee \t Press 2 to Display Employees");
		System.out.println("Press 3 for Update Employee \t Press 4 to Delete Employee");
		System.out.println("Press 5 for Exit"); 
			
		Scanner s=new Scanner(System.in);
		int option=s.nextInt();
		
		switch(option)
		{
		case 1: System.out.println("Enter Customer Name, City & Contact no :");
		        String name=s.next();
		        city=s.next();
		        String contactno=s.next();
		        e.insertEmployee(name,city,contactno);
			break;
		case 2: e.getEmployee();
				break;
		case 3: System.out.println("Enter Employee name whose city has to be updated");
        		
        		e.updateEmployee(s.nextLine(),city);
				break;
		case 4: System.out.println("Enter Employee Id  to be Deleted:");
				cid=s.nextInt();
				e.deleteEmployee(cid);
			break;
		case 5: System.out.println("Program Terminated");
		 		System.exit(0);
		
		default: System.out.println("Invalid Selection");
		          break;
		}
		
		
		}

	}

}
