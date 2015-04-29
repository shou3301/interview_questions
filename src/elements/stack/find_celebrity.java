/*
The Celebrity Problem

In a party of N people, only one person is known to everyone. Such a person may be present in the party, if yes, (s)he doesn’t know anyone in the party. We can only ask questions like “does A know B? “. Find the stranger (celebrity) in minimum number of questions.
可以分析几种情况

如果A认识B，那么A不可能是celebrity。去掉A，B则有可能是
如果A不认识B，那么B不可能是celebrity。去掉B，A则有可能是
重复以上两个步骤直到只剩下一个候选人
再次确认是否这最后一个人是否为celebrity
这里用stack来做。

把所有的celebrity压栈
弹出最上面的两个celebrity，根据HaveAcquaintance(A, B)的结果来去掉一个一定不是celebrity的人
将2中剩下的那一位压栈
重复以上两个步骤，直到stack中只剩一个人
确认这个人不认识其他任何人
*/

// Each number is a person from 1 - n
// If there is no celebrity, then return 0
public int findCelebrity(int n) {
    if (n == 1) return 0;
    
    Stack<Integer> stack = new Stack<>();
    for (int i = 1; i <= n; i++) {
        stack.push(i);
    }
    
    while (stack.size() > 1) {
        int top1 = stack.pop();
        int top2 = stack.pop();
        if (doesAKnowB(top1, top2)) {
            // if top1 knows top2, then top1 is not celebrity
            stack.push(top2);
        } else {
            // if top1 doesn't know top2, then top2 is not celebrity
            stack.push(top1);
        }
    }
    
    int cand = stack.pop();
    for (int i = 1; i <= n; i++) {
        if (i != cand) {
            if (!doesAKnowB(i, cand) || doesAKnowB(cand, i)) return 0;
        }
    }
    
    return cand;
}