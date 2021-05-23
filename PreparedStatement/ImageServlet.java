import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import java.io.*;
import java.sql.*;

@WebServlet(name = "ImageServlet", urlPatterns = {"/home"})
@MultipartConfig
public class ImageServlet extends HttpServlet {
	
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    	{
			PrintWriter out=response.getWriter();
			String firstname= request.getParameter("fname");
			Part filePart = request.getPart("photo");
			InputStream inputStream = filePart.getInputStream();
			String SQL= "INSERT INTO stock " + "(fname, " + "photo) values (?, ?)";
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Connection con=null;
			
			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","","");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
	  	    PreparedStatement preparedStatement;
			try {
				preparedStatement = con.prepareStatement(SQL);
				preparedStatement.setString(1, firstname);
				if (filePart != null) {
					preparedStatement.setBlob(2, inputStream);
				}
				preparedStatement.executeUpdate();
				
				out.println("Image Added Successfully.");
				
			}
			catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			
    	}
}
