package JDBC;
import java.sql.*;
public class Demo_3 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		String url="jdbc:mysql://localhost:3306/company";
		String username="root";
		String password="shaziya@oct2002";
		int user_id=143;
		String name="saranya";
		int salary=630000;
		String ph="+91 9058943084";
		String address="tenali";
		int bonus=8900;
		String querry="insert into EMPLOY_DETAILS values(?,?,?,?,?,?)";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,username,password);
		PreparedStatement st=con.prepareStatement(querry);
		
		st.setInt(1,user_id);
		st.setString(2,name);
		st.setInt(3,salary);
		st.setString(4,ph);
		st.setString(5,address);
		st.setInt(6, bonus);
		int count=st.executeUpdate();//DML
		System.out.println(count+"row/s effected");
		st.close();
		con.close();
		

	}

}
