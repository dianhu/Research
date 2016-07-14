package hcy.sorting;

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
	 * 选择排序(扑克牌排序)
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
		for(int i=0;i<rvl.length;i++){
			int index = i;
			for(int j=i+1;j<rvl.length;j++){
				if(rvl[j]<rvl[index]){
					index = j;
				}
			}
			if(index!=i){
				int temp = rvl[index];
				rvl[index] = rvl[i];
				rvl[i] = temp;
			}
		}
		
		return rvl;
	}
	/**
	 * 快速排序
	 *快速排序是目前在实践中非常高效的一种排序算法，它不是稳定的排序算法，平均时间复杂度为O(nlogn)，最差情况下复杂度为O(n^2)。'
	 *它的基本思想是：通过一趟排序将要排序的数据分割成独立的两部分，其中一部分的所有数据都比另外一部分的所有数据都要小，
	 *然后再按此方法对这两部分数据分别进行快速排序，整个排序过程可以递归进行，以此达到整个数据变成有序序列。
	 *改进的快速排序：当局部有序，如果子表的数＝k的时候，可以用插入排序，提高效率
	 * @param n
	 * @return
	 */
	public static int[] quickSort(int[] data){
		if (null == data) return new int[0];
		int[] rvl = Arrays.copyOf(data,data.length);
		//return quickSort(rvl,0,rvl.length-1);
		//先用快排
		int[] rvl1 = quickSort(rvl,0,rvl.length-1);
		//再对局部排序的序列用插入排序
		return insertSort(rvl1);
	}
	
	private static int[] quickSort(int[] data,int low,int high){
		int k = 8;
		//if(low<hight){
		if(high-low>k){//当子表的元素<=k时，停止递归
			int mid = partition(data,low,high);//将表一分为儿
			quickSort(data,low,mid-1);//递归对低的子表排序
			quickSort(data,mid+1,high);//递归对高的子表排序
		}
		return data;
	}
	
	private static int partition(int[] data,int low,int high){
		int pivotKey = data[low];//选取基准元素
		while(low<high){//从表的两端交替的向中间扫描
			while(low<high &&data[high]>=pivotKey) high--;//从high 所指位置向前搜索，至多到low+1 位置。将比基准元素小的交换到低端
			swap(data,low,high);
			while(low<high &&data[low]<=pivotKey) low++;
			swap(data,low,high);
		}
		return low;//返回的枢纽的位置
	}
	
	private static void swap(int[] dest,int a,int b){
		int tmp = dest[a];
		dest[a] = dest[b];
		dest[b] = tmp;
	}
	
	/**
	 * 归并排序
	 * 时间复杂度O(nlogn),空间复杂度O(n)
	 * 归并排序就是使用递归，先分解数组为子数组，再合并数组。分而制之。
	 * @param n
	 * @return
	 */
    public static int[]  mergeSort(int[] data){
    	if (null == data) return new int[0];
		int[] rvl = Arrays.copyOf(data,data.length);
        int[] temp =new int[rvl.length];
        internalMergeSort(rvl, temp, 0, rvl.length-1);
        return rvl;
    }
    private static void internalMergeSort(int[] a, int[] temp, int left, int right){
        //当left==right的时，已经不需要再划分了
        if (left<right){
            int middle = (left+right)/2;
            internalMergeSort(a, temp, left, middle);          //左子数组
            internalMergeSort(a, temp, middle+1, right);       //右子数组
            mergeSortedArray(a, temp, left, middle, right);    //合并两个子数组
        }
    }
    // 合并两个有序子序列 arr[left, ..., middle] 和 arr[middle+1, ..., right]。temp是辅助数组。
    private static void mergeSortedArray(int arr[], int temp[], int left, int middle, int right){
        int i=left;     
        int j=middle+1;
        int k=0;
        while ( i<=middle && j<=right){
            if (arr[i] <=arr[j]){
                temp[k++] = arr[i++];
            }
            else{
                temp[k++] = arr[j++];
            }
        }
        while (i <=middle){
            temp[k++] = arr[i++];
        }
        while ( j<=right){
            temp[k++] = arr[j++];
        }
        //把数据复制回原数组
        for (i=0; i<k; ++i){
            arr[left+i] = temp[i];
        }
    }
	




	public static void main(String args[]) {
		//int data[] = { 5, 8, 4, 3, 7,9, 2, 6, 1,0 };
		int data[] = {5,8,4,3};
		
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
		
		System.out.println("--------------选择排序-------------");
		int[] rvl3 = insertSort(data);
		for (int i = 0; i < rvl3.length; i++) {
			System.out.printf("%2s", rvl3[i]);
		}
		System.out.println();
		
		System.out.println("--------------快速排序-------------");
		int[] rvl4 = quickSort(data);
		for (int i = 0; i < rvl4.length; i++) {
			System.out.printf("%2s", rvl4[i]);
		}
		System.out.println();
		
		System.out.println("--------------归并排序-------------");
		int[] rvl5 = mergeSort(data);
		for (int i = 0; i < rvl5.length; i++) {
			System.out.printf("%2s", rvl5[i]);
		}
		System.out.println();
		

	}

}
