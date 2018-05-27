/**
 * 
 */
package com.arun.abstractfactory.easy;

/**
 * Factory Class for creating garments
 * 
 * @author Arun
 * 
 */
public class UKFactory implements RetailFactory{
	public  GarmentType createGarments(String garmentSelection) {
		if (garmentSelection.equalsIgnoreCase("Trouser")) {
			return new Trouser();
		} 
		throw new IllegalArgumentException("Selection doesnot exist");
	}

	
	public GadgetType createGadgets(String gadgetSelection) {
		if (gadgetSelection.equalsIgnoreCase("Mobile")) {
			return new Mobile();
		}
		throw new IllegalArgumentException("Selection doesnot exist");
	}
}
