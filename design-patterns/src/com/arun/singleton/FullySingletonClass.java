package com.arun.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;

public class FullySingletonClass {

	public static void main(String[] args) throws Exception {

		SingletonImpl object1 = SingletonImpl.getInstance();
		System.out.println("Object1:" + object1);
		SingletonImpl object3 = (SingletonImpl) object1.clone();
		System.out.println("Object3:" + object3);

		try {
			FileOutputStream fos = new FileOutputStream("abc.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(object1);
			FileInputStream fis = new FileInputStream("abc.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			SingletonImpl object2 = (SingletonImpl) ois.readObject();
			System.out.println("Object2" + object2);

		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Constructor[] constructors = SingletonImpl.class.getDeclaredConstructors();
			for (Constructor<SingletonImpl> constructor : constructors) {
				// Below code will not destroy the singleton pattern
				constructor.setAccessible(true);
				SingletonImpl Object3 = (SingletonImpl) constructor.newInstance();
				System.out.println("Object3: Break through Reflection:" + Object3);
				break;
			}
		} catch (Exception ew) {
			ew.printStackTrace();

		}

	}
}
