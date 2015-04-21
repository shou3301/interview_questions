public class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        
        int maxLen = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (!stack.empty() && s.charAt(stack.peek()) == '(') {
                    stack.pop();
                    if (stack.empty()) {
                        maxLen = i + 1;
                    } else {
                        maxLen = Math.max(maxLen, i - stack.peek());
                    }
                } else {
                    stack.push(i);
                }
            }
        }
        
        return maxLen;
    }
}

// Also output the String
public class Solution {
    public String longestValidParentheses(String s) {
        if (s == null || s.length() == 0) return "";
        Stack<Integer> stack = new Stack<>();
        
        int maxLen = 0;
        String res = "";
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (!stack.empty() && s.charAt(stack.peek()) == '(') {
                    stack.pop();
                    if (stack.empty()) {
                        maxLen = i + 1;
                        res = s.substring(i+1);
                    } else {
                        maxLen = Math.max(maxLen, i - stack.peek());
                        res = s.substring(stack.peek() + 1, i + 1);
                    }
                } else {
                    stack.push(i);
                }
            }
        }
        
        return res;
    }
}