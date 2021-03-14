package com.company.entity;

public class ClassOfCar {
	private int id;
	private char c;
	public ClassOfCar(int id, char c) {
		super();
		this.id = id;
		this.c = c;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public char getC() {
		return c;
	}
	public void setC(char c) {
		this.c = c;
	}
	@Override
	public String toString() {
		return "ClassOfCar [id=" + id + ", c=" + c + "]";
	}
	 
	
}
