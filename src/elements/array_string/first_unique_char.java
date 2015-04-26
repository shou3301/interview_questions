/*
Given a string, find the first unique character using one pass.
*/

public int firstUnique(String str) {
    if (str.length() == 1) return 0;
    
    int curr = 0;
    Map<Character, Integer> count = new HashMap<>();
    for (int i = 0; i < str.length(); i++) {
        if (count.containsKey(str.charAt(i)))) {
            count.put(str.charAt(i), count.get(str.charAt(i)) + 1);
        } else {
            count.put(str.charAt(i), 1);
        }
        
        if (count.get(str.charAt(curr)) > 1) {
            if (++curr == str.length()) return -1;
        }
    }
    
    return curr;
}