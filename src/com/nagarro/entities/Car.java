package com.nagarro.entities;

import com.nagarro.categories.Insurance;

public abstract class Car {

	protected String Model;
	protected float CostPrice;
	protected Insurance InsuranceType;
	protected float Rate;
	abstract void getRate();
	abstract public float calculateInsurance();
	public Car(String model, float costPrice, Insurance insuranceType) {
		super();
		Model = model;
		CostPrice = costPrice;
		InsuranceType = insuranceType;
	}
	public String getModel() {
		return Model;
	}
	public void setModel(String model) {
		Model = model;
	}
	public float getCostPrice() {
		return CostPrice;
	}
	public void setCostPrice(float costPrice) {
		CostPrice = costPrice;
	}
	public Insurance getInsuaranceType() {
		return InsuranceType;
	}
	public void setInsuaranceType(Insurance insuranceType) {
		InsuranceType = insuranceType;
	}
	
}
