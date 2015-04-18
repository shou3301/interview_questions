/**
 * Google: Wiggle sort
 */
public class WiggleSort {
	
	public static void wiggleSort(int[] A) {
	    if (A == null || A.length == 0) return;
	    
	    boolean smallFirst = true;
	    for (int i = 0; i < A.length - 1; i++) {
	        if ((smallFirst && A[i] > A[i+1]) || (!smallFirst && A[i] < A[i+1])) {
	        	swap(A, i, i+1);
	        }
	        smallFirst = !smallFirst;
	    }
	}
	
	private static void swap(int[] A, int i, int j) {
		int tmp = A[i];
		A[i] = A[j];
		A[j] = tmp;
	}

}