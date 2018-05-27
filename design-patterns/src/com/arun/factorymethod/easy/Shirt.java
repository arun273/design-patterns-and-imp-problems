package com.arun.factorymethod.easy;

/**
 * Concrete Class implementing GarmentType
 * 
 * @author Arun
 * 
 */
public class Shirt implements GarmentType {
	@Override
	public String print() {
		System.out.println("Shirt Created");
		return "Shirt";
	}
}
