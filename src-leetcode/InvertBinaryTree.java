import java.util.LinkedList;
import java.util.Queue;

// Source :https://leetcode.com/problems/invert-binary-tree/
// Label: tree
// Author : H.C.Y
// Date   : 2016-06-27
/**********************************************************************************
 *
 *Invert a binary tree.
from

     4
   /   \
  2     7
 / \   / \
1   3 6   9

to
     4
   /   \
  7     2
 / \   / \
9   6 3   1
 *
 * 
 **********************************************************************************/
public class InvertBinaryTree {
	 public class TreeNode{
		 int val;
		 TreeNode left;
		 TreeNode right;
		 public TreeNode(int val){
			 this.val = val;
		 }
	 }
	//先序遍历
	private void preOrder(TreeNode head) {
		if(head==null) return;
		visitNode(head);
		preOrder(head.left);
		preOrder(head.right);
	}
	
	private void visitNode(TreeNode node){
		System.out.print(node.val+" ");
	}
	 public void initTree(TreeNode root){
		//init tree
		  TreeNode n1Left = root.left=new TreeNode(2);
		  TreeNode n1Right = root.right = new TreeNode(7);
		  n1Left.left = new TreeNode(1);
		  n1Left.right =  new TreeNode(3);
		  n1Right.left = new TreeNode(6);
		  n1Right.right = new TreeNode(9);
	 }
	 public TreeNode invertTree(TreeNode root) {
		  //invert
		  if(root==null) return null;
		  TreeNode tmp = root.left;
		  root.left = root.right;
		  root.right = tmp;
		  invertTree(root.left);
		  invertTree(root.right);
	      return root;
	 }
	 
	 public TreeNode invertTreeByIter(TreeNode root) {
		    if (root == null) return null;
		    Queue<TreeNode> queue = new LinkedList<TreeNode>();
		    queue.add(root); 
		    while (!queue.isEmpty()) {
		        TreeNode current = queue.poll();
		        TreeNode temp = current.left;
		        current.left = current.right;
		        current.right = temp;
		        if (current.left != null) queue.add(current.left);
		        if (current.right != null) queue.add(current.right);
		    }
		    return root;
		}
	 
	 public static void main(String[] args) {
		 InvertBinaryTree ibt =  new InvertBinaryTree();
		 TreeNode root = ibt.new TreeNode(4);
		 ibt. initTree(root);
		 
		 TreeNode rstHead = ibt.invertTree(root);
		 ibt.preOrder(rstHead);
		 
		 TreeNode rstHead1 = ibt.invertTreeByIter(root);
		 ibt.preOrder(rstHead1);
	}
}
