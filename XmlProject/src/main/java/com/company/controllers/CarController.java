package com.company.controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.company.data.interfaces.IDB;
import com.company.entity.Car;
import com.company.entity.ClassOfCar;
import com.company.entity.License;
import com.company.entity.Person;

public class CarController {
	private IDB db;
	public CarController(IDB db) {
		this.db = db;
	}
	
	public List<Car> getAllCars() {
		
		 Connection con = null;
	        try {
	            con = db.getConnection();
	            String sql = "SELECT * FROM car";
	            Statement st = con.createStatement();

	            ResultSet rs = st.executeQuery(sql);
	            List<Car> cars = new LinkedList<>();
	          
	            while (rs.next()) {
	            	Car car = new Car(rs.getInt("id"), 
	            			rs.getString("number"), 
	            			rs.getInt("car_class_id"), rs.getInt("person_id"));
	            	cars.add(car);
	            }

	            return cars;
	        } catch (SQLException throwables) {
	            throwables.printStackTrace();
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                con.close();
	            } catch (SQLException throwables) {
	                throwables.printStackTrace();
	            }
	        }
	        return null;
	    }
	public License getLicense(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT * FROM person, license WHERE license.person_id = person.id AND person.id = ?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            
            if (rs.next()) {
            	License license = new License(rs.getInt("id"), 
            			rs.getDate("given_date"), rs.getString("number"), rs.getInt("person_id"));
            	 return license;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }
	public Person getPerson(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT * FROM person WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            
            
            if (rs.next()) {
            	 Person person = new Person(rs.getInt("id"), rs.getString("last_name"), rs.getString("first_name"), rs.getDate("date_of_birth"));
                return person;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }
	public ClassOfCar getClassOfCar(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT * FROM car_class WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
           
         
            if (rs.next()) {
            	ClassOfCar classofcar = new ClassOfCar(rs.getInt("id"), rs.getString("class_category").charAt(0));
                return classofcar;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }
}
