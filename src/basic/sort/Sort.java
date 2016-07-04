package basic.sort;

import java.util.Arrays;

public class Sort {
	/**
	 * 冒牌排序
	 * 时间复杂度O(n²),((n+1)*n)/2,空间复杂度O(1)
	 * 算法原理：相邻的数据进行两两比较，小数放在前面，大数放在后面，这样一趟下来，
	 * 最大的数就被排在了最后一位，第二趟也是如此，如此类推，直到所有的数据排序完成
	 * 实用性：实现简单，适合<1000的数排序
	 * @param n
	 * @return
	 */
	public static int[] bubbleSort(int[] data) {
		if (null == data) return new int[0];
		int[] rvl = Arrays.copyOf(data,data.length);
		int temp = 0;
		for (int i = 0; i < rvl.length - 1; i++) {
			for (int j = 0; j < rvl.length - 1 - i; j++) {//每趟最后的数就是最大的，忽略排好的，减少查询量
				temp = rvl[j];
				if (rvl[j + 1] < rvl[j]) {
					rvl[j] = rvl[j + 1];
					rvl[j + 1] = temp;
				}
			}
		}
		return rvl;
	}
	/**
	 * 插入排序
	 * 时间复杂度O(n²),((n+1)*n)/2,空间复杂度O(1)
	 * 算法原理：将数据分为两部分，有序部分与无序部分，
	 * 一开始有序部分包含第1个元素，依次将无序的元素插入到有序部分，直到所有元素有序。
	 * 实用性：实现简单，是对冒泡排序的改进，当数组有序元素比较多时，速度就越快，
	 * 而冒泡排序还是一样的速度。适合<1000的数排序
	 * @param n
	 * @return
	 */
	public static int[] insertSort(int[] data) {
		if (null == data) return new int[0];
		int[] rvl = Arrays.copyOf(data,data.length);
		for(int i=1;i<rvl.length;i++){
			int insert = rvl[i];//要插入的值
			int j=i-1;
			while(j>=0&&insert<rvl[j]){//比插入值大的都后移一位
				rvl[j+1]=rvl[j];
				j--;
			}
			rvl[j+1]=insert;//插入适合位置
		}
		
		return rvl;
	}
	
	/**
	 * 选择排序
	 * 时间复杂度O(n²),((n+1)*n)/2,空间复杂度O(1)
	 * 算法原理：先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，然后，
	 * 再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。以此类推，直到所有元素均排序完毕。
	 * 实用性：n较小时
	 * @param n
	 * @return
	 */
	public static int[] selectSort(int[] data){
		if (null == data) return new int[0];
		int[] rvl = Arrays.copyOf(data,data.length);
		
		return rvl;
	}
	/**
	 * 快速排序
	 * 时间复杂度O(n²),((n+1)*n)/2,空间复杂度O(1)
	 * 算法原理：相邻的数据进行两两比较，小数放在前面，大数放在后面，这样一趟下来，
	 * 最大的数就被排在了最后一位，第二趟也是如此，如此类推，直到所有的数据排序完成
	 * 实用性：实现简单，适合<1000的数排序
	 * @param n
	 * @return
	 */
	public static int[] quickSort(int[] n){
		return null;
	}
	
	public static int[] mergeSort(int[] n){
		return null;
	}



	public static void main(String args[]) {
		int data[] = { 5, 8, 4, 3, 7, 2, 6, 1 };
		
		System.out.println("--------------冒泡排序-------------");
		int[] rvl1 = bubbleSort(data);
		for (int i = 0; i < rvl1.length; i++) {
			System.out.printf("%2s", rvl1[i]);
		}
		System.out.println();
		
		System.out.println("--------------插入排序-------------");
		int[] rvl2 = insertSort(data);
		for (int i = 0; i < rvl2.length; i++) {
			System.out.printf("%2s", rvl2[i]);
		}
		System.out.println();

	}

}
