package org.Database;

import java.io.File;
import java.sql.*;
public class DB_config
{
	 protected Connection conn;
	 protected PreparedStatement stmt;
	 protected ResultSet rs;
	 protected CallableStatement cstml;
	 public DB_config()
	 {
		 try
		 {
//			 System.out.println(url);
			 
			 Class.forName(Path_Helper.p.getProperty("db.driverClass"));
			 
			 conn=DriverManager.getConnection(Path_Helper.p.getProperty("db.url") ,Path_Helper.p.getProperty("db.username"),
					 Path_Helper.p.getProperty("db.password"));
			
			 
			 if(conn!=null)
			 {
//				 System.out.println("Database Is Connected Successfully......");
			 }
			 else {
				  System.out.println("Some Problem is there.......");
			 }
		 }
		 
		 catch(Exception ex)
		 {
			 System.out.println("Exception is:"+ex);
		 }
	 }
	 
	 public static void main(String x[])
	 {
		 System.out.println("hiii");
		new DB_config();
	 }
	
}