package com.test;

import java.util.ArrayList;
import java.util.List;

public class SquarePresent {

	public static void main(String[] args) {
		System.out.println(leastNumSquarePresent(52));
		System.out.println(leastNumSquarePresent(2));
		System.out.println(leastNumSquarePresent(3));
		System.out.println(leastNumSquarePresent(4));
		System.out.println(leastNumSquarePresent(99));
	}
	
	public static List<Integer> leastNumSquarePresent(int N) {
		assert N >= 0;
		
		List<Integer>[] memo = new ArrayList[N+1];
		memo[0] = new ArrayList<>();
		memo[1] = new ArrayList<>();
		memo[1].add(1);
		for (int i = 2; i <= N; i++) {
			memo[i] = new ArrayList<>();
			List<Integer> previous = null;
			int curr = 0;
			int len = Integer.MAX_VALUE;
			int sr = (int) Math.sqrt(i);
			// Starting from square root can slightly improve performance.
			for (int j = sr; j >= 1; j--) {
				if (j * j == i) {
					curr = j;
					break;
				} else {
					if (memo[i - j * j].size() + 1 < len) {
						len = memo[i - j*j].size() + 1;
						previous = memo[i - j*j];
						curr = j;
					}
				}
			}
			
			if (previous != null) {
				memo[i].addAll(previous);
			}
			memo[i].add(curr);
		}
		
		return memo[N];
	}

}
