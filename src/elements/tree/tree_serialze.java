/**
 * Binary tree serialize
 */
 
public class BinaryTreeSerializer {
	
	private char NULL_MARK = '#';
	
	private TreeNode root;
	
	public BinaryTreeSerializer(TreeNode root) {
		this.root = root;
	}
	
	public String serialize() {
		StringBuilder sb = new StringBuilder();
		helper(root, sb);
		return sb.toString();
	}
	
	private void helper(TreeNode node, StringBuilder sb) {
		if (node == null) {
			sb.append(NULL_MARK);
			return;
		}
		
		sb.append(node.val);
		helper(node.left, sb);
		helper(node.right, sb);
	}
}

public class BinaryTreeDeserializer {
	
	private char NULL_MARK = '#';
	
	private String str;
	
	private int index;
	
	public BinaryTreeSerializer(String str) {
		this.str = str;
		this.index = 0;
	}
	
	public TreeNode deserialize() {
		if (index >= str.length()) return null;
		
		char curr = str.charAt(index);
		if (curr == NULL_MARK) {
			index++;
			return null;
		}
		
		TreeNode currNode = new TreeNode(curr - '0');
		index++;
		currNode.left = deserialize();
		currNode.right = deserialize();
		
		return currNode;
	}

}