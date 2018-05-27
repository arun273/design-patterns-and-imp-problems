package com.arun.singleton;

import java.lang.reflect.ReflectPermission;
import java.security.AccessController;
import java.security.PrivilegedAction;

public class JavaSingleton {

	private static JavaSingleton INSTANCE = null;
	private static int count = 0;

	private JavaSingleton() {
		ReflectPermission perm = new ReflectPermission("suppressAccessChecks", "");
		AccessController.checkPermission(perm);
		++count;
		System.out.println("Singleton Constructor Running. Instance #" + count);
	}

	synchronized public static final JavaSingleton getInstance() {
		if (INSTANCE == null) {
			AccessController.doPrivileged(new PrivilegedAction<Object>() {
				public Object run() {
					INSTANCE = new JavaSingleton();
					return null;
				}
			});
		}
		return INSTANCE;
	}
}
