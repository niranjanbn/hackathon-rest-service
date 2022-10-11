package com.cbre.hackathonrestservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 	//String sql = "select id from property_listing.property.listing";
		 	String sql = "select * from property_listing.people.employee";
	        System.out.println("1st print stmt");
	        try {
	        
	        // properties
	        String url = "jdbc:trino://datapoc-datapoc.trino.galaxy.starburst.io:443";
	        Properties properties = new Properties();
	        properties.setProperty("user", "srujan.valisetti@gmail.com/accountadmin");
	        properties.setProperty("password", "FastForward1343");
	        properties.setProperty("SSL", "true");
	        System.out.println("2nd print stmt");
	        Connection connection = DriverManager.getConnection(url, properties);
	        System.out.println("3rd print stmt");
	        //String url = "jdbc:trino://datapoc-datapoc.trino.galaxy.starburst.io:443?user=srujan.valisetti@gmail.com/accountadmin";
	        //Driver driver = DriverManager.getDriver(url);
	        
	        
	        Statement stmt = connection.createStatement();
	        System.out.println("4th print stmt");
	        ResultSet rs = stmt.executeQuery(sql);
	        System.out.println("5th print stmt");
	        
	        // Extract data from result set
	        while (rs.next()) {
	           // Retrieve by column name
	           //System.out.println("id: " + rs.getString("id"));
	           System.out.println("emp_id: " + rs.getInt("emp_id"));
	           
	        }
	        } catch(Exception e){
	        	e.printStackTrace();
	        }
		
	}

}
