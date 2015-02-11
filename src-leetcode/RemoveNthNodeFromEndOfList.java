import java.util.ArrayList;
import java.util.List;

// Source : https://oj.leetcode.com/problems/remove-nth-node-from-end-of-list/
// Author : H.C.Y
// Date   : 2015-02-09

/**********************************************************************************
 * Given a linked list, remove the nth node from the end of list and return its
 * head.
 *
 * For example,
 *
 * Given linked list: 1->2->3->4->5, and n = 2.
 *
 * After removing the second node from the end, the linked list becomes
 * 1->2->3->5. Note: Given n will always be valid. Try to do this in one pass.
 * 
 **********************************************************************************/
public class RemoveNthNodeFromEndOfList {
	ListNode node5 = new ListNode(5,null);
	ListNode node4 = new ListNode(4,node5);
	ListNode node3 = new ListNode(3,node4);
	ListNode node2 = new ListNode(2,node3);
	ListNode node1 = new ListNode(1,node2);
	
	public ListNode removeNthFromEnd(ListNode head, int n) {
		List<ListNode> lns = new ArrayList<ListNode>(); 
		ListNode node = head;
		while(lns.add(node)&&node.next!=null){
			node=node.next;
		}
		int size = lns.size();
		if(n==0||n>size){
			return lns.get(0);
		}else if(n!=0&&n<size){
			ListNode removeNode = lns.get(size-n);
			ListNode removeNodePev = lns.get(size-n-1);
			removeNodePev.next=removeNode.next;
		}else{//if is the head node
			lns.remove(0);
		}
		
		return lns.size()>0?lns.get(0):null;
	}
	public static void main(String[] args) {
		RemoveNthNodeFromEndOfList obj = new RemoveNthNodeFromEndOfList();
		ListNode head = obj.removeNthFromEnd(obj.node1,5);
		System.out.println(head.val+"->"+head.next.val+"->"+head.next.next.val+"->"
		+head.next.next.next.val);
	}
}
