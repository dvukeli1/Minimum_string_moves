package view;

import static org.junit.Assert.*;

import org.junit.Test;

public class MainTest {

	String s = "adfsdrfgt";
	String s1= "4drfe!r&";
	
	@Test
	public void testStringAlfabet() {
		assertEquals("Must be ", true, Main.testString(s));
	}

	@Test
	public void testStringNumbers() {
		assertEquals("Must be ", false, Main.testString(s1));
	}
}
