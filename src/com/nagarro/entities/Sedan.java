package com.nagarro.entities;

import  com.nagarro.calculator.Calculate;

import com.nagarro.categories.Insurance;

public class Sedan extends Car{

	public Sedan(String model, float costPrice, Insurance insuranceType) {
		super(model, costPrice, insuranceType);
		getRate();
	}

	@Override
	void getRate() {
		Rate=8;		
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
		return "Sedan [Model=" + Model + ", CostPrice=" + CostPrice + ", InsuaranceType=" + InsuranceType + ", Rate="
				+ Rate + ", calculateInsuarance()=" + calculateInsurance() + "]";
	}

	
}
