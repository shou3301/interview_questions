/*
Design a data structure that supports the following two operations:

void addWord(word)
bool search(word)
search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

For example:

addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true
Note:
You may assume that all words are consist of lowercase letters a-z.
*/

public class WordDictionary {
    
    protected class Node {
        public Map<Character, Node> children;
        public boolean isEnd;
        
        public Node() {
            children = new HashMap<>();
            isEnd = false;
        }
    }
    
    private final Node root;
    
    public WordDictionary() {
        root = new Node();
    }

    // Adds a word into the data structure.
    public void addWord(String word) {
        Node n = root;
        for (int i = 0; i < word.length(); i++) {
            if (!n.children.containsKey(word.charAt(i))) {
                n.children.put(word.charAt(i), new Node());
            }
            n = n.children.get(word.charAt(i));
            if (i == word.length() - 1) {
                n.isEnd = true;
            }
        }
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return check(root, word, 0);
    }
    
    private boolean check(Node node, String word, int index) {
        if (index == word.length()) return node.isEnd;
        if (word.charAt(index) != '.' && !node.children.containsKey(word.charAt(index))) return false;
        
        if (word.charAt(index) != '.') {
            return check(node.children.get(word.charAt(index)), word, index + 1);
        } else {
            for (Character ch : node.children.keySet()) {
                if (check(node.children.get(ch), word, index + 1)) return true;
            }
        }
        
        return false;
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");