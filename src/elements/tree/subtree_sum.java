/**
 * 给你一组Treenode，他们每个有一个id，一个parentId，一个value，让你输出所有subtree的sum of value。
 * 注意这个是没有children node的，只有parentId。
 */
public class SumOfAllSubtrees {

	public static void main(String[] args) {
		List<TreeNode> nodes = new ArrayList<>();
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		n2.parent = n1;
		n3.parent = n1;
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		n4.parent = n2;
		n5.parent = n2;
		nodes.add(n1);
		nodes.add(n2);
		nodes.add(n3);
		nodes.add(n4);
		nodes.add(n5);
		
		sumOfAllSubtrees(nodes);
		for (TreeNode n : nodes) {
			System.out.println(n.val);
		}
	}
	
	public static class TreeNode {
		public int val;
		public TreeNode parent;
		
		public TreeNode(int val) {
			this.val = val;
			this.parent = null;
		}
	}
	
	public static void sumOfAllSubtrees(List<TreeNode> nodes) {
		for (TreeNode node : nodes) {
			TreeNode p = node.parent;
			while (p != null) {
				p.val += node.val;
				p = p.parent;
			}
		}
	}

}