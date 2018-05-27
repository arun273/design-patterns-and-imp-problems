/**
 * 
 */
package com.arun.abstractfactory.easy;

/**
 * @author Arun
 * 
 */
public class Laptop implements GadgetType {

	@Override
	public String print() {
		System.out.println("Laptop Created");
		return "Laptop";
	}

}
