/**
 * Given a sequence of N numbers - A[1] , A[2] , ..., A[N] . Find the length of
 * the longest non-decreasing sequence. 
 * e.g: 
 * Input: 5, 3, 4, 8, 6, 7 LNDS: 4
 * (3,4,6,7)
 * 
 * @author chandershivdasani
 * 
 */
public class LongestNonDecreasingSubsequence {
	
	/*
	 * The complexity of this algorithm is O(n*n)
	 */
	public static int compute(int input[]) {
		/*
		 * lcns[i] represents length of longest subsequence 
		 * ending at i, that includes i
		 */
		int[] lcns = new int[input.length];
		int max = 0;
		lcns[0] = 1;
		for (int i = 1; i < input.length; i++) {
			lcns[i] = 1;
			for(int j=0; j<i; j++) {
				if(input[i] > input[j]) {
					if(lcns[i] < lcns[j] + 1) {
						lcns[i] = lcns[j] + 1;
					}
				}
			}
			if(lcns[i] > max) 
				max = lcns[i];
		}
		return max;
	}
	
	public static void main(String[] args) {
		System.out.println(compute(new int[]{5,3,4,8,6,7}));
	}
}
