/*
给一个dictionary, 再给一个set of coding string （g5, goo3, goog2, go2le………). return all string from dictionary that can be matched with the coding string. 
要求尽量减少dictionary look up 次数。
*/
	public static List<String> searchPattern(TrieNode root, String pattern) {
		List<String> res = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < pattern.length(); i++) {
			if (Character.isLetter(pattern.charAt(i))) {
				sb.append(pattern.charAt(i));
			} else {
				for (int j = 0; j < pattern.charAt(i) - '0'; j++) {
					sb.append('#');
				}
			}
		}
		
		patternMatch(res, root, sb.toString(), 0, "");
		return res;
	}
	
	public static void patternMatch(List<String> buffer, TrieNode node, String pattern, int index, String prefix) {
		if (index == pattern.length()) {
			if (node.isEndOfWord) {
				buffer.add(prefix);
			}
			return;
		}
		
		if (pattern.charAt(index) == '#') {
			for (char ch : node.children.keySet()) {
				patternMatch(buffer, node.children.get(ch), pattern, index + 1, prefix + ch);
			}
		} else {
			if (node.children.containsKey(pattern.charAt(index))) {
				patternMatch(buffer, node.children.get(pattern.charAt(index)), pattern, index + 1, prefix + pattern.charAt(index));
			}
		}
	}