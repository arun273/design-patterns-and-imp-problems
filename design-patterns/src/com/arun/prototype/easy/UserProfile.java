/**
 * 
 */
package com.arun.prototype.easy;

/**
 * This is the Prototype design pattern example. The UserProfile class will be
 * cloned.
 * 
 * @author Arun
 * 
 */
public class UserProfile implements Cloneable {
	private String name;

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	/*
	 * This method creates and return the copy of the super class.
	 */
	public Object clone() {
		Object clone = null;
		try {
			clone = super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return clone;

	}

}
