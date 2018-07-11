package dh01.research.basic.grammer.statictest;


public class Father {
	
	static {
		System.out.println("Father 静态块初始化！");
	}
	{
		System.out.println("Father 非静态块初始化！");
	}
	public Father(){
		System.out.println("Father 构造函数初始化！");
	}

}
