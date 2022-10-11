package com.cbre.hackathonrestservice.controller.output;

import java.util.List;

import com.cbre.hackathonrestservice.dao.entities.Entity;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Response {
	
	public String status;
	public String error;
	public List<Entity> result;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public List<Entity> getResult() {
		return result;
	}
	public void setResult(List<Entity> result) {
		this.result = result;
	}
	
	
}
