package dh01.research.basic.grammer.statictest;

public class Son extends Father{
	static {
		System.out.println("Son 静态块初始化！");
	}
	{
		System.out.println("Son 非静态块初始化！");
	}
	public Son(){
		System.out.println("Son 构造函数初始化！");
	}
	
}
