package chapter01;

public class StringTest {
	private static void println(Object anObject){
		System.out.println(anObject);
	}
	
	private static void test1(){
		String a  = "a"+"b"+1;
		String b = "ab1";
		println(a==b);//直接从常量池中取，为ture
	}
	
	private static String getA(){return "a";}
	private static void test2(){
		String a = "a";
		final String c = "a";
		String b = a + "b";//字符串变量的连接动作，在编译阶段会被转化成StringBuilder的append操作，变量b最终指向Java堆上新建String对象，变量compare指向常量池的"ab"字符串，所以b!=compare。
		String d = c + "b";//加final的字符串变量会优化，还是从常量池中取，所以为true
		String e = getA()+"b";//同字符串变量连接
		String compare = "ab";
		println(b==compare);
		println(d==compare);
		println(e==compare);
	}
	
	public static void main(String[] args) {
		test1();
		println("===============");
		test2();
		println("===============");
		
	}

}