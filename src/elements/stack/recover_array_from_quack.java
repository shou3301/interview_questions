/*
Recover a Quack Data Structure

给一个Quack的类，里面有三个方法：
pop(): 随机从头或者尾扔出一个元素；
peek(): 随机看头或者尾的一个元素，peek()之后pop()的话一定会pop()出peek()的那个元素；
push(): 向尾部插入一个元素

问题是：给一个排序好的Quack,怎么把里面的元素原封不动的放到一个Array里面。
Follow up：如果quack里面有重复的元素，怎么处理。
*/

// Directly handle the situation there are duplicates in the Quack
public List<Integer> recoverArray(Quack quack) {
    Stack<Integer> stack = new Stack<>();
    Queue<Integer> queue = new LinkedList<>();
    
    while (!quack.isEmpty()) {
        int curr = quack.pop();
        if (quack.isEmpty()) {
            queue.offer(curr);
        } else {
            int count = 1;
            int next;
            while (!quack.isEmpty() && (next = quack.peek()) == curr) {
                count++;
                quack.pop();
            }
            
            if (next > curr) {
                for (int i = 0; i < count; i++) {
                    queue.offer(curr);
                }
            } else {
                for (int i = 0; i < count; i++) {
                    stack.push(curr);
                }
            }
        }
    }
    
    List<Integer> res = new ArrayList<>();
    while (!queue.isEmpty()) res.add(queue.poll());
    while (!stack.empty()) res.add(stack.pop());
    
    return res;
}