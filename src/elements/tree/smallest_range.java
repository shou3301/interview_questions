public class SmallestRange {

	public static void main(String[] args) {
		List<Integer> l1 = new ArrayList<>();
		List<Integer> l2 = new ArrayList<>();
		List<Integer> l3 = new ArrayList<>();
		
		l1.add(4);l1.add(10);l1.add(15);l1.add(24);l1.add(26);
		l2.add(0);l2.add(9);l2.add(12);l2.add(20);
		l3.add(5);l3.add(18);l3.add(22);l3.add(30);
		List<List<Integer>> lists = new ArrayList<>();
		lists.add(l1);lists.add(l2);lists.add(l3);
		
		System.out.println(smallestRange(lists));
	}

	// Time O(nlogn)
	public static int smallestRange(List<List<Integer>> lists) {
	    if (lists.size() == 0) return 0;
	    // assume every list at lease has one number.
	    
	    TreeMap<Wrapper, Integer> map = new TreeMap<>();
	    for (int i = 0; i < lists.size(); i++) {
	        map.put(new Wrapper(lists.get(i).get(0), 0, i), 0);
	    }
	    
	    int minDis = Integer.MAX_VALUE;
	    while (map.size() == lists.size()) {
	        Wrapper f = map.firstKey();
	        Wrapper l = map.lastKey();
	        minDis = Math.min(minDis, l.val - f.val);
	        
	        map.remove(f);
	        if (f.index + 1 < lists.get(f.listIndex).size()) {
	            map.put(new Wrapper(lists.get(f.listIndex).get(f.index + 1), f.index + 1, f.listIndex), f.index + 1);
	        }
	    }
	    
	    return minDis;
	}

	public static class Wrapper implements Comparable<Wrapper> {
	    public int val;
	    public int index;
	    public int listIndex;
	    
	    public Wrapper(int val, int index, int listIndex) {
	        this.val = val;
	        this.index = index;
	        this.listIndex = listIndex;
	    }
	    
	    public int compareTo(Wrapper other) {
	        return this.val - other.val;
	    }
	    
	    public boolean equals(Wrapper other) {
	        return this.val == other.val && this.index == other.index && this.listIndex == other.listIndex;
	    }
	}
}