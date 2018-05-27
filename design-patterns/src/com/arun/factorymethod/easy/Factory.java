/**
 * 
 */
package com.arun.factorymethod.easy;

/**
 * Factory class is the abstract class which will be referred by client. All the
 * concrete classes needs to implement the abstract factory method.
 * 
 * @author Arun
 */
public abstract class Factory {
	protected abstract GarmentType createGarments(String selection);
}
