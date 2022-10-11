package com.cbre.hackathonrestservice.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbre.hackathonrestservice.dao.entities.Employee;
import com.cbre.hackathonrestservice.dao.entities.Entity;

@Service
public class StarburstService {

	@Autowired
	private StatburstConnection connection;
		
	public List<Entity> getEmployeeList() throws Exception{
		
		List<Entity> employees = new ArrayList<Entity>();
		
		String sql = "select P.emp_id, S.emp_name, S.region from \"property_listing\".\"people\".\"employee\" as P , \"snowflake_test\".\"DATA\".\"PEOPLE_ALL\" as S where P.emp_name = S.emp_name limit 10 ";
		
		Connection conn = connection.getConnection();
		Statement stmt;
		try {
			stmt = conn.createStatement();
		
        //System.out.println("4th print stmt");
        ResultSet rs = stmt.executeQuery(sql);
        //System.out.println("5th print stmt");
        
        // Extract data from result set
        while (rs.next()) {
           // Retrieve by column name
           System.out.println("emp_id: " + rs.getInt("emp_id"));
           
           Employee emp = new Employee();
           emp.setId(rs.getString("emp_id"));
           emp.setName(rs.getString("emp_name"));
           emp.setRegion(rs.getString("region"));
           
           employees.add(emp);
           
        }
		} catch (SQLException e) {	
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
		
		return employees;
		
	}
	
}
