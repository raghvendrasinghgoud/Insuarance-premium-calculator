package com.nagarro.entities;

import com.nagarro.calculator.Calculate;
import com.nagarro.categories.Insurance;

public class SUV extends Car{

	public SUV(String model, float costPrice, Insurance insuranceType) {
		super(model, costPrice, insuranceType);
		getRate();
	}

	@Override
	void getRate() {
		Rate=10;
		
	}

	@Override
	public float calculateInsurance() {

		float InsurancePrice = Calculate.getPercentageOfValue(Rate, CostPrice);
		if(InsuranceType==Insurance.PREMIUM)
			return InsurancePrice+Calculate.getPercentageOfValue(20, InsurancePrice);
		else 
			return InsurancePrice; 
	}

	@Override
	public String toString() {
		return "SUV [Model=" + Model + ", CostPrice=" + CostPrice + ", InsuaranceType=" + InsuranceType + ", Rate="
				+ Rate + ", calculateInsuarance()=" + calculateInsurance() + "]";
	}

	
}
