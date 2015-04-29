/*
Search Missing Numbers

A sorted array contains integers from 1..n with m of them missing. Find all missing numbers.

Example:
n = 8 , m = 2
arr = [1,2,4,5,6,8]
Result has to be {3, 7}.
*/

public class MissingNumbers {

	public static void main(String[] args) {
		System.out.println(findMissingNumbers(new int[] {1, 2, 4, 6}, 2));
		System.out.println(findMissingNumbers(new int[] {2, 4, 6}, 3));
		System.out.println(findMissingNumbers(new int[] {1, 2, 4}, 3));
	}
	
	public static List<Integer> findMissingNumbers(int[] A, int missing) {
	    List<Integer> res = new ArrayList<>();
	    
	    if (missing == 0) return res;
	    
	    int n = A.length + missing;
	    
	    binarySearch(A, 0, A.length - 1, n, res);
	    
	    return res;
	}

	public static void binarySearch(int[] A, int s, int e, int n, List<Integer> res) {
	    if (s > e) return;
	    
	    int m = (s + e) / 2;
	    
	    /**
	     * The idea here is split the array into [s->m-1] [m] [m+1->e]
	     * Find the missing numbers from A[s-1] to A[s]
	     * Find the missing numbers from A[m-1] to A[m]
	     * Find the missing numbers from A[m] to A[m+1]
	     * Find the missing numbers from A[e] to A[e+1]
	     * 
	     * The reason we don't do [s->m] and [m+1->e] is to avoid re-count
	     * missing numbers between A[m] and A[m+1].
	     */
	    
	    if (m == s || A[m-1] - A[s] == m - 1 - s) {
	        int pre = s == 0 ? 1 : A[s - 1] + 1;
	        for (int i = pre; i < A[s]; i++) {
	        	res.add(i);
	        }
	        if (m != s) {
	        	for (int i = A[m - 1] + 1; i < A[m]; i++) {
	        		res.add(i);
	        	}
	        }
	    } else {
	        binarySearch(A, s, m - 1, n, res);
	    }
	    
	    if (e == m || A[e] - A[m+1] == e - m - 1) {
	        int post = e == A.length - 1 ? n + 1 : A[e + 1];
	        for (int i = A[e] + 1; i < post; i++) {
	        	res.add(i);
	        }
	        if (m != e) {
	        	for (int i = A[m] + 1; i < A[m + 1]; i++) {
	        		res.add(i);
	        	}
	        }
	    } else {
	        binarySearch(A, m + 1, e, n, res);
	    }
	}

}