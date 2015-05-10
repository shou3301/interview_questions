/*
Implement a trie with insert, search, and startsWith methods.

Note:
You may assume that all inputs are consist of lowercase letters a-z.
*/

class TrieNode {
    public boolean end;
    public Map<Character, TrieNode> child;
    
    // Initialize your data structure here.
    public TrieNode() {
        child = new HashMap<>();
        end = false;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode n = root;
        for (int i = 0; i < word.length(); i++) {
            if (!n.child.containsKey(word.charAt(i))) {
                n.child.put(word.charAt(i), new TrieNode());
            }
            
            n = n.child.get(word.charAt(i));
            if (i == word.length() - 1) {
                n.end = true;
            }
        }
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode n = root;
        for (int i = 0; i < word.length(); i++) {
            if (!n.child.containsKey(word.charAt(i)))
                return false;
            n = n.child.get(word.charAt(i));
        }
        
        return n.end;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode n = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (!n.child.containsKey(prefix.charAt(i)))
                return false;
            n = n.child.get(prefix.charAt(i));
        }
        
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");