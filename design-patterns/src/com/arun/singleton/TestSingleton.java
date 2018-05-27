package com.arun.singleton;

import java.lang.reflect.Constructor;

public class TestSingleton {

	public static void main(String[] args) throws ReflectiveOperationException {
		System.out.println("Using getInstance...");
		JavaSingleton s = JavaSingleton.getInstance();

		System.out.println("Trying to use reflection to instantiate Java Singleton...");
		Class<JavaSingleton> clazz = JavaSingleton.class;
		Constructor<JavaSingleton> cons = clazz.getDeclaredConstructor();
		cons.setAccessible(true);
		JavaSingleton s2 = cons.newInstance();
	}// end of main

}
