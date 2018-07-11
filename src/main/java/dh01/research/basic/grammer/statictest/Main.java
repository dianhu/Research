package dh01.research.basic.grammer.statictest;

import junit.framework.TestCase;

public class Main extends TestCase {
	public void test1() throws Exception{
		Class.forName("basic.grammer.testStatic.Father");
	}
	public void test2() throws Exception{
		Class.forName("basic.grammer.testStatic.Son");
	}
	public void test3() throws Exception{
		new Father();
		System.out.println("---------------------------");
		new Son();
	}
}
