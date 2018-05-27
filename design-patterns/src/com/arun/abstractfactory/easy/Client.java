package com.arun.abstractfactory.easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.sun.imageio.plugins.common.InputStreamAdapter;

/**
 * Consumer class for getting garments
 * 
 * @author Arun
 * 
 */
public class Client {

	public static void main(String[] args) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String garmentSelection = null;
		String gadgetSelection = null;
		String countryChoice = null;
		try {
			System.out.println("1. Enter your selection from Trouser/Shirt:\n");
			garmentSelection = br.readLine();
			System.out.println("2. Enter your selection from Laptop/Mobile:\n");
			gadgetSelection = br.readLine();
			System.out.println("3. Enter your Country Selection from UK/US:\n");
			countryChoice = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}

		RetailFactory objRetailFactory = FactoryMaker.getFactory(countryChoice);
		System.out.println("Your choice of country is " + countryChoice);
		GarmentType objGarmentType = objRetailFactory.createGarments(garmentSelection);
		System.out.println(objGarmentType.print());
		GadgetType objGadgetType = objRetailFactory.createGadgets(gadgetSelection);
		System.out.println(objGadgetType.print());

	}

}
