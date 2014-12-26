// Source : https://oj.leetcode.com/problems/majority-element/
// Author : H.C.Y
// Date   : 2014-12-26

/********************************************************************************** 
* 
*Given an array of size n, find the majority element. The majority element is the element that appears more than [ n/2 ] times.
*
*You may assume that the array is non-empty and the majority element always exist in the array.
*
*Credits:
*Special thanks to @ts for adding this problem and creating all test cases.
* 
*               
**********************************************************************************/
public class MajorityElement {
	
	public static int majorityElement(int[] num) {
		if (num == null || num.length == 0)
			return 0;

		// "iter" is the current major element, and "count" is the times that
		// this major element appears more than the other ones combined.
		int count = 1;
		int iter = num[0];

		int N = num.length;

		for (int i = 1; i < N; i++) {
			if (num[i] != iter) {
				if (count == 0) {
					// new candidate
					iter = num[i];
					count = 1;
				} else {
					// count should be bigger than 0
					count--;
				}
			} else {
				count++;
			}
		}

		return iter;
	}
	public static void main(String[] args) {
		System.out.println((majorityElement(new int[] {1,2,3,0,0,1,1})));
	}
}
