// Source : https://oj.leetcode.com/problems/excel-sheet-column-title/
// Author : H.C.Y
// Date   : 2014-01-08

/**********************************************************************************
 * 
 * Given a positive integer, return its corresponding column title as appear in
 * an Excel sheet.
 *
 * For example:
 *
 * 1 -> A 2 -> B 3 -> C 26 -> Z 27 -> AA 28 -> AB
 *
 * 
 **********************************************************************************/
public class ExcelSheetColumnTitle {
	public String convertToTitle(int n) {
		return n==0 ? "" : convertToTitle(--n/26)+(char)('A'+(n % 26));
	}
	public static void main(String[] args) {
		System.out.println(new ExcelSheetColumnTitle().convertToTitle(1));
	}
}
