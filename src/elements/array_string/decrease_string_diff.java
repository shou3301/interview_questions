/*
 * 有两个string， 比如 s1 = "abc", s2 = "cba",相同index下的字母不同，我 们叫一个difference，比如在index
 * 0 上 s1是 a 而s2 是 c，这就是一个difference， 而index 1 上
 * s1和s2都是b，则不是difference.现在只许你swap一次 S2 的两个字母，问如何才能 最大程度的减少difference， 需要return
 * swap的两个index
*/

// return [-1, -1] if nothing can decrease the diff
public class LessDiff {

	public static void main(String[] args) {
		getString(decreaseDiff("abcaaaa", "cba"));
		getString(decreaseDiff("abc", "def"));
		getString(decreaseDiff("abab", "aabb"));
		getString(decreaseDiff("aabb", "ccbba"));
	}
	
	public static int[] decreaseDiff(String s1, String s2) {
	    // a char maps to a list of index
	    Map<Character, List<Integer>> map = new HashMap<>();
	    
	    int[] res = new int[] {-1, -1};
	    for (int i = 0; i < s2.length(); i++) {
	        if (i < s1.length() && s1.charAt(i) == s2.charAt(i)) continue;
	        if (map.containsKey(s2.charAt(i))) {
	            for (Integer j : map.get(s2.charAt(i))) {
	                if (i < s1.length() && s1.charAt(i) == s2.charAt(j)) {
	                    return new int[] {j, i};
	                } else {
	                    res = new int[] {j, i};
	                }
	            }
	        }
	        
	        if (i < s1.length()) {
	            if (map.containsKey(s1.charAt(i))) {
	                map.get(s1.charAt(i)).add(i);
	            } else {
	                List<Integer> l = new ArrayList<>();
	                l.add(i);
	                map.put(s1.charAt(i), l);
	            }
	        }
	    }
	    
	    return res;
	}

	public static void getString(int[] A) {
		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i] + " ");
		}
		System.out.println();
	}
}