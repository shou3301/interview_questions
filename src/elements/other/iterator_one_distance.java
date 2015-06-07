/*
class IntFileIterator {
  boolean hasNext();
  int next();
}

class{
  public boolean isDistanceZeroOrOne(IntFileIterator a, IntFileIterator b)；

}
// return if the distance between a and b is at most 1.. 
// Distance: minimum number of modifications to make a=b
// Modification:
//   1. change an int in a
//   2. insert an int to a
//   3. remove an int from a
*/

public class IterDistance {

	public static void main(String[] args) {
		List<Integer> l1 = Arrays.asList(1, 2, 3, 4);
		List<Integer> l2 = Arrays.asList(1, 2, 3, 4);
		// true
		System.out.println(iteratorOneDistance(l1.iterator(), l2.iterator()));
		
		l1 = Arrays.asList(1, 2, 3, 4);
		l2 = Arrays.asList(1, 2, 3, 4, 5);
		// true
		System.out.println(iteratorOneDistance(l1.iterator(), l2.iterator()));
		System.out.println(iteratorOneDistance(l2.iterator(), l1.iterator()));
		
		l1 = Arrays.asList(1, 2, 3, 4);
		l2 = Arrays.asList(1, 2, 3, 4, 5, 6);
		// false
		System.out.println(iteratorOneDistance(l1.iterator(), l2.iterator()));
		System.out.println(iteratorOneDistance(l2.iterator(), l1.iterator()));
		
		l1 = Arrays.asList(1, 9, 3, 4);
		l2 = Arrays.asList(1, 2, 3, 4);
		// true
		System.out.println(iteratorOneDistance(l1.iterator(), l2.iterator()));
		System.out.println(iteratorOneDistance(l2.iterator(), l1.iterator()));
		
		l1 = Arrays.asList(1, 2, 3, 4);
		l2 = Arrays.asList(1, 2, 3, 6);
		// true
		System.out.println(iteratorOneDistance(l1.iterator(), l2.iterator()));
		System.out.println(iteratorOneDistance(l2.iterator(), l1.iterator()));
		
		l1 = Arrays.asList(1, 9, 3, 4, 5);
		l2 = Arrays.asList(1, 2, 3, 4);
		// false
		System.out.println(iteratorOneDistance(l1.iterator(), l2.iterator()));
		System.out.println(iteratorOneDistance(l2.iterator(), l1.iterator()));
		
		l1 = Arrays.asList(1, 9, 3, 4, 5);
		l2 = Arrays.asList(1, 2, 3, 4, 7);
		// false
		System.out.println(iteratorOneDistance(l1.iterator(), l2.iterator()));
		System.out.println(iteratorOneDistance(l2.iterator(), l1.iterator()));
		
		l1 = Arrays.asList(1, 9, 8, 4);
		l2 = Arrays.asList(1, 2, 3, 4);
		// false
		System.out.println(iteratorOneDistance(l1.iterator(), l2.iterator()));
		System.out.println(iteratorOneDistance(l2.iterator(), l1.iterator()));
		
	}
	
	public static boolean iteratorOneDistance(Iterator<Integer> it1, Iterator<Integer> it2) {
		// b1 is the last int from it1, same for b2
	    int a1, a2, b1 = 0, b2 = 0;
	    boolean foundDiff = false;
	    // replace means if a replace can continue to work
	    // remove1 means a remove from it1 can continue to work
	    // remove2 means a remove from it2 can continue to work
	    boolean replace = true, remove1 = true, remove2 = true;
	    while (it1.hasNext() && it2.hasNext()) {
	        a1 = it1.next();
	        a2 = it2.next();
	        if (!foundDiff && a1 == a2) {
	            continue;
	        } else if (foundDiff) {
	        	// if the current 2 integers are not equal, then a replace won't work.
	            if (a1 != a2) replace = false;
	            // if the last integer from it1 and the current integer from it2 are not equal, then a remove from it2 won't work.
	            if (b1 != a2) remove2 = false;
	            // if the last integer from it2 and the current integer from it1 are not equal, then a remove from it1 won't work.
	            if (b2 != a1) remove1 = false;
	            // if all of them won't work, then just return false.
	            if (replace || remove1 || remove2) {
	                b1 = a1;
	                b2 = a2;
	            } else {
	                return false;
	            }
	        } else {
	            foundDiff = true;
	            b1 = a1;
	            b2 = a2;
	        }
	    }
	    
	    // if both have no more integers, then we know a remove won't work. Just return if it's possible to replace.
	    if (!it1.hasNext() && !it2.hasNext()) {
	        return replace;
	    }
	    
	    // If it1 has more, then no diff was found previously, then it1 can has at most one more.
	    // otherwise, we check if remove from it1 works or not.
	    if (it1.hasNext()) {
	        int last = it1.next();
	        if (!foundDiff) return !it1.hasNext();
	        else return remove1 && b2 == last && !it1.hasNext();
	    }
	    
	    // Similar
	    if (it2.hasNext()) {
	        int last = it2.next();
	        if (!foundDiff) return !it2.hasNext();
	        else return remove2 && b1 == last && !it2.hasNext();
	    }
	    
	    return true;
	}

}
