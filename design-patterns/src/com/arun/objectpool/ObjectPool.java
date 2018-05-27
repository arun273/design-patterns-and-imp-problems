package com.arun.objectpool;

import java.util.Enumeration;
import java.util.Hashtable;

//To Reuse the objects which are very costly to create.

/*Why to use it?

Basically, we'll use an object pool whenever there are several clients who 
needs the same stateless resource which is expensive to create. 
*/


public abstract class ObjectPool<T> {

	private long deadTime;

	private Hashtable<T, Long> lock, unlock;

	public ObjectPool() {
		deadTime = 50000; // 50 seconds
		lock = new Hashtable<T, Long>();
		unlock = new Hashtable<T, Long>();
	}

	public abstract T create();

	public abstract boolean validate(T o);

	public abstract void expire(T o);

	public synchronized T getObject() {
		long now = System.currentTimeMillis();
		T t;
		if (unlock.size() > 0) {
			Enumeration<T> e = unlock.keys();
			while (e.hasMoreElements()) {
				t = e.nextElement();
				if ((now - unlock.get(t)) > deadTime) {
					// object has deadd
					unlock.remove(t);
					expire(t);
					t = null;
				} else {
					if (validate(t)) {
						unlock.remove(t);
						lock.put(t, now);
						return (t);
					} else {
						// object failed validation
						unlock.remove(t);
						expire(t);
						t = null;
					}
				}
			}
		}
		// no objects available, create a new one
		t = create();
		lock.put(t, now);
		return (t);
	}

	public synchronized void releaseObject(T t) {
		lock.remove(t);
		unlock.put(t, System.currentTimeMillis());
	}
}
