package com.qa.testLayer;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DB_Testing {
	Properties prop;
	DB_Testing()
	{
		prop = new Properties();
		try {
			FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\qa\\config\\db_Data.properties");
			prop.load(file);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void db_Testing() throws ClassNotFoundException, SQLException
	{
		//Connection URL Syntax: "jdbc:mysql://ipaddress:portnumber/db_name"			

		String dbUrl = prop.getProperty("dbUrl");

		//Query to Execute		
		String query = "select *  from WisupQA;";	
        
 	    //Load mysql jdbc driver		
   	    Class.forName("com.mysql.jdbc.Driver");			
   
   		//Create Connection to DB		
    	Connection con = DriverManager.getConnection(dbUrl,prop.getProperty("username"),prop.getProperty("password"));
  
  		//Create Statement Object		
	   Statement stmt = con.createStatement();					

			// Execute the SQL Query. Store results in ResultSet		
 		ResultSet rs= stmt.executeQuery(query);							
 
 		// While Loop to iterate through all data and print results		
		while (rs.next()){
	        		String One = rs.getString(1);								        
                    String Two = rs.getString(2);	
                    String Three = rs.getString(3);
                    System. out.println(One+"  "+Two+" "+Three);		
            }		
			 // closing DB Connection		
			con.close();
	}
	
	public static void  main(String[] args) throws  ClassNotFoundException, SQLException {													
		DB_Testing test = new DB_Testing();
		test.db_Testing();
}
}
