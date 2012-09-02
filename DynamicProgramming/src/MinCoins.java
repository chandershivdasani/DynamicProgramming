/**
 * Given a list of N coins, their values (V1, V2, ... , VN), and the total sum
 * S. Find the minimum number of coins the sum of which is S (we can use as many
 * coins of one type as we want), or report that it's not possible to select
 * coins in such a way that they sum up to S.
 * 
 * Time Complexity: O(n)
 * @author chandershivdasani
 * 
 */
public class MinCoins {

	/*
	 * We can start by finding solutions to smaller problems, i.e for values of
	 * i < sum. The initial state would be minimum number of coins to represent
	 * 0, which is 0. We then move to finding min solution for sum 1 and so on
	 */
	public static int compute(int[] coins, int sum) {
		int[] result = new int[sum+1];

		for (int i = 0; i <= sum; i++)
			result[i] = Integer.MAX_VALUE;
		
		//Starting state
		result[0] = 0;

		for (int i = 1; i <= sum; i++) {
			
			for (int j = 0; j < coins.length; j++) {
				
				//Ignore the coins with denomination > sum
				if(coins[j] <= i && (result[i - coins[j]] + 1 < result[i])) {
					result[i] = result[i - coins[j]] + 1;
				}
			}
		}

		return result[sum];

	}
	
	public static void main(String[] args) {
		int[] coins = {1,3,5};
		System.out.println(compute(coins, 25));
	}
}
