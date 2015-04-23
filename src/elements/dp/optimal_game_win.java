/**
 * Optimal strategy for a game.
 Problem statement: Consider a row of n coins of values v1 . . . vn, 
 where n is even. We play a game against an opponent by alternating turns. 
 In each turn, a player selects either the first or last coin from the row, 
 removes it from the row permanently, 
 and receives the value of the coin. Determine the maximum possible amount 
 of money we can definitely win if we move first.
 */
 
public class OptimalGame {

	public static void main(String[] args) {
		System.out.println(maxWin(new int[] {8, 15, 3, 7}));
		System.out.println(maxWin(new int[] {2, 2, 2, 2}));
		System.out.println(maxWin(new int[] {20, 30, 2, 2, 2, 10}));
	}
	
	public static int maxWin(int[] vals) {
	    int[][] record = new int[vals.length][vals.length];
	    
	    for (int gap = 1; gap < vals.length; gap += 2) {
	        for (int i = 0; i < vals.length - gap; i++) {
	            if(gap == 1) {
	                record[i][i+gap] = Math.max(vals[i], vals[i+1]);
	            } else {
	                record[i][i+gap] = Math.max(vals[i] + Math.min(record[i+1][i+gap-1], record[i+2][i+gap]), 
	                    vals[i+gap] + Math.min(record[i+1][i+gap-1], record[i][i+gap-2]));
	            }
	        }
	    }
	    
	    return record[0][vals.length - 1];
	}

}