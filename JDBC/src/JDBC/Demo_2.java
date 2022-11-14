package JDBC;

//java database connectivity 
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
public class Demo_2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		String url="jdbc:mysql://localhost:3306/company";
		String uname="root";
		String password="shaziya@oct2002";
		String query="select * from EMPLOY_DETAILS;";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,uname,password);
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);//DQL
		
		while(rs.next()) {
		String userData=rs.getInt(1)+"  :  "+rs.getString(2)+"    :    "+rs.getInt(3);
		System.out.println(userData);
		}
		st.close();
		con.close();
		
	}

}
