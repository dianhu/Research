import java.util.ArrayList;
import java.util.List;

// Source : https://leetcode.com/problems/summary-ranges/
// Author : H.C.Y
// Date   : 2015-07-06

/**********************************************************************************
 * Given a sorted integer array without duplicates, return the summary of its
 * ranges.
 *
 * For example, given [4,5,6,9,10,11], return ["4->6","9->10","11"].
 *
 * 
 **********************************************************************************/
public class SummaryRanges {
	//自己实现的寒酸版
	public List<String> summaryRanges(int[] nums) {
		List<String> rtList = new ArrayList<String>();
		String range = "";
		int range_1 = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums.length == 1) {
				range_1 = nums[i];
				range = range_1 + "";
				rtList.add(range);
				break;
			}
			
			if (i == 0) {
				range_1 = nums[i];
			} else if (nums[i] - nums[i - 1] != 1) {
				if (range_1 != nums[i-1]) {
					range = range_1 + "->" + nums[i-1];
				} else {
					range = range_1 + "";
				}
				rtList.add(range);
				range_1 = nums[i];
				if(i == nums.length - 1){
					range = range_1 + "";
					rtList.add(range);
				}
			} else if (nums[i] - nums[i-1] == 1 && i == nums.length - 1) {
				range = range_1 + "->" + nums[i];
				rtList.add(range);
			} 
		}
		return rtList;
	}
    //参考他人更优雅的实现     o(n)
	public List<String> summaryRangesGrace(int[] nums){
		List<String> reltList = new ArrayList<String>();
		if(nums==null||nums.length==0) return reltList;
		int start = 0,end = 1;
		for(;end<=nums.length;end++){
			if(end==nums.length||nums[end]-nums[end-1]!=1){
				reltList.add(nums[start]==nums[end-1]?nums[start]+"":nums[start]+"->"+nums[end-1]);
				start = end;
			}
		}
		return reltList;
	}
	
	public static void main(String[] args) {
		int[] nums = { 1, 2, 3,8,9,10,13,16,17};
		System.out.println(new SummaryRanges().summaryRanges(nums));
		System.out.println(new SummaryRanges().summaryRangesGrace(nums));
	}
}
