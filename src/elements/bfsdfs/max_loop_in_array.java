/**
Given an array
Indexes 0 1 2 3 4
Values 3 2 1 4 0
Values are the next index of the jump 0 -> 3 -> 4 -> 0... 1 -> 2 -> 1...
Write a function to detect if there are loops. If yes, get the max length of the loop possible, otherwise just return zero.
 */
 
public class MaxLoop {

	public static void main(String[] args) {
		System.out.println(maxLoop(new int[] {1, 2, 3, 4, 0}));
		System.out.println(maxLoop(new int[] {3, 5, 1, 6, 2, 4, 0}));
		System.out.println(maxLoop(new int[] {2, 2, 2, 2}));
		System.out.println(maxLoop(new int[] {3, 2, 1, 4, 0}));
	}
	
	public static int maxLoop(int[] A) {
	    if (A == null || A.length == 0) return 0;
	    
	    int max = 0;
	    int[] visited = new int[A.length];
	    int[] length = new int[A.length];
	    for (int i = 0; i < A.length; i++) {
	        max = Math.max(max, helper(A, i, visited, length, 0));
	    }
	    
	    return max;
	}

	public static int helper(int[] A, int index, int[] visited, int[] length, int len) {
	    if (visited[index] == 1) return len - length[index]; // this is important!
	    
	    visited[index] = 1;
	    length[index] = len;
	    return helper(A, A[index], visited, length, len + 1);
	}

}