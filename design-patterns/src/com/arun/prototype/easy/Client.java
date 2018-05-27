/**
 * 
 */
package com.arun.prototype.easy;

/**
 * This is the client class which will access ProfileRegistry
 * @author Arun
 *
 */
public class Client {
 public static void main(String args[]){
	 UserProfileRegistry.loadCache();
	 //Client needs a new UserProfile object through getProfile() method
	 Identity clonedIdentity = (Identity) UserProfileRegistry.getProfile("Charles Keating");
	 System.out.println("UserProfile as cloned Identity");
	 System.out.println("Name:"+clonedIdentity.getName());
	 System.out.println("Date of Birth:"+clonedIdentity.getDob());
	 BankDetails clonedBankDetails = (BankDetails) UserProfileRegistry.getProfile("Idiotechie");
	 System.out.println("UserProfile as cloned BankDetail");
	 System.out.println("Name:"+clonedBankDetails.getName());
	 System.out.println("Bank Account Details:"+clonedBankDetails.getBankAccount());
 }
}
