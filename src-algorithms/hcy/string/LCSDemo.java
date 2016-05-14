package hcy.string;

/**
 * 求解两个字符串的最长公共子序列 
 * LCS(Xm,Yn)=LCS(Xm-1,Yn-1)+x 当Xm=Yn ①
 * max{LCS(Xm-1,Yn),LCS(Xm,Yn-1)} 当Xm!=Yn②
 * 
 * 使用二维数字c[i,j]记录公共子序列的长度
 * c(i,j) = 0	     当i=0或j=0
 * 		= c(i-1,j-1)+1	   当i>0,j>0且Xi=Xj
 * 		= max{(c(i, j-1),c(i-1, j))}	当i>0,j>0且Xi!=Xj
 * @author H.C.Y
 * @date 2016年5月12日 上午11:27:56
 */
public class LCSDemo {
	public static void main(String[] args) {
		String str1 = "成都市高新区远大风景四期";
		String str2 = "姐儿堰远大四期";
		System.out.println("substring1:" + new String(str1));
		System.out.println("substring2:" + new String(str2));
		
		String lcs = new StringBuffer(getLCS(str1, str2)).reverse().toString();//需要反转一下
		
		System.out.println("LCS:"+lcs);
		System.out.println("LCS Length:"+lcs.length());
	}

	private static String getLCS(char[] str1, char[] str2) {
		int strLength1 = str1.length;
		int strLength2 = str2.length;
		String rst="";

		// 构造二维数组记录A[i]和B[j]的LCS的长度,并初始化边界值
		int[][] opt = new int[strLength1 + 1][strLength2 + 1];
		for(int i=0;i<=strLength1;i++){
			opt[i][0]=0;//第0列
		}
		for(int j=0;j<=strLength2;j++){
			opt[0][j]=0;//第0行
		}

		// 从前向后，动态规划计算所有子问题。也可从后到前。
		for (int i = 1; i<=strLength1;i++) {
			for (int j = 1;j<=strLength2; j++) {
				if (str1[i-1]==str2[j-1])//字符串还是从0开始
					opt[i][j] = opt[i - 1][j - 1] + 1;// 状态转移方程
				else
					opt[i][j] = Math.max(opt[i][j-1], opt[i-1][j]);// 状态转移方程
			}
		}
		
		int i = strLength1, j = strLength2;
		while (i !=0&&j!=0) {
			if (str1[i-1] == str2[j-1]) {
				rst+=str1[i-1]; 
				i--;
				j--;
			} else if (opt[i][j-1] >= opt[i-1][j])
				j--;
			else
				i--;
		}
		return rst;
	}

	public static String getLCS(String str1, String str2) {
		return getLCS(str1.toCharArray(), str2.toCharArray());
	}
}
