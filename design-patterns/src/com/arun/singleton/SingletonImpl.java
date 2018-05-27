package com.arun.singleton;

import java.io.Serializable;

public class SingletonImpl implements Cloneable, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8088279408373912206L;
	private static volatile SingletonImpl instance = null;

	private SingletonImpl() {
		if (instance != null) {
			throw new InstantiationError("Error creating class");
		}
	}

	public static SingletonImpl getInstance() {

		if (null == instance) {
			synchronized (SingletonImpl.class) {
				if (null == instance) {
					instance = new SingletonImpl();
				}
			}

		}
		return instance;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return instance;
	};

	public Object readResolve() {
		return SingletonImpl.getInstance(); //
	}
}
