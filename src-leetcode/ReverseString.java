// Source :https://leetcode.com/problems/reverse-string/
// Label: two pointer
// Author : H.C.Y
// Date   : 2016-06-12
/**********************************************************************************
 *
 *Write a function that takes a string as input and returns the string reversed.
 *
 *Example:
 *Given s = "hello", return "olleh".
 *
 * 
 **********************************************************************************/
public class ReverseString {
	public static void main(String[] args) {
		System.out.println(reverseStringByForce("hellohcy"));
		System.out.println(reverseStringByChange("hellohcy"));
	}
	/**
	 * 1.暴力求解
	 * 时间复杂度O(n)，遍历
	 * 空间复杂度O(n)，sb有个buffer数组
	 * @param s
	 * @return
	 */
   public static String reverseStringByForce(String s) {
	   StringBuilder sb = new StringBuilder();
	   for(int i=s.length()-1;i>=0;i--){
		   sb.append(s.charAt(i));
	   }
	   return sb.toString();
    }
	/**
	 * ２.two pointer交换
	 * 时间复杂度O(n/2)
	 * 空间复杂度O(n)，copy了一个buffer数组
	 * @param s
	 * @return
	 */
   public static String reverseStringByChange(String s){
	   if(s==null) return null;
	   char[] temp = s.toCharArray();
	   int from = 0;
	   int to = temp.length-1;
	   while(from<=to){
		   char i = temp[from];
		   temp[from]=temp[to];
		   temp[to]=i;
		   from++;
		   to--;
	   }
	   return new String(temp);
   }

}
