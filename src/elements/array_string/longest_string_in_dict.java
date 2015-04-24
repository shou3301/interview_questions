/*
给一个dictionary, 一个string,找出dict 里能全部用string里的letter 表示的所有最长的词。
For example:
字典包含如下单词：
abcde, abc, abbbc, abbbccca, abbbcccabbcx
给string = "abc"，最长单词应为"abbbccca"
*/

public class MyTrie {

	public static void main(String[] args) {
		Trie t = new Trie();
		t.add("abcde");
		t.add("abc");
		t.add("abbb");
		t.add("abbbccca");
		t.add("abbbcccabbcx");
		System.out.println(longestString(t.root, "ab"));
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
	
	public static String longestString(TrieNode root, String word) {
		Set<Character> set = new HashSet<>();
		for (char ch : word.toCharArray()) {
			set.add(ch);
		}
		
		String res = findLongest(root, set, "");
		
		return res;
	}
	
	public static String findLongest(TrieNode node, Set<Character> set, String prefix) {
		String cand = "";
		
		if (node.isEndOfWord) {
			cand = prefix;
		}
		
		for (char ch : node.children.keySet()) {
			if (set.contains(ch)) {
				String child = findLongest(node.children.get(ch), set, prefix + ch);
				if (child.length() > cand.length()) {
					cand = child;
				}
			}
		}
		
		return cand;
	}

}
