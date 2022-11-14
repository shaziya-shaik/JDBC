package JDBC;
import java.sql.*;
public class Demo_4 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		StudentDAO dao=new StudentDAO();
		Student s1=dao.getStudent(74);
		System.out.println(s1.s_name);
		
		
		Student s2=new Student();
		s2.roll_no=110;
		s2.s_name="nagoor";
		dao.addStudent(s2);
		//dao.removeStudent(110);
		

	}
}
	class StudentDAO{
	
		public Student getStudent(int roll_no) throws Exception{
			Student s= new Student();
			s.roll_no=roll_no;
			
			String Query="select s_name from student where roll_no="+roll_no;
			String url="jdbc:mysql://localhost:3306/JDBC";
			String username="root";
			String password="shaziya@oct2002";
			
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,username,password);
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(Query);
			rs.next();
			String s_name=rs.getString(1);
			s.s_name=s_name;
			return s;
		}
	
		
		
		
		public void addStudent(Student s) throws ClassNotFoundException, SQLException {
			
			String url="jdbc:mysql://localhost:3306/JDBC";
			String username="root";
			String password="shaziya@oct2002";
			
			String Query="insert into student values(?,?);";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,username,password);
			PreparedStatement st=con.prepareStatement(Query);
			st.setInt(1,s.roll_no);
			st.setString(2,s.s_name);
			int count=st.executeUpdate();
			System.out.println(count+"row/s are effected");
			st.close();
			con.close();
			
		}
		
		
		public void removeStudent(int roll_no) throws Exception{
			Student s= new Student();
			s.roll_no=roll_no;
			
			String Query="Delete  from student where roll_no="+roll_no;
			String url="jdbc:mysql://localhost:3306/JDBC";
			String username="root";
			String password="shaziya@oct2002";
			
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,username,password);
			PreparedStatement st=con.prepareStatement(Query);
			int count=st.executeUpdate();
			System.out.println(count+"row/s are effected");
		}
		
		
	}
	
	
	
	
	class Student{
		int roll_no;
		String s_name;
	}
