package com.company.entity;

import java.sql.Date;

public class Insurance {
	private int id;
	private String personFirstName;
	private String personLastName;
	private int personAge;
	private String car_class;
	private int insurancePrice;
	private Date startDate;
	private Date endDate;
	private String number;
	public Insurance(int id, String personFirstName, String personLastName, int personAge, String car_class,
			int insurancePrice, Date startDate, Date endDate, String number) {
		super();
		this.id = id;
		this.personFirstName = personFirstName;
		this.personLastName = personLastName;
		this.personAge = personAge;
		this.car_class = car_class;
		this.insurancePrice = insurancePrice;
		this.startDate = startDate;
		this.endDate = endDate;
		this.number = number;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPersonFirstName() {
		return personFirstName;
	}
	public void setPersonFirstName(String personFirstName) {
		this.personFirstName = personFirstName;
	}
	public String getPersonLastName() {
		return personLastName;
	}
	public void setPersonLastName(String personLastName) {
		this.personLastName = personLastName;
	}
	public int getPersonAge() {
		return personAge;
	}
	public void setPersonAge(int personAge) {
		this.personAge = personAge;
	}
	public String getCar_class() {
		return car_class;
	}
	public void setCar_class(String car_class) {
		this.car_class = car_class;
	}
	public int getInsurancePrice() {
		return insurancePrice;
	}
	public void setInsurancePrice(int insurancePrice) {
		this.insurancePrice = insurancePrice;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	@Override
	public String toString() {
		return "Insurance [id=" + id + ", personFirstName=" + personFirstName + ", personLastName=" + personLastName
				+ ", personAge=" + personAge + ", car_class=" + car_class + ", insurancePrice=" + insurancePrice
				+ ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}
	
}
