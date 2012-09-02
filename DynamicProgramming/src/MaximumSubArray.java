/**
 * The maximum subarray problem is the task of finding the contiguous subarray
 * within a one-dimensional array of numbers (containing at least one positive
 * number) which has the largest sum.
 * 
 * 
 * e.g { -2, 1, -3, 4, -1, 2, 1, -5, 4} ->  4, -1, 2, 1 with sum 6
 * 
 * @author chandershivdasani
 * 
 */
public class MaximumSubArray {
	
	public static int compute(int input[]) {
		int maxCurrent;
		int maxSoFar;
		maxSoFar = maxCurrent = 0;
		
		for(int i=0; i < input.length; i++) {
			maxCurrent = Math.max(input[i], maxCurrent + input[i]);
			maxSoFar = Math.max(maxSoFar, maxCurrent);
		}
		return maxSoFar;
	}
	
	public static void main(String[] args) {
		int[] input = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
		System.out.println(compute(input));
	}

}
