public class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        Set<String> res = new HashSet<>();
        int m = board.length;
        if (m == 0) return new ArrayList<String>();
        int n = board[0].length;
        if (n == 0) return new ArrayList<String>();
        
        Trie trie = new Trie();
        for (String str : words) {
            trie.insert(str);
        }
        
        boolean[][] used = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                bt(board, used, "", i, j, m, n, trie, res);
            }
        }
        
        return new ArrayList<String>(res);
    }
    
    public void bt(char[][] board, boolean[][] used, String buffer, int x, int y, int m, int n, Trie trie, Set<String> cache) {
        if (x < 0 || y < 0 || x >= m || y >= n || used[x][y]) return;
        
        String curr = buffer + board[x][y];
        
        if (!trie.startsWith(curr)) return;
        
        if (trie.search(curr)) cache.add(curr);
        used[x][y] = true;
        bt(board, used, curr, x + 1, y, m, n, trie, cache);
        bt(board, used, curr, x - 1, y, m, n, trie, cache);
        bt(board, used, curr, x, y + 1, m, n, trie, cache);
        bt(board, used, curr, x, y - 1, m, n, trie, cache);
        used[x][y] = false;
    }
    
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

}