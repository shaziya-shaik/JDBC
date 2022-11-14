import java.sql*;
public class Dem1 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		String url="jdbc:mysql:localhost:3306//madhuri";
		String uname="";
		String password="";
		String query="select E_NAME where E_ID=98";
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,uname,password);
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);
		rs.next();
		String name=rs.getString("E_NAME");
		System.out.prinltn(name);
		st.close();
		con.close();
		
	}

}
