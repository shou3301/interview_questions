/*
Given two words (start and end), and a dictionary, find all shortest transformation sequence(s) from start to end, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the dictionary
For example,

Given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]
Return
  [
    ["hit","hot","dot","dog","cog"],
    ["hit","hot","lot","log","cog"]
  ]
Note:
All words have the same length.
All words contain only lowercase alphabetic characters.
*/

public class Solution {
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        List<List<String>> res = new ArrayList<>();
        if (start.equals(end)) {
            List<String> l = new ArrayList<>();
            l.add(start);
            l.add(end);
            res.add(l);
            return res;
        }
        
        if (dict.isEmpty()) return res;
        
        Queue<Node> q = new LinkedList<>();
        List<Node> result = new ArrayList<>();
        boolean found = false;
        q.offer(new Node(start));
        
        while (!q.isEmpty() && !found) {
            int size = q.size();
            Set<String> used = new HashSet<>();
            for (int j = 0; j < size; j++) {
                Node curr = q.poll();
                for (int i = 0; i < curr.word.length(); i++) {
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        if (ch != curr.word.charAt(i)) {
                            String tmp = replace(curr.word, i, ch);
                            if (tmp.equals(end)) {
                                Node cand = new Node(end);
                                cand.pre = curr;
                                result.add(cand);
                                found = true;
                            } else if (dict.contains(tmp)) {
                                Node n = new Node(tmp);
                                n.pre = curr;
                                q.offer(n);
                                used.add(tmp);
                            }
                        }
                    }
                }
            }
            dict.removeAll(used);
        }
        
        for (Node n : result) {
            List<String> l = new ArrayList<>();
            Node nn = n;
            while (nn != null) {
                l.add(nn.word);
                nn = nn.pre;
            }
            Collections.reverse(l);
            res.add(l);
        }
        
        return res;
    }
    
    public String replace(String word, int index, char ch) {
        char[] chs = word.toCharArray();
        chs[index] = ch;
        return new String(chs);
    }
    
    public class Node {
        public String word;
        public Node pre;
        public Node(String w) {
            word = w;
            pre = null;
        }
    }
}