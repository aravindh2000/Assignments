import java.sql.*;
public class Employee {

	Connection con;
	PreparedStatement ps;
	Statement st;
	ResultSet res;
	
	Employee()
	{
		con=null;
	}
	
	public Connection getConnection()
	{
		try{
		Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/students","root","va34w5");
		}
		catch(Exception e){
			System.out.println(e);
		}
		return con;
	}
	
	public void insertEmployee(String name, String city, String contact) throws SQLException 
	{
		System.out.println("**************** Insert new Employees*****************");
		
		
		Connection c=new Employee().getConnection();
		PreparedStatement p=c.prepareStatement("insert into datatable values(?,?,?)",Statement.RETURN_GENERATED_KEYS);
		 p.setString(1,name);
		 p.setString(2 ,city);
		 p.setString(3, contact);
		 p.executeUpdate();
		}
	
	public void getEmployee() 
	{
	 System.out.println("**************** Display Employees*****************");
	 try {
		 con=getConnection();
		 st=con.createStatement();
		 res=st.executeQuery("select * from datatable");
		 System.out.println("Id\t Name\t Email\t DOJ");
		 System.out.println("-----------------------------------");
		 
		 while(res.next())
		 {
			 System.out.print(res.getString(1)+"\t");
			 System.out.print(res.getString(2)+"\t");
			 System.out.print(res.getString(3));
			
		 }
		 System.out.println("-----------------------------------");
		 res.close(); con.close();
	 }
	 catch(Exception e)
	 {
		 System.out.println(e);
	 }
	 
	}
	
	public void updateEmployee(String name,String city) throws SQLException 
	{
	         	String qs="update table datatable set city=? where name="+"'name'";
	         	Connection c=new Employee().getConnection();
	         	PreparedStatement ps=c.prepareStatement(qs,Statement.RETURN_GENERATED_KEYS);
	         	ps.setString(1, city);
	         	ps.executeUpdate();
	         	c.close();
	}
	
	public void deleteEmployee(int cid) throws SQLException 
	{
		System.out.println("**************** Delete Employees*****************");
		Connection c=new Employee().getConnection();
		PreparedStatement ps=c.prepareStatement("delete from datatable where cid=?",Statement.RETURN_GENERATED_KEYS);
     	ps.setInt(1, cid);
     	ps.executeUpdate();
     	c.close();
	}
}
