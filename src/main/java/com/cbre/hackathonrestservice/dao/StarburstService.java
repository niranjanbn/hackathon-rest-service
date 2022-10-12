package com.cbre.hackathonrestservice.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbre.hackathonrestservice.dao.entities.ClassificationDetails;
import com.cbre.hackathonrestservice.dao.entities.Employee;
import com.cbre.hackathonrestservice.dao.entities.Entity;
import com.cbre.hackathonrestservice.dao.entities.LeaseSales;

@Service
public class StarburstService {

	private static final Logger logger = LoggerFactory.getLogger(StarburstService.class);
	
	@Autowired
	private StatburstConnection connection;
		
	public List<Entity> getEmployeeList() throws Exception{
		logger.info("--- StarburstService::getEmployeeList()::Start  ---");
		
		List<Entity> employees = new ArrayList<Entity>();
		
		String sql = "select P.emp_id, S.emp_name, S.region from \"pg_test\".\"people\".\"employee\" as P , \"snowflake_test\".\"DATA\".\"PEOPLE_ALL\" as S where P.emp_name = S.emp_name limit 25 ";
		
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
			logger.error(e.getMessage());
			throw e;
		}
		logger.info("--- StarburstService::getEmployeeList()::End  ---");
		return employees;
		
	}
	
	public List<Entity> getClassificationDetails() throws Exception{
		logger.info("--- StarburstService::getClassificationDetails()::Start  ---");
		
		List<Entity> classifications = new ArrayList<Entity>();
		
		String sql = "select p.column_name,c.classificationname from \"pg_test\".\"people\".\"tableclassificationpropertydata\" as p,\"property_listing\".\"people\".\"heckathon_classification\" as c where c.classificationid = p.classification";
		
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
           
           ClassificationDetails classification = new ClassificationDetails();
           classification.setColumn(rs.getString("column_name"));
           classification.setClassification(rs.getString("classificationname"));
           
           classifications.add(classification);
           
        }
		} catch (SQLException e) {	
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e.getMessage());
			throw e;
		}
		logger.info("--- StarburstService::getClassificationDetails()::End  ---");
		return classifications;
		
	}
	
	public List<Entity> getLeaseSales(boolean admin) throws Exception{
		logger.info("--- getLeaseSales()::Start  ---");
		
		List<Entity> leaseSales = new ArrayList<Entity>();
		
		String sql = "SELECT  so.ordernumber, so.saleschannel, so.customerid, c.customername, so.LocationID, l.CityName, so.productid, p.ProductName, so.salesteamid, sm.SalesName, r.Region, so.orderdate, so.shipdate, so.deliverydate, so.quantity, so.currencycode, so.unitcost as \"Amount\" FROM    \"snowflake_test\".\"DATA\".salesorders as so LEFT JOIN \"pg_test\".\"people\".\"customers\" as c ON (c.customerid = so.customerid) LEFT JOIN \"mysql_test\".\"datapoc\".\"Locations\" as l ON (l.locationid = so.locationid) LEFT JOIN \"mysql_test\".\"datapoc\".\"Products\" as p ON (p.ProductID = so.productid) LEFT JOIN \"mysql_test\".\"datapoc\".\"SalesMembers\" as sm ON (sm.SalesTeamID = so.salesteamid) LEFT JOIN \"mysql_test\".\"datapoc\".Regions r ON (r.Region = sm.Region) LIMIT 25 ";
		
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
           
           LeaseSales leaseSale = new LeaseSales();
           if (!admin) {
        	   leaseSale.setOrderNumber(maskConfidentialColumns(rs.getString("ordernumber")));
        	   leaseSale.setSalesChannel(maskPrivateColumns(rs.getString("saleschannel")));
        	   leaseSale.setCustomerId(maskConfidentialColumns(rs.getString("customerid")));
        	   leaseSale.setLocationId(maskPrivateColumns(rs.getString("LocationID")));
        	   leaseSale.setAmount(maskConfidentialColumns(rs.getString("Amount")));
           } else {
        	   leaseSale.setOrderNumber(rs.getString("ordernumber"));
        	   leaseSale.setSalesChannel(rs.getString("saleschannel"));
        	   leaseSale.setCustomerId(rs.getString("customerid"));
        	   leaseSale.setLocationId(rs.getString("LocationID"));
        	   leaseSale.setAmount(rs.getString("Amount"));
           }
           
           leaseSale.setCustomerName(rs.getString("customername"));           
           leaseSale.setCityName(rs.getString("CityName"));
           leaseSale.setProductId(rs.getString("productid"));
           leaseSale.setProductName(rs.getString("ProductName"));
           leaseSale.setSalesTeamId(rs.getString("salesteamid"));
           leaseSale.setSalesName(rs.getString("SalesName"));
           leaseSale.setRegion(rs.getString("Region"));
           leaseSale.setOrderDate(rs.getString("orderdate"));
           leaseSale.setShipDate(rs.getString("shipdate"));
           leaseSale.setDeliveryDate(rs.getString("deliverydate"));
           leaseSale.setQuantity(rs.getFloat("quantity"));
           leaseSale.setCurrenctCode(rs.getString("currencycode"));
           
           leaseSales.add(leaseSale);
           
        }
		} catch (SQLException e) {	
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e.getMessage());
			throw e;
		}
		logger.info("--- getLeaseSales::End  ---");
		return leaseSales;
		
	}
	
	private String maskPrivateColumns(String str) {
		return str.replaceAll(".", "X");
	}
	
	private String maskConfidentialColumns(String str) {
		 return str.replaceAll(".(?=.{3})", "X");
		
		
	}
}
