package dh01.research.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// Source :https://leetcode.com/problems/contains-duplicate/
// Label : find,hash
// Author : H.C.Y
// Date   : 2016-06-13

/**********************************************************************************
 * 
 * Given an array of integers, find if the array contains any duplicates.
 *
 * Your function should return true if any value appears at least twice in the
 * array, and it should return false if every element is distinct.
 *
 * 
 **********************************************************************************/
public class ContainDuplicate {

	public static void main(String[] args) {
		System.out.println(containsDuplicate1(new int[] { 0, 1, 4 }));
		System.out.println(containsDuplicate2(new int[] { 0, 1, 4 }));
	}

	// 1.先排序,再比较 
	//时间复杂度主要取决于排序O(N*logN),空间复杂度O(1)
	public static boolean containsDuplicate1(int[] nums) {
		Arrays.sort(nums);
		for(int i=0;i<nums.length-1;i++){
			if(nums[i]==nums[i+1]) return true;
		}
		return false;
	}
	//２.不排序，利用hash查找
	//时间复杂度O(n),空间复杂度O(n)
	public static boolean containsDuplicate2(int[] nums) {
		Set<Integer> set = new HashSet<Integer>(nums.length);
		for(int i:nums){
			if(set.contains(i)) return true;
			set.add(i);
		}
		return false;
	}
}
