package com.arun.abstractfactory.easy;

/**
 * Concrete Class implementing GarmentType
 * 
 * @author Arun
 * 
 */
public class Trouser implements GarmentType {
	@Override
	public String print() {
		System.out.println("Trouser Created");
		return "Trouser";
	}

}
