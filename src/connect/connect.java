package connect;

import java.sql.Connection;
import java.sql.DriverManager;

public class connect 
{
	public static final String DRIVER="com.mysql.jdbc.Driver";
	public static Connection con;
	public static final String URL="jdbc:mysql://localhost:3306/";
	public static final String USERNAME ="root";
	public static final String PASSWORD ="";
	public static final String DATABASE ="fms";
	
	public static Connection connection()
	{
		try{
			Class.forName(DRIVER);
			con= DriverManager.getConnection(URL+DATABASE,USERNAME,PASSWORD);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return con;
	}
	public static void main(String[] args)
	{
		connection();
	}
}
