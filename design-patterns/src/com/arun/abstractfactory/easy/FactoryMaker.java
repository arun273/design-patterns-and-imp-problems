/**
 * 
 */
package com.arun.abstractfactory.easy;

/**
 * @author Arun
 *
 */
public class FactoryMaker {
 private static RetailFactory abstractFactory = null;
 static RetailFactory getFactory(String choice){
	if(choice.equalsIgnoreCase("UK")){
		abstractFactory = new UKFactory();
	} else if(choice.equalsIgnoreCase("US")){
		abstractFactory = new USFactory();
	}
	return abstractFactory;
 }
  
}
