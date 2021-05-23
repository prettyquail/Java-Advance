import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out=response.getWriter();
		System.out.print("hi");
		
		
		Student obj=new Student();
		obj.noParameters();
		out.println("Java Function To Call Stored Procedure With No Parameters Done");
		
		obj.inParameters();
		out.println("Java Program To Call Stored Procedure With IN Parameters Done");
		
		obj.inAndOutParameters();
		out.println("Java Program To Call Stored Procedure With IN and OUT Parameters Done");
		
		
		obj.inOutParameters();
		out.println("Java Program To Call Stored Procedure With IN OUT Parameters Done");
		
	}
}
