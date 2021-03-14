package com.company.controllers;
import java.sql.Date;

public class Utils {
	public static int DateToInt(Date date) {
	 
	 
		Date date1 = new Date(System.currentTimeMillis());
		 
		String str1 = String.format("%tY", date1);
		String str2 = String.format("%tY", date);
		int year1 = Integer.parseInt(str1);
		int year2 = Integer.parseInt(str2);
		return year1 - year2;
	}
	/*
	 * Method which a calculate insuranse price
	 */
	public static int calculateInsurancePrice(int year, int id) {
		return (int) (10000 + (experienceModificator(year, 10000) + classModificator(id, 10000)));
	}
	/*
	 * method, which a calculate experiencemodificator
	 */
	public static double experienceModificator(int year, int sum) {
		if(year >= 0 && year <= 4) {
			return (0.1 * - sum);
		} else if(year >= 5 && year <= 9) {
			return 0;
		} else if(year >= 10 && year <= 14) {
			return 0.1 * sum;
		} else if(year >= 15 && year <= 21) {
			return 0.2 * sum;
		} else {
			return 0.3 * sum;
		}
	}
	/*
	 * method, which calculate a classmodificator
	 */
	public static double classModificator(int id, int sum) {
		if(id == 1) {
			return (0.1 * sum);
		} else if(id == 2 || id == 3) {
			return 0;
		} else if(id == 4 || id == 5) {
			return 0.1 * - sum;
		} else if(id == 6 || id == 7) {
			return 0.15 * -sum;
		} else {
			return 0.3 * -sum;
		}
	}
}
