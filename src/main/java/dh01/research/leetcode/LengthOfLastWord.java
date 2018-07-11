package dh01.research.leetcode;// Source : https://oj.leetcode.com/problems/length-of-last-word/
// Author : H.C.Y
// Date   : 2015-02-09

/********************************************************************************** 
*Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
*
*If the last word does not exist, return 0.
*
*Note: A word is defined as a character sequence consists of non-space characters only.
*
*For example, 
*Given s = "Hello World",
*return 5.              
**********************************************************************************/

public class LengthOfLastWord {
	public int lengthOfLastWord(String s) {
        String[] rts =s.split(" ");
        return rts.length==0?0:rts[rts.length-1].length();
    }
	public static void main(String[] args) {
		System.out.println(new LengthOfLastWord().lengthOfLastWord("  aaa  "));
	}
}
