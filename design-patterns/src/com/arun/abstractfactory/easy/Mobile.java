/**
 * 
 */
package com.arun.abstractfactory.easy;

/**
 * @author Arun
 *
 */
public class Mobile implements GadgetType {

	@Override
	public String print() {
		System.out.println("Mobile Created");
		return "Mobile";
	}

}
