package basic.array;

public class Array2Demo {

	public static void main(String[] args) {

		// 创建和打印不规则二维数组
		int arr[][];

		arr = new int[3][];// 现在说明为不规则数组

		arr[0] = new int[10];// arr[0]指向第一个一维数组
		arr[1] = new int[3];
		arr[2] = new int[4];

		// 赋值
		for (int i = 0; i < arr.length; i++) {

			for (int j = 0; j < arr[i].length; j++) {

				arr[i][j] = j;
			}

		}

		// 输出
		for (int i = 0; i < arr.length; i++) {

			for (int j = 0; j < arr[i].length; j++) {

				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

		/*
		 * 输出结果： 0 1 2 3 4 5 6 7 8 9 0 1 2 0 1 2 3
		 *///

	}

}
