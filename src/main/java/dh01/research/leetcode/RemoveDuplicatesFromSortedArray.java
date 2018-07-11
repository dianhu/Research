package dh01.research.leetcode;// Source :https://leetcode.com/problems/remove-duplicates-from-sorted-array/
// Label : two pointer,array
// Author : H.C.Y
// Date   : 2016-06-13
/**********************************************************************************
 * 
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * For example,Given input array nums = [1,1,2],
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.
 * 
 **********************************************************************************/
public class RemoveDuplicatesFromSortedArray {
	public static void main(String[] args) {
		System.out.println(removeDuplicates(new int[]{1,1,1,2,2,3,4}));
	}
	public static int removeDuplicates(int[] nums) {
		if(nums.length==0) return 0; 
		int i=0;
		//两个指针i和j，j移动快一些，先比较两个指向的值，不相等则i向前移，并把j指向的值赋予i
		//然后j往前移，遇到重复的即num[i]=num[j]，skip继续往前移，否则重复上面的i往前移并赋值的操作
		for(int j=1;j<nums.length;j++){
			if(nums[j]!=nums[i]){
				i++;
				nums[i]=nums[j];
			}
		}
		return i+1;
	}
}
