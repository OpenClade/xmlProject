package com.company.controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.company.data.interfaces.IDB;
import com.company.entity.Car;
import com.company.entity.Insurance;
import com.company.entity.License;

public class InsuranceController {
	private IDB db;
	public InsuranceController(IDB db) {
		this.db = db;
	}
	public int getIdOfPerson(String numberofCar) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT * FROM car WHERE number = ?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, numberofCar);
            ResultSet rs = st.executeQuery();
            
            if (rs.next()) {
            	
            	 return rs.getInt("person_id");
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
        return -1;
    }
	public int getCarClass(int person_id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT car_class_id FROM car, person WHERE car.person_id= person.id AND person.id = ?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, person_id);
            ResultSet rs = st.executeQuery();
            
            
            if (rs.next()) {
            
            	 return rs.getInt("car_class_id");
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
        return -1;
    }
	public void addInsurance(Insurance insurance) {
        Connection con = null;
        try {
            con = db.connectionInsurance();
            String sql = "INSERT INTO insurance(id, person_firstname, person_lastname, person_age, car_class, car_number, insurance_price, start_date, end_date) VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, insurance.getId());
            st.setString(2, insurance.getPersonFirstName());
            st.setString(3, insurance.getPersonLastName());
            st.setInt(4, insurance.getPersonAge());
            st.setString(5, insurance.getCar_class());
            st.setString(6, insurance.getNumber());
            st.setInt(7, insurance.getInsurancePrice());
            st.setDate(8, insurance.getStartDate());
            st.setDate(9, insurance.getEndDate());
            	
            	st.execute();
          
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
    }
}
