package com.example.hospital.dto;

public class MedicineDto {
	
	private Integer id;
	private String name;
	private Double numberPerDay;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Double getNumberPerDay() {
		return numberPerDay;
	}
	public void setNumberPerDay(Double numberPerDay) {
		this.numberPerDay = numberPerDay;
	}
	

}
