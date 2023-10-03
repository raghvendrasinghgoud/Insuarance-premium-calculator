package com.nagarro.inputOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

import com.nagarro.categories.Cars;
import com.nagarro.categories.Insurance;
import com.nagarro.entities.Car;
import com.nagarro.factory.CarFactory;
import com.nagarro.validation.IncompleteDetails;
import com.nagarro.validation.InvalidCarType;
import com.nagarro.validation.InvalidDetails;
import com.nagarro.validation.InvalidInsuaranceType;

public class InputOutput {
	private ArrayList<Car> cars = new ArrayList<>();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	private String Input;

	private String Model = null;
	private String Type = null;
	private float Price;
	private Insurance InsuaranceType = null;

	/*
	 * getInput() function takes input from buffered reader in the input variable
	 */
	private void getInput() throws IOException {
		System.out.println("Enter car details");
		Input = br.readLine();
	}

	/*
	 * parseInput funtion converts input variable string into tokens by
	 * stringTokenizer then pass this tokens in pair of two tokens inside set values
	 * funtion of this class.
	 */
	private void parseInput() throws NumberFormatException, InvalidDetails,IncompleteDetails, InvalidCarType, InvalidInsuaranceType {
		StringTokenizer st = new StringTokenizer(Input, " -");
		int tokenCount = st.countTokens();

		for (int i = 0; i < tokenCount; i += 2) {

			setValues(st.nextToken(), st.nextToken());

		}

		if (Model == null || Type == null || InsuaranceType == null)
			throw new IncompleteDetails("incomplete details");

	}

	/*
	 * setValues funtion takes two tokens of a input string and retrieve data for
	 * cars and sets this data to variables after validation if data is
	 * inappropriate it throes Exception like
	 * NumberFormatException,InvalidDetails,InvalidCartype,InvalidInsuaranceType.
	 */
	public void setValues(String valueName, String Value)
			throws NumberFormatException, InvalidDetails, InvalidCarType, InvalidInsuaranceType {

		switch (valueName.toLowerCase()) {
		case "model":
			Model = Value;
			break;
		case "type":
			Cars[] cars = Cars.values();
			for (int i = 0; i < cars.length; i++) {
				if (Value.equalsIgnoreCase(cars[i].toString())) {
					Type = Value;
				}
			}
			if (Type == null) {
				throw new InvalidCarType("Invalid Car type **It should be Hatchback, Sedan or SUV");
			}
			break;
		case "price":
			Price = Float.parseFloat(Value);

			break;
		case "insurancetype":
			if (Value.equalsIgnoreCase(Insurance.BASIC.toString())) {
				InsuaranceType = Insurance.BASIC;
			} else{ if(Value.equalsIgnoreCase(Insurance.PREMIUM.toString())){
				InsuaranceType = Insurance.PREMIUM;
					}else {
							throw new InvalidInsuaranceType("Invalid Insurance type  ** it should be Basic or Premium");
							}
			}
			break;
		default:
			throw new InvalidDetails("Invalid details");
		}

	}

	/*
	 * showDetails funtion prints all the details of cars entered by the user
	 */
	private void showDetails() {
		DecimalFormat decfor = new DecimalFormat("0.00");  
		float totalValue=0;
		
		System.out.println("Model\t\tType\t\tPrice\t\tInsurance\tInsurance Amount");
		for (Car c : cars) {
			System.out.println(c.getModel()+"\t\t"+c.getClass().getSimpleName()+"\t\t"+decfor.format(c.getCostPrice())+"\t"+c.getInsuaranceType()+"\t\t"+decfor.format(c.calculateInsurance()));
			totalValue+=c.calculateInsurance();
		}
		System.out.println("\n\nTotal= "+decfor.format(totalValue));
	}

	public void Start() {
		char ch = 'y';
		while (ch != 'n') {
			try {
				getInput();
				parseInput();
				Car car = CarFactory.getCarInstance(Model, Type, Price, InsuaranceType);
				cars.add(car);
				// reseting variables
				Model = null;
				Type = null;
				Price = 0;
				InsuaranceType = null;
				
				System.out.println("Do you want to enter details of any other car (y/n):");
				
				
				ch = br.readLine().charAt(0);

			} catch (IOException e) {
				System.out.println("Invalid and incomplete details");
			} catch (NullPointerException e) {
				System.out.println("Invalid and incomplete details");
			} catch (NumberFormatException e) {
				System.out.println("Price should be in decimals only");
			} catch (InvalidCarType e) {
				System.out.println(e.getMessage());
			} catch (InvalidDetails e) {
				System.out.println(e.getMessage());
			} catch (InvalidInsuaranceType e) {
				System.out.println(e.getMessage());
			} catch (NoSuchElementException e) {
				System.out.println("Invalid and incomplete details");
			} catch (StringIndexOutOfBoundsException e) {

			}catch (IncompleteDetails e){
				System.out.println(e.getMessage());
			}
			
			
		}

		showDetails();
	}

	public static void main(String[] args) throws Exception {
		InputOutput io = new InputOutput();
		io.Start();
	}
}
