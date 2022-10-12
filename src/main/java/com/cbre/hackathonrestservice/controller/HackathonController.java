package com.cbre.hackathonrestservice.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cbre.hackathonrestservice.controller.output.Response;
import com.cbre.hackathonrestservice.dao.StarburstService;
import com.cbre.hackathonrestservice.dao.entities.Entity;

@RestController
@RequestMapping(path="/hackathon")
public class HackathonController {
	
	private static final Logger logger = LoggerFactory.getLogger(HackathonController.class);
	
	@Autowired
	private StarburstService service;

	@GetMapping(path="/status", produces=MediaType.APPLICATION_JSON_VALUE)
	public String status(){
		logger.info("--- HackathonController::status()::Invoked  ---");
		return "Success";
	}
	
	@ModelAttribute
    public void setResponseHeader(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
    }
	
	
	@GetMapping(path="/getEmpList", produces=MediaType.APPLICATION_JSON_VALUE)
	public Response getData(){
		
		logger.info("--- HackathonController::getData()::Start  ---");
		Response response = new Response();
		
		List<Entity> employees = new ArrayList<Entity>();
		
		try {
			employees = service.getEmployeeList();
		}catch(Exception e) {
			e.printStackTrace();
        	response.setStatus("Failed");
        	response.setError(e.getMessage());
        	logger.error(e.getMessage());
		}
        
        logger.info("--- HackathonController::getData()::Fetch completed. Employees count:"+employees.size());
        if (response.getStatus()!= "Failed" ) {
            response.setStatus("Success");
        }

        response.setResult(employees);
        logger.info("--- HackathonController::getData()::End  ---");
		return response;
	}
	
	@GetMapping(path="/getClassificationDetails", produces=MediaType.APPLICATION_JSON_VALUE)
	public Response getClassificationDetails(){
		
		logger.info("--- HackathonController::getClassificationDetails()::Start  ---");
		Response response = new Response();
		
		List<Entity> employees = new ArrayList<Entity>();
		
		try {
			employees = service.getClassificationDetails();
		}catch(Exception e) {
			e.printStackTrace();
        	response.setStatus("Failed");
        	response.setError(e.getMessage());
        	logger.error(e.getMessage());
		}
        
        logger.info("--- HackathonController::getClassificationDetails()::Fetch completed. Classifications count:"+employees.size());
        if (response.getStatus()!= "Failed" ) {
            response.setStatus("Success");
        }

        response.setResult(employees);
        logger.info("--- HackathonController::getClassificationDetails()::End  ---");
		return response;
	}
}
