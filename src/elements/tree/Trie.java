public class MyTrie {

	public static void main(String[] args) {
		Trie t = new Trie();
		t.add("abcdefgh");
		t.add("abcde");
		t.add("abc");
		t.add("xyz");
		
		System.out.println(t.contains("abc"));
		System.out.println(t.contains("abcd"));
		System.out.println(t.contains("abcde"));
		System.out.println(t.contains("abcdefg"));
		System.out.println(t.contains("abcdefgh"));
		System.out.println(t.contains("xyz"));
		
		System.out.println(t.findWordsWithPrefix("abc"));
		System.out.println(t.findWordsWithPrefix("abcde"));
		System.out.println(t.findWordsWithPrefix("abcdef"));
		System.out.println(t.findWordsWithPrefix("xyzh"));
		System.out.println(t.findWordsWithPrefix("a"));
		
		/*true
		false
		true
		false
		true
		true
		[abc, abcde, abcdefgh]
		[abcde, abcdefgh]
		[abcdefgh]
		[]
		[abc, abcde, abcdefgh]*/
	}
	
	public static class Trie {
	    public TrieNode root;
	    
	    public Trie() {
	        this.root = new TrieNode('#');
	    }
	    
	    public void add(String word) {
	        build(word, 0, root);
	    }
	    
	    private void build(String word, int index, TrieNode node) {
	        char curr = word.charAt(index);
	        TrieNode next = null;
	        if (node.children.containsKey(curr)) {
	            next = node.children.get(curr);
	        } else {
	            next = new TrieNode(curr);
	            node.children.put(curr, next);
	        }
	        
	        if (index == word.length() - 1) {
	            next.isEndOfWord = true;
	        } else {
	            build(word, index + 1, next);
	        }
	    }
	    
	    public boolean contains(String word) {
	        TrieNode node = find(word, 0, root);
	        return node != null && node.isEndOfWord;
	    }
	    
	    private TrieNode find(String word, int index, TrieNode node) {
	        if (index == word.length()) {
	            return node;
	        }
	        
	        char curr = word.charAt(index);
	        if (node.children.containsKey(curr)) {
	            return find(word, index + 1, node.children.get(curr));
	        }
	        
	        return null;
	    }
	    
	    public List<String> findWordsWithPrefix(String prefix) {
	        TrieNode node = find(prefix, 0, root);
	        List<String> res = new ArrayList<>();
	        if (node == null) return res;
	        
	        fetchAllSubTree(res, node, prefix);
	        return res;
	    }
	    
	    private void fetchAllSubTree(List<String> buffer, TrieNode node, String prefix) {
	        if (node.isEndOfWord) {
	            buffer.add(prefix);
	        }
	        
	        for (char ch : node.children.keySet()) {
	            fetchAllSubTree(buffer, node.children.get(ch), prefix + ch);
	        }
	    }
	}

	public static class TrieNode {
	    public boolean isEndOfWord;
	    public char val;
	    public Map<Character, TrieNode> children;
	    
	    public TrieNode (char val) {
	        this.isEndOfWord = false;
	        this.val = val;
	        this.children = new HashMap<>();
	    }
	}

}