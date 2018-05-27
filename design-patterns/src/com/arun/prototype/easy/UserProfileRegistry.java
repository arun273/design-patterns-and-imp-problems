/**
 * 
 */
package com.arun.prototype.easy;

import java.util.Hashtable;

/**
 * This class finds appropriate UserProfile object and then returns the clone
 * 
 * @author Arun
 *
 */
public class UserProfileRegistry {
	private static Hashtable<String, UserProfile> profileMap = new Hashtable<String, UserProfile>();

	// Get the profile data from client and return cloned object
	public static UserProfile getProfile(String profileData) {
		UserProfile cachedProfile = (UserProfile) profileMap.get(profileData);
		return (UserProfile) cachedProfile.clone();
	}

	/**
	 * This method currently creates two Profile objects - Identity and Bank
	 * account For each Profile object it might be an expensive query run, in
	 * case the calls are related to Database query. So run this query and
	 * instantiate and keep the details into the profileMap for later cloning.
	 */
	public static void loadCache() {
		// First copy of the object Identity(UserProfile) is created.
		// Only after this the cloning can be done.
		Identity identity = new Identity();
		identity.setName("Charles Keating");
		identity.setDob("01-Jan-1900");
		profileMap.put(identity.getName(), identity);
		// First copy of the object Bankline(UserProfile) is created.
		// Only after this the cloning can be done.
		BankDetails bankDetails = new BankDetails();
		bankDetails.setName("Idiotechie");
		bankDetails.setBankAccount(1234567890);
		profileMap.put(bankDetails.getName(), bankDetails);
	}
}
