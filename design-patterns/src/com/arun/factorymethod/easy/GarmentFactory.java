/**
 * 
 */
package com.arun.factorymethod.easy;

/**
 * Factory Class for creating garments
 * 
 * @author Arun
 * 
 */
public class GarmentFactory extends Factory {
	public GarmentType createGarments(String selection) {
		if (selection.equalsIgnoreCase("Trouser")) {
			return new Trouser();
		} else if (selection.equalsIgnoreCase("Shirt")) {
			return new Shirt();
		}
		throw new IllegalArgumentException("Selection doesnot exist");
	}
}
