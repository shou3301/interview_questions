/*
Alphabetical Sorting

{ “face”, “ball”, “apple”, “art”, “ah” }
“htarfbp…”
根据下面的string去给上面list words排序。就是平常我们按abcd…排，这次按string里的letter顺序排
*/

public void sort(List<String> strs, String order) {
    if (strs.isEmpty()) return;
    
    final Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < order.length(); i++) {
        map.put(order.charAt(i), i);
    }
    
    Collections.sort(strs, new Comparator<String>() {
        @Override
        public int compare(String s1, String s2) {
            int len = Math.min(s1.length(), s2.length());
            for (int i = 0; i < len; i++) {
                int diff = map.get(s1.charAt(i)) - map.get(s2.charAt(i));
                if (diff != 0) return diff;
            }
            
            if (l1.length() == l2.length()) return 0;
            return l1.length() < l2.length() ? -1 : 1;
        }
    });
}