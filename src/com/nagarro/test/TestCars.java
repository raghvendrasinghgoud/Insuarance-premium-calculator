package com.nagarro.test;

import com.nagarro.categories.Insurance;
import com.nagarro.entities.Hatchback;
import com.nagarro.entities.SUV;
import com.nagarro.entities.Sedan;

public class TestCars {

	public static void main(String[] args) {
		Sedan sedan=new Sedan("slavia", 1000000, Insurance.PREMIUM);
		SUV suv=new SUV("XUV 700", 1700000, Insurance.BASIC);
		Hatchback hb=new Hatchback("i20", 900000, Insurance.BASIC); 
		System.out.println(sedan+"\n"+suv+"\n"+hb);
	}
}
