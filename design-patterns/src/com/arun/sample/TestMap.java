package com.arun.sample;

import java.util.HashMap;
import java.util.Map;

public class TestMap {

	public static void main(String[] args) {

		Map<PersonTest, Integer> map = new HashMap<>();

		for (int i = 1; i <= 25; i++) {

			int x=1;
			map.put(new PersonTest(x, "i"), i);
		}

		System.out.println("Map Size: " + map.size());
	}

}

class PersonTest {

	private int id;
	private String name;

	public PersonTest(int id, String name) {

		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
//		final int prime = 31;
		int result = 1;
//		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonTest other = (PersonTest) obj;
		if (id != other.id)
			return false;
		return true;
	}

}