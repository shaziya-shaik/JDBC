package JDBC;

//java database connectivity theory by telusko
/* 
 * 1.import --->java.sql
 * 2.load and register the driver--> com.mysql.jdbc.Driver
 * 3.Create connection-->Connection
 * 4.create a statement-->statement
 * 5.execute the query
 * 6.process the results
 * 7.close
 * 
 * */
import java.sql.*;
public class Demo_1 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		String url="jdbc:mysql://localhost:3306/company";
		String uname="root";
		String password="shaziya@oct2002";
		String query="select E_NAME from employ_details where E_ADDRESS='Hyderabad';";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,uname,password);
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);
		rs.next();
		
		String name=rs.getString("E_NAME");
		System.out.println(name);
		st.close();
		con.close();
		
	}

}
