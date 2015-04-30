/**
 * there is linked list of length N, but N is unknow. Write a function that will return K random numbers from the list.
 * Numbers returned should be complete random.
 */
 
public class ReserviorSampling {
	public List<Integer> select(ListNode node, int K) {
		int count = 0;
		ListNode n = node;
		List<Integer> res = new ArrayList<>();
		while (n != null) {
			if (count < K) {
				// If there are less than K elements in the list
				// directly add it.
				res.add(n.val);
			} else {
				// If there is already K elements in the list,
				// then generate a random number and if it's within [0, k), then replace it.
				int offset = new Random().nextInt(count + 1);
				if (offset < K) {
					res.set(offset, n.val);
				}
			}
			n = n.next;
			count++;
		}
	}
}
