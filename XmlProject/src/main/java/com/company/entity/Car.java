package com.company.entity;

public class Car {
	private int id;
	private String number;
	private int carClassId;
	private int personId;
	public Car(int id, String number, int carClassId, int personId) {
		super();
		this.id = id;
		this.number = number;
		this.carClassId = carClassId;
		this.personId = personId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public int getCarClassId() {
		return carClassId;
	}
	public void setCarClassId(int carClassId) {
		this.carClassId = carClassId;
	}
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	@Override
	public String toString() {
		return "Car [id=" + id + ", number=" + number + ", carClassId=" + carClassId + ", personId=" + personId + "]";
	}
	
}
