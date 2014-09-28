/**
 * 
 */
package controllers;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mitja
 *
 */
public class MinMovesSearchController implements MinMovesInterface {
	static String inputString1;
	static String inputString2;
	static String sSwap;
	static int movesTest1 = 0;
	static int movesTest2 = 0;
	static int trys = 0;
	static List<Integer> correctCharIndex = new ArrayList<Integer>();

	public int String_mover(String s1, String s2) {

		inputString1 = s1;
		inputString2 = s2;

		int charIndex = 0;
		int swapIndex = 0;
		int swapIndex1 = 0;
		int minSwapsL = 0;
		int minSwapsR = 0;
		int swapsNumber = 0;
		int lastFindIndex = 0;
		int firstFindIndex = 0;
		int toLeftFirstIndex = 0;
		int toLeftLastIndex = 0;
		int toRightFirstIndex = 0;
		int toRightLastIndex = 0;
		int tempMoves = 0;
		String workingString = "";
		boolean leftswap = true;

		trys++;

		for (int i = 0; i < inputString1.length() - 1; i++) {
			if (inputString1.charAt(i) == inputString2.charAt(i)) {
				if (correctCharIndex.isEmpty() || !correctCharIndex.contains(i)) {
					correctCharIndex.add(i);
				}
			}
		}

		/**
		 * swaps strings in 2nd and 4th iteration
		 */
		if (trys == 2 || trys == 4) {
			sSwap = inputString1;
			inputString1 = inputString2;
			inputString2 = sSwap;
		}

		workingString = inputString1;

		while (!workingString.equals(inputString2)) {

			/**
			 * calculate shortest way (swap number) for char swaps using reverse greedy
			 * algorithm (start from index 0 and calculate shortest way)
			 */
			
			firstFindIndex = workingString.indexOf(
					inputString2.charAt(charIndex), charIndex);
			lastFindIndex = workingString.lastIndexOf(
					inputString2.charAt(charIndex), inputString2.length() - 1);

			toLeftFirstIndex = firstFindIndex - charIndex;
			toLeftLastIndex = lastFindIndex - charIndex;

			minSwapsL = Math.abs(toLeftFirstIndex);

			if (minSwapsL > Math.abs(toLeftLastIndex)) {
				minSwapsL = Math.abs(toLeftLastIndex);
			}
			toRightFirstIndex = charIndex
					+ (workingString.length() - firstFindIndex);
			toRightLastIndex = charIndex
					+ (workingString.length() - lastFindIndex);

			if (toRightFirstIndex >= workingString.length()) {
				toRightFirstIndex = toRightFirstIndex - workingString.length();
			}
			if (toRightLastIndex >= workingString.length()) {
				toRightLastIndex = toRightLastIndex - workingString.length();
			}

			minSwapsR = Math.abs(toRightFirstIndex);

			if (minSwapsR > Math.abs(toRightLastIndex)) {
				minSwapsR = Math.abs(toRightLastIndex);
			}

			/**
			 * decides left or right swap and pick first index and
			 * "first neighbor" index. 
			 * On 1st and 2nd iteration prefers right swap 
			 * if swap number are equal in both ways and 
			 * index is less then half of length, 
			 * and on 3th and 4th prefers left swap
			 */
			if (charIndex < workingString.length() / 2
					&& (trys == 1 || trys == 2)) {
				if (minSwapsL < minSwapsR) {

					swapsNumber = minSwapsL;
					swapIndex = firstFindIndex;
					leftswap = true;

					if (swapIndex < 0) {
						swapIndex = swapIndex + workingString.length();
					}

					swapIndex1 = swapIndex - 1;

					if (swapIndex1 < 0) {
						swapIndex1 = swapIndex1 + workingString.length();
					}

				} else {
					swapsNumber = minSwapsR;
					swapIndex = lastFindIndex;
					leftswap = false;

					if (swapIndex > workingString.length() - 1) {
						swapIndex = swapIndex - workingString.length();
					}
					if (swapIndex < 0) {
						swapIndex = swapIndex + workingString.length();
					}

					swapIndex1 = swapIndex + 1;
					if (swapIndex1 > workingString.length() - 1) {
						swapIndex1 = swapIndex1 - workingString.length();
					}
					if (swapIndex1 < 0) {
						swapIndex1 = swapIndex1 + workingString.length();
					}

				}
			} else if (charIndex < workingString.length() / 2
					&& (trys == 3 || trys == 4)) {
				if (minSwapsL <= minSwapsR) {

					swapsNumber = minSwapsL;
					swapIndex = firstFindIndex;
					leftswap = true;

					if (swapIndex < 0) {
						swapIndex = swapIndex + workingString.length();
					}

					swapIndex1 = swapIndex - 1;

					if (swapIndex1 < 0) {
						swapIndex1 = swapIndex1 + workingString.length();
					}

				} else {
					swapsNumber = minSwapsR;
					swapIndex = lastFindIndex;
					leftswap = false;
					if (swapIndex > workingString.length() - 1) {
						swapIndex = swapIndex - workingString.length();
					}
					if (swapIndex < 0) {
						swapIndex = swapIndex + workingString.length();
					}

					swapIndex1 = swapIndex + 1;
					if (swapIndex1 > workingString.length() - 1) {
						swapIndex1 = swapIndex1 - workingString.length();
					}
					if (swapIndex1 < 0) {
						swapIndex1 = swapIndex1 + workingString.length();
					}
				}
			}

			else {
				if (minSwapsL < minSwapsR) {
					swapsNumber = minSwapsL;
					swapIndex = firstFindIndex;
					leftswap = true;

					if (swapIndex < 0) {
						swapIndex = swapIndex + workingString.length();
					}

					swapIndex1 = swapIndex - 1;
					if (swapIndex1 < 0) {
						swapIndex1 = swapIndex1 + workingString.length();
					}

				} else {
					swapsNumber = minSwapsR;
					swapIndex = lastFindIndex;
					leftswap = false;
					if (swapIndex > workingString.length() - 1) {
						swapIndex = swapIndex - workingString.length();
					}
					if (swapIndex < 0) {
						swapIndex = swapIndex + workingString.length();
					}
					swapIndex1 = swapIndex + 1;
					if (swapIndex1 > workingString.length() - 1) {
						swapIndex1 = swapIndex1 - workingString.length();
					}
					if (swapIndex1 < 0) {
						swapIndex1 = swapIndex1 + workingString.length();
					}

				}

			}

			swapsNumber = Math.abs(swapsNumber);

			/**
			 * Swap characters
			 */
			if (swapsNumber > 0) {

				for (int swap = 0; swap < swapsNumber; swap++) {
					if (trys > 1 && tempMoves >= movesTest1) {
						break;
					}
					char tempSwich[] = workingString.toCharArray();
					char ch1 = tempSwich[swapIndex];
					char ch2 = tempSwich[swapIndex1];
					tempSwich[swapIndex] = ch2;
					tempSwich[swapIndex1] = ch1;
					workingString = String.valueOf(tempSwich);
					tempMoves++;

					if (leftswap) {
						swapIndex--;
						if (swapIndex < 0) {
							swapIndex = swapIndex + workingString.length();
						}
						swapIndex1 = swapIndex - 1;
						if (swapIndex1 < 0) {
							swapIndex1 = workingString.length() + swapIndex1;
						}
					} else {
						swapIndex++;
						if (swapIndex > workingString.length() - 1) {
							swapIndex = swapIndex - workingString.length();
						}
						swapIndex1 = swapIndex + 1;
						if (swapIndex1 > workingString.length() - 1) {
							swapIndex1 = swapIndex1 - workingString.length();
						}
					}
					
					/**
					 * checks if char swap move previously correct positioned char and
					 * correct it by setting index to that char
					 * @see testString_mover2() - result is 3, without this result will be 5
					 */
					
					if (correctCharIndex.isEmpty()
							|| !correctCharIndex.contains(swapIndex)) {
						correctCharIndex.add(swapIndex);
					} else {
						if (workingString.charAt(charIndex) != inputString2
								.charAt(charIndex))
							charIndex = workingString.length() - 1;

					}

				}

				if (charIndex < workingString.length() - 1) {
					charIndex++;
				} else {
					charIndex = 0;
				}

			} else {
				if (correctCharIndex.isEmpty()
						|| !correctCharIndex.contains(swapIndex)) {
					correctCharIndex.add(swapIndex);
				}
				if (charIndex < workingString.length() - 1) {
					charIndex++;
				} else {
					charIndex = 0;
				}

			}
			if (trys > 1 && tempMoves >= movesTest1) {
				break;
			}
		}
		/**
		 * memorize minimum moves from iterations
		 */
		if (trys == 1 || trys < 4) {

			movesTest1 = tempMoves;
			movesTest2 = String_mover(inputString1, inputString2);

			if (movesTest2 < movesTest1) {
				movesTest1 = movesTest2;
			}

			tempMoves = movesTest1;

		}
		correctCharIndex.clear();

		trys = 0;

		return tempMoves;
	}

}
