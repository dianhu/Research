package dh01.research.design.facade;

/**
 * Time : 18-7-28 下午10:24
 * Author : hcy
 * Description : 外观模式也叫门面模式
 * 外观模式提供了一个统一的接口，用来访问子系统中的一群接口。外观定义了一个高层接口，让子系统更容易使用。
 * 使用场景：
 * 1.包装多个复杂的子系统，提供一个简单的接口
 * 2.重新包装系统，隐藏不想暴露的接口
 */
public class App {
    //CPU
    public static class CPU {
        public void start(){
            System.out.println("启动CPU");
        }
    }
    //硬盘
    public static class Disk {
        public void start(){
            System.out.println("启动硬盘");
        }
    }
    //内存
    public static class Memory {
        public void start(){
            System.out.println("启动内存");
        }
    }

    //开机键
    public static class StartBtn {

        public void start(){
            new CPU().start();
            new Disk().start();
            new Memory().start();
        }
    }

    public static void main(String[] args) {
        new StartBtn().start();
    }

}
