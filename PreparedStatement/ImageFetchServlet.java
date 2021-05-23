import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
@WebServlet(name = "ImageFetchServlet", urlPatterns = {"/fetch"})
@MultipartConfig
public class ImageFetchServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{ 
		Connection con;
		try {
			String name = request.getParameter("fname");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","","");
			PreparedStatement ps = con.prepareStatement("select * from stock where fname=?");
			ps.setString(1,name);
			ResultSet rs= ps.executeQuery();
			if(rs.next()) {
				Blob blob=(Blob) rs.getBlob(2);
				System.out.println("data fetched for "+name);
				byte byteArray[] = blob.getBytes(1,(int)blob.length());
				response.setContentType("image/gif");
				ServletOutputStream os = response.getOutputStream();
				os.write(byteArray);
				os.flush();
				os.close();
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
    }
}
