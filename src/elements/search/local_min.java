/**
 * Find local min in an array - a local min is any A[i] that meets A[i-1] > A[i-1] && A[i+1] > A[i]
 * Nieghbors will always have different values.
 */
 
public class LocalMin {

	public static void main(String[] args) {
		System.out.println(findLocalMin(new int[] {1, 3, 2, 20, 50, 9, 8, 5, 6}, 0, 8));
		System.out.println(findLocalMin(new int[] {1, 2, 3, 4, 5}, 0, 4));
	}
	
	public static int findLocalMin(int[] A, int s, int e) {
	    if (s == e) return s;
	    
	    int m = (s + e) / 2;
	    
	    if ((m - 1 < s || A[m] < A[m-1]) && (m + 1 > e || A[m+1] > A[m]))
	        return m;
	    else if (m - 1 < s || (m + 1 <= e && A[m] >= A[m+1])) {
	        return findLocalMin(A, m + 1, e);
	    } else {
	        return findLocalMin(A, s, m - 1);
	    }
	}

}
