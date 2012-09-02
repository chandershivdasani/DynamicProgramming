/**
 * Given two strings, find a longest common subsequence(LCS). An LCS for two
 * strings is not unique. e.g: {A,G,C,A,T} and {G,A,C} LCS = {A,C}, {G,C} or
 * {G,A}
 * 
 * Naive approach: Test each subsequence of first string and check whether it is
 * a subsequence of the second sequence. Complexity: O(2^n) because for a given
 * sequence, there are 2^n subsequences
 * 
 * Dynamic programming: The detailed explaination of my approach is explained
 * here: http://en.wikipedia.org/wiki/Longest_common_subsequence_problem
 * 
 * 
 * @author chandershivdasani
 * 
 */
public class LongestCommonSubsequence {

	public static String computeLCS(char[] input1, char[] input2) {

		int[][] lcs = new int[input1.length + 1][input2.length + 1];

		for (int i = 0; i < input1.length; i++) {
			lcs[i][0] = 0;
		}
		for (int i = 0; i < input2.length; i++) {
			lcs[0][i] = 0;
		}

		// Compute the lcs matrix
		for (int i = 1; i <= input1.length; i++) {
			for (int j = 1; j <= input2.length; j++) {
				if (input1[i - 1] == input2[j - 1]) {
					lcs[i][j] = lcs[i - 1][j - 1] + 1;
				} else {
					lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
				}
			}
		}

		System.out.println("Length of LCS: "
				+ lcs[input1.length][input2.length]);

		// Recover the string
		int i = input1.length, j = input2.length;
		StringBuilder lcsVal = new StringBuilder();

		while (i > 0 && j > 0) {
			if (input1[i - 1] == input2[j - 1]) {
				lcsVal.append(input1[i - 1]);
				i--;
				j--;
			} else if (lcs[i][j - 1] >= lcs[i - 1][j])
				j--;
			else
				i--;
		}
		return reverse(lcsVal.toString());
	}

	public static String reverse(String input) {
		char[] inputChars = input.toCharArray();
		char temp;
		int len = input.length();
		
		for (int i = 0; i < len / 2; i++) {
			temp = inputChars[i];
			inputChars[i] = inputChars[len - i -1];
			inputChars[len - i -1] = temp;
		}
		
		return new String(inputChars);
	}

	public static void main(String[] args) {
		String a = "chander";
		String b = "chanderssss";

		System.out.println("LCS: "
				+ computeLCS(a.toCharArray(), b.toCharArray()));
	}
}
