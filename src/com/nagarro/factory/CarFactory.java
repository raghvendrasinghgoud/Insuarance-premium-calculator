package com.nagarro.factory;

import com.nagarro.categories.Cars;
import com.nagarro.categories.Insurance;
import com.nagarro.entities.Car;
import com.nagarro.entities.Hatchback;
import com.nagarro.entities.SUV;
import com.nagarro.entities.Sedan;
import com.nagarro.validation.InvalidCarType;

public class CarFactory {

	public static Car getCarInstance(String Model, String Type, float Price, Insurance InsuranceType) {
		if(Type.equalsIgnoreCase(Cars.HATCHBACK.toString())) {
			return new Hatchback(Model,Price,InsuranceType);
		}else {
			if(Type.equalsIgnoreCase(Cars.SEDAN.toString())) {
				return new Sedan(Model,Price,InsuranceType);
			}else {
				if(Type.equalsIgnoreCase(Cars.SUV.toString())) {
					return new SUV(Model, Price, InsuranceType);
				}				
				
			}
		}
		throw new NullPointerException();
	}
}
