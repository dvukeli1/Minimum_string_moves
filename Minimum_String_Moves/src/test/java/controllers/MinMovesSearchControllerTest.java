package controllers;

import static org.junit.Assert.*;

import org.junit.Test;

public class MinMovesSearchControllerTest {

	String s11 = "aabaaaab";
	String s21 = "baaaaaba";
	int result1 = 3;
	
	
	@Test
	public void testString_mover1() {
		MinMovesInterface Minmoves =  new MinMovesSearchController();
		assertEquals("It Must be = ", result1 , Minmoves.String_mover(s11, s21));
		
	}
	
	String s12 = "caaaaaaaab";
	String s22 = "cbaaaaaaaa";
	int result2 = 3;
	
	@Test
	public void testString_mover2() {
		MinMovesInterface Minmoves =  new MinMovesSearchController();
		assertEquals("It Must be = ", result2 , Minmoves.String_mover(s12, s22));
		
	}
	
	String s13 = "aaaaaaaaab";
	String s23 = "abaaaaaaaa";
	int result3 = 2;
	

	@Test
	public void testString_mover3() {
		MinMovesInterface Minmoves =  new MinMovesSearchController();
		assertEquals("It Must be = ", result3 , Minmoves.String_mover(s13, s23));
		
	}
	
	String s14 = "banana";
	String s24 = "nanbaa";
	int result4 = 4;
	

	@Test
	public void testString_mover4() {
		MinMovesInterface Minmoves =  new MinMovesSearchController();
		assertEquals("It Must be = ", result4 , Minmoves.String_mover(s14, s24));
		
	}
	
	
	
	
	
	String s15 = "mfrhinffffjospriilft";
	String s25 = "rponffsffijhmfilfitr";
	int result5 = 52;
	
	@Test
	public void testString_mover5() {
		MinMovesInterface Minmoves =  new MinMovesSearchController();
		assertEquals("It Must be = ", result5 , Minmoves.String_mover(s15, s25));
		
	}
}
