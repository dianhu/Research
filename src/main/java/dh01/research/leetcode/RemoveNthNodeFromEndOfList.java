package dh01.research.leetcode;

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
	//主要是找到移除节点的前一几点，然后把前一节点的next设置为移除节点的next
	//采用两个节点同时移的方法，找前一节点。
	public ListNode removeNthFromEndNoList(ListNode head, int n) {
		ListNode faster = head;
		ListNode slower = head;
		//把倒数的节点设置为faster节点
		while(n>0&&faster.next!=null){
			faster=faster.next;
			n--;
		}
		
		while(faster.next!=null){
			faster=faster.next;
			slower=slower.next;
		}
		slower.next=slower.next.next;
		return head;
	}
	public static void main(String[] args) {
		RemoveNthNodeFromEndOfList obj = new RemoveNthNodeFromEndOfList();
		ListNode head = obj.removeNthFromEnd(obj.node1,2);
		//ListNode head1 = obj.removeNthFromEndNoList(obj.node1,3);
		System.out.println(head.val+"->"+head.next.val+"->"+head.next.next.val+"->"
		+head.next.next.next.val);
		//System.out.println(head1.val+"->"+head1.next.val+"->"+head1.next.next.val+"->"
				//+head1.next.next.next.val);
	}
}
