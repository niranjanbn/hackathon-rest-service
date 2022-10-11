package com.cbre.hackathonrestservice.dao.entities;

import java.util.Date;

//import javax.persistence.*;

//@Entity
//@Table(name = "call_center")
public class CallCenter {

	
	//@Id
    //@Column(name = "cc_call_center_sk")
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ccCallCenterSk;
 
    private String ccCallCenterId;
    private Date ccRecStartDate;
    private Date ccRecEndDate;
    
    
    // cc_closed_date_sk:integer, cc_open_date_sk:integer, cc_name:varchar(50), cc_class:varchar(50), cc_employees:integer, cc_sq_ft:integer, cc_hours:char(20), cc_manager:varchar(40), cc_mkt_id:integer, cc_mkt_class:char(50), cc_mkt_desc:varchar(100), cc_market_manager:varchar(40), cc_division:integer, cc_division_name:varchar(50), cc_company:integer, cc_company_name:char(50), cc_street_number:char(10), cc_street_name:varchar(60), cc_street_type:char(15), cc_suite_number:char(10), cc_city:varchar(60), cc_county:varchar(30), cc_state:char(2), cc_zip:char(10), cc_country:varchar(20), cc_gmt_offset:decimal(5,2), cc_tax_percentage:decimal(5,2)
    
    public Long getCcCallCenterSk() {
		return ccCallCenterSk;
	}
	public void setCcCallCenterSk(Long ccCallCenterSk) {
		this.ccCallCenterSk = ccCallCenterSk;
	}
	public String getCcCallCenterId() {
		return ccCallCenterId;
	}
	public void setCcCallCenterId(String ccCallCenterId) {
		this.ccCallCenterId = ccCallCenterId;
	}
	public Date getCcRecStartDate() {
		return ccRecStartDate;
	}
	public void setCcRecStartDate(Date ccRecStartDate) {
		this.ccRecStartDate = ccRecStartDate;
	}
	public Date getCcRecEndDate() {
		return ccRecEndDate;
	}
	public void setCcRecEndDate(Date ccRecEndDate) {
		this.ccRecEndDate = ccRecEndDate;
	}
    
    
}
