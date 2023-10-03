package com.nagarro.entities;

import com.nagarro.calculator.Calculate;
import com.nagarro.categories.Insurance;

public class Hatchback extends Car {

	public Hatchback(String model, float costPrice, Insurance insuaranceType) {
		super(model, costPrice, insuaranceType);
		getRate();
	}


	@Override
	 void getRate() {
		Rate=5;
		
	}

	
	@Override
	public float calculateInsurance() {
		float InsuarancePrice = Calculate.getPercentageOfValue(Rate, CostPrice);
		if(InsuranceType==Insurance.PREMIUM)
			return InsuarancePrice+Calculate.getPercentageOfValue(20, InsuarancePrice);
		else 
			return InsuarancePrice; 	
	}


	@Override
	public String toString() {
		return "Hatchback [Model=" + Model + ", CostPrice=" + CostPrice + ", InsuaranceType=" + InsuranceType
				+ ", Rate=" + Rate + ", calculateInsuarance()=" + calculateInsurance() + "]";
	}

	
}
