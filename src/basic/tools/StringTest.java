package basic.tools;

public class StringTest {
	public static void main(String[] args) {
		String a = "a"+"b"+"c";
		String a1= "abc";
		System.out.println(a==a1);//常量池里有相同的字符串直接赋予引用
	}
}
