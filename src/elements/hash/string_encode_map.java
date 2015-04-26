/*
Given two (dictionary) words as Strings, determine if they are isomorphic. Two words are called isomorphic if the letters in one word can be remapped to get the second word. Remapping a letter means replacing all occurrences of it with another letter while the ordering of the letters remains unchanged. No two letters may map to the same letter, but a letter may map to itself.

Example:
given "foo", "app"; returns true
we can map 'f' -> 'a' and 'o' -> 'p'
given "bar", "foo"; returns false
we can’t map both 'a' and 'r' to 'o'

given "turtle", "tletur"; returns true
we can map 't' -> 't', 'u' -> 'l', 'r' -> 'e', 'l' -> 'u', 'e' -'r'

given "ab", "ca"; returns true
we can map 'a' -> 'c', 'b'
*/

public boolean isomorphic(String s1, String s2) {
    // assume the length is the same
    if (s1.length() == 1) return true;
    
    Map<Character, Character> oneToTwo = new HashMap<>();
    Map<Character, Character> twoToOne = new HashMap<>();
    
    for (int i = 0; i < s1.length(); i++) {
        if (oneToTwo.containsKey(s1.charAt(i))) {
            if (s2.charAt(i) != oneToTwo.get(s1.charAt(i))) return false;
        }
        if (twoToOne.containsKey(s2.charAt(i))) {
            if (s1.charAt(i) != twoToOne.get(s2.charAt(i))) return false;
        }
        
        oneToTwo.put(s1.charAt(i), s2.charAt(i));
        twoToOne.put(s2.charAt(i), s1.charAt(i));
    }
    
    return true;
}