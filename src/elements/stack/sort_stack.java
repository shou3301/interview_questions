/*
Description
You are given a stack, write a program to sort the stack in ascending order, meaning that the biggest element on the top. You are allowed to have one additional stack to hold the elements, but not allowed to copy the elements into any other data structures, such as an array or a list or else. 

Input
The input should be a list of non-negative integers in the original stack from bottom to top. Any integers in the stack should be less than 1,000,000,000. And the length of the list should be less than or equal to 2,000.

Output
The output should be a sorted stack in ascending order.

Sample Input
5 8 7
Sample Output
8 7 5
*/

class Solution {
	public Stack<Integer> sortStack(Stack<Integer> s) {
        if (s.isEmpty()) return s;
        
        int top = s.pop();
        sortStack(s);
        insert(s, top);
        
        return s;
    }
    
    public void insert(Stack<Integer> s, int target) {
        if (s.isEmpty()) {s.push(target); return;}
        if (s.peek() > target) {
            int tmp = s.pop();
            insert(s, target);
            s.push(tmp);
        } else {
            s.push(target);
        }
    }
}