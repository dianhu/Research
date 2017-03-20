package basic.grammer.testStatic;

/**
 * Time : 17-3-20 下午1:30
 * Author : hcy
 * Description :常量池
 * http://blog.csdn.net/qq_23013625/article/details/53219438
 */
public class StringTest {
    public static String a = "hello";
    public Integer d1=127;
    public Integer d2=128;
    public int d3= 128;

    public static void main(String[] args) {
        System.out.println(StringTest.a==StringTest1.a);
        System.out.println(new StringTest().d1==new StringTest1().d1);
        System.out.println(new StringTest().d2==new StringTest1().d2);
        System.out.println(new StringTest().d3==new StringTest1().d3);
    }
}

