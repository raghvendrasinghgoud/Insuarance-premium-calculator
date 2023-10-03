Problem Statement

Write a standalone java program that accepts car’s details and calculate the effective insurance premium after applying the rules.

Input
Car Model
Car Type
Car cost price
Insurance type
Input should be accepted with following command line options:

-model 	<Car model>
-type    <Car type>
-price   <Car cost price>
-insuranceType  <Type of Insurance>


Car Type can have 3 possible values Hatchback, Sedan and SUV and insurance premium calculation rules for 3 types are as follows:

Hatchback: 5% of Car cost price
Sedan: 8% of Car cost price
SUV: 10% of Car cost price

Insurance Type can have 2 possible values Basic and Premium. If Insurance Type entered is Premium, increase the premium value by 20% of the value calculated from car type.

Example:
If car cost price is ₹1000000 and Car type is Sedan.
The insurance premium will be 8% of ₹1000000 = ₹80000. 
Now, if insurance type is Premium, 
the actual premium to be paid will be ₹80000 + 20% of ₹80000 = ₹96000.


Expected Behaviour and Output

The system should provide functionality to add more than one cars i.e. Once the details of first car is entered it should display a message saying: 
	“Do you want to enter details of any other car (y/n):”
Make use of java's object-oriented capabilities for implementing this business logic
Exception handling is expected in the program
Jdk8 should be used for development

Output
Print Car model, price, total insurance to be paid to the console.
