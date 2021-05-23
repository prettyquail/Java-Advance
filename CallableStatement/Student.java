import java.sql.*;
public class Student {

	public void noParameters() {
		// TODO Auto-generated method stub
		try
        {
            //Database Credentials
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
            String URL = "jdbc:mysql://localhost:3306/demo";
   
            String username = "";
   
            String password = "";
   
            //STEP 2 : Creating The Connection Object
   
            Connection con = DriverManager.getConnection(URL, username, password);
   
            //STEP 3 : Creating The CallableStatement Object
   
            CallableStatement cstmt = con.prepareCall("{call P1}");
              
            //STEP 4 : Executing The CallableStatement
             
            cstmt.execute();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
	}

	public void inParameters() {
		// TODO Auto-generated method stub
		try
        {
            //Database Credentials
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
            String URL ="jdbc:mysql://localhost:3306/demo";
   
            String username = "";
   
            String password = "";
   
            //STEP 2 : Creating The Connection Object
   
            Connection con = DriverManager.getConnection(URL, username, password);
   
            //STEP 3 : Creating the CallableStatement object by passing IN parameters
   
            CallableStatement cstmt = con.prepareCall("{call P2('MyName', 123)}");
              
            //STEP 4 : Executing The CallableStatement
             
            cstmt.execute();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
	}

	public void inAndOutParameters() {
		// TODO Auto-generated method stub
		try
        {
            //Database Credentials
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
            String URL = "jdbc:mysql://localhost:3306/demo";
   
            String username = "";
   
            String password = "";
   
            //STEP 2 : Creating The Connection Object
   
            Connection con = DriverManager.getConnection(URL, username, password);
   
            //STEP 3 : Creating The CallableStatement Object
   
            CallableStatement cstmt = con.prepareCall("{call P3(?, ?)}");
              
            //Setting IN Parameter
             
            cstmt.setInt(1, 123);
             
            //Registering OUT parameters
             
            cstmt.registerOutParameter(2, Types.VARCHAR);
             
            //STEP 4 : Executing The CallableStatement
             
            cstmt.execute();
             
            //Retrieving the result returned by stored procedure
             
            String grade = cstmt.getString(2);
             
            System.out.println(grade);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
	}
	
	public void inOutParameters() {
		// TODO Auto-generated method stub
		try
        {
            //Database Credentials
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
            String URL = "jdbc:mysql://localhost:3306/demo";
   
            String username = "";
   
            String password = "";
   
            //STEP 2 : Creating The Connection Object
   
            Connection con = DriverManager.getConnection(URL, username, password);
   
            //STEP 3 : Creating The CallableStatement Object
   
            CallableStatement cstmt = con.prepareCall("{call P4(?, ?)}");
              
            //Setting IN Parameters
             
            cstmt.setInt(1, 123);
             
            cstmt.setString(2, "LAST");
             
            //Registering OUT parameters
             
            cstmt.registerOutParameter(2, Types.VARCHAR);
             
            //STEP 4 : Executing The CallableStatement
             
            cstmt.execute();
             
            //Retrieving OUT parameter
             
            String grade = cstmt.getString(2);
             
            System.out.println(grade);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
	}

}
