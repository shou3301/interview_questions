/**
 * Find K nearest value in a BST.
 */
 
public class Solution {
	public List<Integer> nearestK(TreeNode root, int target, int K) {
		Deque<Integer> buffer = new LinkedList<>();
		helper(root, target, K, buffer);
		return new ArrayList<Integer>(buffer);
	}
	
	private void helper(TreeNode node, int target, int K, Deque<Integer> buffer) {
		if (node == null) return;
		
		helper(node.left, target, K, buffer);
		
		if (buffer.size() < K) {
			buffer.addLast(node.val);
		} else {
			if (Math.abs(node.val - target) < Math.abs(buffer.peekFirst() - target)) {
				buffer.removeFirst();
				buffer.addLast(node.val);
			}
		}
		
		helper(node.right, target, K, buffer);
	}
}