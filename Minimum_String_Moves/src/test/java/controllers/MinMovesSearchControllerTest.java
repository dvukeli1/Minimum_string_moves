package controllers;

import static org.junit.Assert.*;

import org.junit.Test;

public class MinMovesSearchControllerTest {
	
	/**
	 * First simple test
	 */
	
	String s10 = "aab";
	String s20 = "baa";
	int result0 = 1;
	
	@Test
	public void firstSimpleTest(){
		MinMovesInterface Minmoves =  new MinMovesSearchController();
		assertEquals("It Must be = ", result0 , Minmoves.String_mover(s10, s20));
		
	}

	/**
	 * Greedy algorithm starts from first char and in one direction counts 5 swaps ( 3 is correct)  in both 
	 * directions if direction of swap gives priority to right swap if char index is less then 
	 * half of string length.
	 */
	
	
	String s11 = "aabaaaab";
	String s21 = "baaaaaba";
	int result1 = 3;
	
	
	@Test
	public void priorityDirectionCharSwapTest() {
		MinMovesInterface Minmoves =  new MinMovesSearchController();
		assertEquals("It Must be = ", result1 , Minmoves.String_mover(s11, s21));
		
	}
	
	/**
	 *  Opposite from diferenceA_BStringMovesTest()
	 */
	
	String s12 = "banana";
	String s22 = "nanbaa";
	int result2 = 4;
	
	@Test
	public void oppositePriorityDirectionCharSwapTest() {
		MinMovesInterface Minmoves =  new MinMovesSearchController();
		assertEquals("It Must be = ", result2 , Minmoves.String_mover(s12, s22));
		
	}
	
	/**
	 * Test greedy algorithm - shortest is better
	 */
	
	String s13 = "aaaaaaaaab";
	String s23 = "abaaaaaaaa";
	int result3 = 2;
	

	@Test
	public void anotherSimpleGreedyAlgorithmTest() {
		MinMovesInterface Minmoves =  new MinMovesSearchController();
		assertEquals("It Must be = ", result3 , Minmoves.String_mover(s13, s23));
		
	}
	
	
	/**
	 * Test 
	 * if (correctCharIndex.isEmpty()
							|| !correctCharIndex.contains(swapIndex)) {
						correctCharIndex.add(swapIndex);
					} else {
						if (workingString.charAt(charIndex) != inputString2
								.charAt(charIndex))
							charIndex = workingString.length() - 1;

					}
	 */
	
	
	String s14 = "caaaaaaaab";
	String s24 = "cbaaaaaaaa";
	int result4 = 3;
	
	
	@Test
	public void ruinedCorrectCharPositionTest() {
		MinMovesInterface Minmoves =  new MinMovesSearchController();
		assertEquals("It Must be = ", result4 , Minmoves.String_mover(s14, s24));
		
	}
		
	/**
	 * Simple performace test - result is not confirmed on whiteboard !!
	 */
	
	String s15 = "mfrhinffffjospriilft";
	String s25 = "rponffsffijhmfilfitr";
	int result5 = 52;
	
	
	@Test
	public void someRandomLetterPerformaceTest() {
		MinMovesInterface Minmoves =  new MinMovesSearchController();
		assertEquals("It Must be = ", result5 , Minmoves.String_mover(s15, s25));
		
	}
}
