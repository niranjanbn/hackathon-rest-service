package com.cbre.hackathonrestservice.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.springframework.stereotype.Service;

@Service
public class StatburstConnection {
	
	public Connection getConnection() {
		
		String url = "jdbc:trino://datapoc-datapoc.trino.galaxy.starburst.io:443";
        Properties properties = new Properties();
        properties.setProperty("user", "srujan.valisetti@gmail.com/accountadmin");
        properties.setProperty("password", "FastForward1343");
        properties.setProperty("SSL", "true");
       // System.out.println("2nd print stmt");
        Connection conn;
		try {
			conn = DriverManager.getConnection(url, properties);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			conn = null;
		}
        
        return conn;
        		
	}

}
