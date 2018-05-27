/**
 * 
 */
package com.arun.abstractfactory.easy;

/**
 * Factory class is the abstract class which will be referred by client. All the
 * concrete classes needs to implement the abstract factory method.
 * 
 * @author Arun
 */
public interface RetailFactory {
	GarmentType createGarments(String garmentSelection);

	GadgetType createGadgets(String gadgetSelection);
}
