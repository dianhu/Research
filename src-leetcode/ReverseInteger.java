// Source : https://oj.leetcode.com/problems/reverse-integer/
// Author : H.C.Y
// Date   : 2015-02-09

/**********************************************************************************  
*Reverse digits of an integer.
*
*Example1: x = 123, return 321
*Example2: x = -123, return -321
*             
**********************************************************************************/
public class ReverseInteger {
	//use StringBuffer
	 public int reverse(int x){
		String s = String.valueOf(Math.abs(x));
		StringBuffer rs= new StringBuffer();
		for(int i=s.length()-1;i>=0;i--){
			rs.append(s.charAt(i));
		}
		try{
			return Integer.valueOf(x<0?"-"+rs.toString():rs.toString()); 
		}catch(NumberFormatException e){
			return 0;
		}
		
	 }
	 //use number local caculate
	 public int reverse1(int x){
		 int sum = 0;
		 while(Math.abs(x)!=0){
			 sum=sum*10+x%10;
			 x=x/10;
		 }
		 return sum;
	 }
	 public static void main(String[] args) {
		System.out.println(new ReverseInteger().reverse(96463241));
		System.out.println(new ReverseInteger().reverse1(96463241));
	}
}
