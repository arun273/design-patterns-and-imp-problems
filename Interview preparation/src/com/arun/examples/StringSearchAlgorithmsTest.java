package com.arun.examples;

import org.junit.Assert;
import org.junit.Test;

public class StringSearchAlgorithmsTest {

	@Test
	public void testStringSearchAlgorithms() {
		String text = "This is some nice text.";
		String pattern = "some";

		int realPosition = text.indexOf(pattern);
		Assert.assertTrue(
				realPosition == StringSearchAlgorithms.simpleTextSearch(pattern.toCharArray(), text.toCharArray()));
		Assert.assertTrue(
				realPosition == StringSearchAlgorithms.RabinKarpMethod(pattern.toCharArray(), text.toCharArray()));
		Assert.assertTrue(realPosition == StringSearchAlgorithms.KnuthMorrisPrattSearch(pattern.toCharArray(),
				text.toCharArray()));
		Assert.assertTrue(realPosition == StringSearchAlgorithms.BoyerMooreHorspoolSimpleSearch(pattern.toCharArray(),
				text.toCharArray()));
		Assert.assertTrue(realPosition == StringSearchAlgorithms.BoyerMooreHorspoolSearch(pattern.toCharArray(),
				text.toCharArray()));
	}

}
