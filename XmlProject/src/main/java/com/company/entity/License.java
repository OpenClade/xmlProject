package com.company.entity;

import java.sql.Date;

public class License {
	private int id;
	private Date givenDate;
	private String number;
	private int personId;
	public License(int id, Date givenDate, String number, int personId) {
		super();
		this.id = id;
		this.givenDate = givenDate;
		this.number = number;
		this.personId = personId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getGivenDate() {
		return givenDate;
	}
	public void setGivenDate(Date givenDate) {
		this.givenDate = givenDate;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	@Override
	public String toString() {
		return "License [id=" + id + ", givenDate=" + givenDate + ", number=" + number + ", personId=" + personId + "]";
	}
}
