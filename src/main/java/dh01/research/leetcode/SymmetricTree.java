package dh01.research.leetcode;

import java.util.LinkedList;
import java.util.Queue;

// Source : https://leetcode.com/problems/symmetric-tree/
// Author : H.C.Y
// Date   : 2016-06-28

/********************************************************************************** 
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
    1
   / \
  2   2
 / \ / \
3  4 4  3
**********************************************************************************/
public class SymmetricTree {
	Queue<TreeNode> queue = new LinkedList<TreeNode>();
	TreeNode root;
	 public class TreeNode{
		 int val;
		 TreeNode left;
		 TreeNode right;
		 public TreeNode(int val){
			 this.val = val;
		 }
	 }
	public SymmetricTree(int[] nodes){
		root = new TreeNode(nodes[0]);
		TreeNode head = root;
		for(int i=1;i<nodes.length;i++){
			if(head.right!=null){
				head = queue.poll();
			}
			if(head.left==null){
				head.left=new TreeNode(nodes[i]);
				queue.add(head.left);
			}else if(head.right==null){
				head.right=new TreeNode(nodes[i]);
				queue.add(head.right);
			}
		}
		queue.clear();
	}
	public void breadthFirstSearch(SymmetricTree tree){
		TreeNode head = tree.root;
		System.out.printf("%2s",head.val);
		queue.add(head);
		while(!queue.isEmpty()){
			head = queue.poll();
			if(head.left!=null){
				System.out.printf("%2s",head.left.val);
				queue.add(head.left);
			}if(head.right!=null){
				System.out.printf("%2s",head.right.val);
				queue.add(head.right);
			}
		}
		queue.clear();
	}
	public boolean isSymmetric(TreeNode root) {
	    Queue<TreeNode> q = new LinkedList<>();
	    q.add(root);
	    q.add(root);
	    while (!q.isEmpty()) {
	        TreeNode t1 = q.poll();
	        TreeNode t2 = q.poll();
	        if (t1 == null && t2 == null) continue;
	        if (t1 == null || t2 == null) return false;
	        if (t1.val != t2.val) return false;
	        q.add(t1.left);
	        q.add(t2.right);
	        q.add(t1.right);
	        q.add(t2.left);
	    }
	    return true;
	}
	 
	 public static void main(String[] args) {
		 SymmetricTree st = new SymmetricTree(new int[] {1,2,2,3,4,4,3});
		 st.breadthFirstSearch(st);
		 System.out.println(st.isSymmetric(st.root));
	}
}
