package basic.thread.simple;

/**
 * 命令：javap -v Synchronized.class 
 * 查看同步块和同步方法的编译指令
 * @author H.C.Y
 * @date 2016年9月8日 上午11:18:45 
 */
public class Synchronized {
	public static void main(String[] args) { // 对Synchronized Class对象进行加锁
		synchronized (Synchronized.class) {
			System.out.println("Hello");
		} // 静态同步方法，对Synchronized Class对象进行加锁
		m();
	}

	public static synchronized void m() {
	}
}
