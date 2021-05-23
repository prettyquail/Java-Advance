import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.*;
import java.io.*;
/**
 * 
 */

/**
 * @author HP
 *
 */
public class Main extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int num1=Integer.parseInt(request.getParameter("num1"));
		int num2=Integer.parseInt(request.getParameter("num2"));
		int num3=0;
		
		PrintWriter out=response.getWriter();
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","","");
			Statement stmt = (Statement) con.createStatement();
			ResultSet rs = stmt.executeQuery("select num3 from numbers where id="+num1);
	     
		      while(rs.next()){  
		  		 num3 = rs.getInt("num3");  
		  		}  
		      rs.close();
		}
		catch(Exception p) {
			System.out.println(p);
		}
		
		int sum = num1+num2+num3;
	  	out.println("num3:"+num3+"||");
	  	out.println("Sum of num1+num2+num3: "+sum);;
	}
}
