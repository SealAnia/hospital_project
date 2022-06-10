package com.example.hospital.dto;

import java.util.Date;

public class ProcedureDto {
	
	private Integer procedureid;
	private String name;
	private String details;
	private Date date;
	
	public Integer getProcedureid() {
		return procedureid;
	}
	public void setProcedureid(Integer procedureid) {
		this.procedureid = procedureid;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

}
