package com.cbre.hackathonrestservice.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cbre.hackathonrestservice.controller.output.Response;
import com.cbre.hackathonrestservice.dao.StarburstService;
import com.cbre.hackathonrestservice.dao.entities.Employee;
import com.cbre.hackathonrestservice.dao.entities.Entity;

@RestController
@RequestMapping(path="/hackathon")
public class HackathonController {
	
	//@Autowired
    //private JdbcTemplate jdbcTemplate;
	
	//@Autowired
	//List<Employee> employees;
	
	@Autowired
	private StarburstService service;

	@GetMapping(path="/status", produces=MediaType.APPLICATION_JSON_VALUE)
	public String status(){
		return "Success";
	}
	
	@ModelAttribute
    public void setResponseHeader(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
    }
	
	
	@GetMapping(path="/getEmpList", produces=MediaType.APPLICATION_JSON_VALUE)
	public Response getData(){
		
		System.out.println("Fetching EmpList");
		Response response = new Response();
		
		List<Entity> employees = new ArrayList<Entity>();
		
		try {
			employees = service.getEmployeeList();
		}catch(Exception e) {
			e.printStackTrace();
        	response.setStatus("Failed");
        	response.setError(e.getMessage());
		}
		
		//String sql = "select id from property_listing.property.listing";
		//String sql = "select P.emp_id, S.emp_name, S.region from \"property_listing\".\"people\".\"employee\" as P , \"snowflake_test\".\"DATA\".\"PEOPLE_ALL\" as S where P.emp_name = S.emp_name limit 10 ";
        //System.out.println("1st print stmt");
        /*try {
        
	        // properties
	        String url = "jdbc:trino://datapoc-datapoc.trino.galaxy.starburst.io:443";
	        Properties properties = new Properties();
	        properties.setProperty("user", "srujan.valisetti@gmail.com/accountadmin");
	        properties.setProperty("password", "FastForward1343");
	        properties.setProperty("SSL", "true");
	       // System.out.println("2nd print stmt");
	        Connection connection = DriverManager.getConnection(url, properties);
	       // System.out.println("3rd print stmt");
	        //String url = "jdbc:trino://datapoc-datapoc.trino.galaxy.starburst.io:443?user=srujan.valisetti@gmail.com/accountadmin";
	        //Driver driver = DriverManager.getDriver(url);
	        
	        Statement stmt = connection.createStatement();
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
        } catch(Exception e){
        	e.printStackTrace();
        	response.setStatus("Failed");
        	response.setError(e.getMessage());
        }*/
        
        System.out.println("Fetch completed. Employees count:"+employees.size());
        if (response.getStatus()!= "Failed" ) {
            response.setStatus("Success");
        }

        response.setResult(employees);
		
		return response;
	}
}
