package chapter01;

public class StringTest {
	private static void println(Object anObject){
		System.out.println(anObject);
	}
	
	private static void test1(){
		String a  = "a"+"b"+1;
		String b = "ab1";
		println(a==b);
	}
	
	private static String getA(){return "a";}
	private static void test2(){
		String a = "a";
		final String c = "a";
		String b = a + "b";
		String d = c + "b";
		String e = getA()+"b";
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