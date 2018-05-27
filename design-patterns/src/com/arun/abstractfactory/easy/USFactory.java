/**
 * 
 */
package com.arun.abstractfactory.easy;

/**
 * @author Arun
 *
 */
public class USFactory implements RetailFactory {
	public GarmentType createGarments(String garmentSelection) {
		if (garmentSelection.equalsIgnoreCase("Shirt")) {
			return new Shirt();
		}
		throw new IllegalArgumentException("Selection doesnot exist");
	}

	public GadgetType createGadgets(String gadgetSelection) {
		if (gadgetSelection.equalsIgnoreCase("Laptop")) {
			return new Laptop();
		}
		throw new IllegalArgumentException("Selection doesnot exist");
	}
}
