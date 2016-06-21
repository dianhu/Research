package hcy.datastructure.tree;

public class BinarySearchTree {
	Node head = new Node(-1);

	public void setHead(int key) {
		this.head = new Node(key);
	}

	private class Node {
		public Node left,right;
		public int key;

		public Node(int key) {
			this.key = key;
		}

	}

	public boolean insert(int value) {
		return insertNode(this.head, new Node(value));
	}

	private boolean insertNode(Node head, Node newNode) {
		if (newNode.key >= head.key) {
			if (head.right == null) {
				head.right = newNode;
				return true;
			} else {
				return insertNode(head.right, newNode);
			}
		} else if (newNode.key < head.key) {
			if (head.left == null) {
				head.left = newNode;
				return true;
			} else {
				return insertNode(head.left, newNode);
			}
		}
		return false;
	}

	public boolean contains(Node head, int searchValue) {
		return false;
	}
	
	public void preOrder(){
		preOrder(this.head);
	}
	
	public void midOrder(){
	    midOrder(this.head);
	}
	
	public void postOrder(){
		postOrder(this.head);
	}
	private void visitNode(Node node){
		System.out.print(node.key+" ");
	}
	
	//先序遍历
	private void preOrder(Node head) {
		if(head==null) return;
		visitNode(head);
		preOrder(head.left);
		preOrder(head.right);
	}
	
	//中序遍历
		private void midOrder(Node head) {
			if(head==null) return ;
			midOrder(head.left);
			visitNode(head);
			midOrder(head.right);
		}
	
	//后序遍历
	private void postOrder(Node head) {
		if(head==null) return;
		postOrder(head.left);
		postOrder(head.right);
		visitNode(head);
	}

	//对数组从小到大排序，把数组值按从小到大的顺序插入到二叉树中，然后中序遍历。
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		int[] test=new int[]{15,10,6,11,20,18,36};
		for(int i =0;i<test.length;i++){
			if(i==0) {
				bst.setHead(test[i]);
				continue;
			}
			bst.insert(test[i]);
		}
		bst.midOrder();
//		bst.preOrder();
//		bst.postOrder();
	}
}
