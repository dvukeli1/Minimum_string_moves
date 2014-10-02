Minimum_string_moves
====================

We have two strings A and B with the same super set of characters. We need to change these strings to obtain two equal strings. In each move we can perform one of the following operations:

  1- swap two consecutive characters of a string
  2- swap the first and the last characters of a string


A move can be performed on either string.
What is the minimum number of moves that we need in order to obtain two equal strings?
Input Format and Constraints:
The first and the second line of the input contains two strings A and B. It is guaranteed that the superset their characters are equal.
1 <= length(A) = length(B) <= 2000
All the input characters are between 'a' and 'z'
 

Output Format:
Print the minimum number of moves to the only line of the output

 

Sample input:
aab
baa


Sample output:
1
 

Explanation:
Swap the first and last character of the string aab to convert it to baa. The two strings are now equal.
