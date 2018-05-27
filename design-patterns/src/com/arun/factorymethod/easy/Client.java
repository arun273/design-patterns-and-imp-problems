package com.arun.factorymethod.easy;

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
		System.out.println("Enter your selection:");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String selection = null;
		try {
			selection = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Factory factory = new GarmentFactory();
		GarmentType objGarmentType = factory.createGarments(selection);
		System.out.println(objGarmentType.print());

	}

}
