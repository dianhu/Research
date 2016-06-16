package basic.bit;

public class Main {

	public static void main(String[] args) {
		/******* max int ********/
		System.out.println((1 << 31) - 1);// int最大值，1向左移31位到第一位，由于第一位是符号位(0正数，１负数),减去1刚好符号位就是0，就是正数最大了
		System.out.println(~(1 << 31));// 取反和减1都是一样的效果
		/******* min int ********/
		System.out.println((1 << 31));
		System.out.println((1 << -1));
		/**
		 * 0000 0000 0000 0000 0000 0000 0000 0101 0000 0000 0000 0000 0000 0000
		 * 0010 1000 5左移3位相当于是5*2*2*2 = 40
		 */
		System.out.println(5 << 3);
		/**
		 * 0000 0000 0000 0000 0000 0000 0000 0101 0000 0000 0000 0000 0000 0000
		 * 0010 1000 5右3位相当于是5/(2*2*2) = 0
		 */
		System.out.println(5 >> 3);
		
	}
}
